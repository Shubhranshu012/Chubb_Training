package com.mongodbflux.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mongodbflux.model.Tutorial;
import com.mongodbflux.repository.TutorialRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorialService {

  @Autowired
  TutorialRepository tutorialRepository;

  public Flux<Tutorial> findAll() {
    return tutorialRepository.findAll();
  }

  public Mono<Tutorial> findById(String id) {
    return tutorialRepository.findById(id)
    		.switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }
  

  public Mono<Tutorial> save(Tutorial tutorial) {
    return tutorialRepository.save(tutorial);
  }

  public Mono<Tutorial> update(String id, Tutorial tutorial) {
    return tutorialRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(optionalTutorial -> {
          if (optionalTutorial.isPresent()) {
            tutorial.setId(id);
            return tutorialRepository.save(tutorial);
          }

          return Mono.empty();
        });
  }

  public Mono<Void> deleteById(String id) {
	    return tutorialRepository.findById(id)
	        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
	        .flatMap(tutorial -> tutorialRepository.deleteById(id));
	}
  public Mono<Void> deleteAll() {
    return tutorialRepository.deleteAll();
  }

  public Flux<Tutorial> findByPublished(boolean isPublished) {
	  	Flux<Tutorial> data=tutorialRepository.findByPublished(isPublished);
	  	return data;
  }
}
