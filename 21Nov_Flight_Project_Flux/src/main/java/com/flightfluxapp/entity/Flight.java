package com.flightfluxapp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("flights")
public class Flight implements Persistable<String> {

    @Id
    private String flightNumber;

    private String airlineName;
    private String fromPlace;
    private String toPlace;

    @Transient    
    private boolean isNew;

    @Override
    public String getId() {
        return flightNumber;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
