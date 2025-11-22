package com.mongodbflux.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mongodbflux.model.Tutorial;
import com.mongodbflux.service.TutorialService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialService tutorialService;

  @GetMapping("/tutorials")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Tutorial> getAllTutorials() {
    
      return tutorialService.findAll();
  }

  @GetMapping("/tutorials/{id}")
  public Mono<Tutorial> getTutorialById(@PathVariable("id") String id) {
      return tutorialService.findById(id);
  }
  
  @PostMapping("/tutorials")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Object> createTutorial(@RequestBody @Valid Tutorial tutorial) {
	  return tutorialService.save(Tutorial.builder().title(tutorial.getTitle()).description(tutorial.getDescription()).published(false).build())
			  .map(saved -> Map.of("id", saved.getId()));
  }

  @PutMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Map<String, String>> updateTutorial(@PathVariable("id") String id,@RequestBody @Valid Tutorial tutorial) {

      return tutorialService.update(id, tutorial)
              .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
              .map(updated -> Map.of("id", updated.getId()));
  }
  
  @DeleteMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteTutorial(@PathVariable("id") String id) {
    return tutorialService.deleteById(id);
  }

  @DeleteMapping("/tutorials")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteAllTutorials() {
    return tutorialService.deleteAll();
  }
  @GetMapping("/tutorials/published")
  public Mono<ResponseEntity<Flux<Tutorial>>> findByPublished() {
      Flux<Tutorial> data = tutorialService.findByPublished(true);

      return data.hasElements()
              .flatMap(hasElements -> {
                  if (hasElements) {
                      return Mono.just(ResponseEntity.ok(data));
                  } else {
                      return Mono.just(ResponseEntity.notFound().build());
                  }
              });
  }

}