package com.napier.sem.semcoursework.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *This class represents a language object that contains language data.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Language")
public class Language {
    /**
     *The language spoken.
     */
    @Id
    @Column(name = "language")
    private String language;
    /**
     *The total number of speakers for each language
     */
    @Column(name = "number_of_speakers")
    private Integer numberOfSpeakers;
    /**
     *The percentage of speakers in the world for each language
     */
    @Column(name = "percentage_of_world_population")
    private Double percentageOfWorldPopulation;
}
