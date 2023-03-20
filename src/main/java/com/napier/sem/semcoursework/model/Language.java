package com.napier.sem.semcoursework.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Language")
public class Language {
    @Id
    @Column(name = "language")
    private String language;
    private double percentage;
    @Column(name = "number_of_speakers")
    private Integer numberOfSpeakers;
    @Column(name = "percentage_of_world_population")
    private Double percentageOfWorldPopulation;

}
