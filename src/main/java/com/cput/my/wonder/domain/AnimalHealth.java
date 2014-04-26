/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.my.wonder.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Khanya
 */

@Entity
public class AnimalHealth implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long healthID;

    private String condition;
    private String description;

    @OneToMany
    @JoinColumn(name = "healthID")
    private List<Animal> animal;

    @OneToMany
    @JoinColumn(name = "healthID")
    private List<Treatment> treatment;

    @OneToMany
    @JoinColumn(name = "healthID")
    private List<MedicalHistory> history;

    private AnimalHealth() {
    }

    private AnimalHealth(Builder builder) {
        this.animal = builder.animal;
        this.condition = builder.condition;
        this.description = builder.description;
        this.healthID = builder.healthID;
        this.treatment = builder.treatment;
        this.history = builder.history;

    }

    public static class Builder {

        private String condition;
        private String description;
        private List<Animal> animal;
        private List<Treatment> treatment;
        private Long healthID;
        private List<MedicalHistory> history;

        public Builder(String condition) {
            this.condition = condition;
        }

        public Builder id(Long value) {
            healthID = value;
            return this;
        }

        public Builder Condition(String condition) {
            this.condition = condition;
            return this;
        }

        public Builder Description(String description) {
            this.description = description;
            return this;
        }

        public Builder animals(List<Animal> animals) {
            this.animal = animals;
            return this;
        }

        public Builder history(List<MedicalHistory> history) {
            this.history = history;
            return this;

        }

        public Builder animalHealth(AnimalHealth health) {
            animal = health.getAnimal();
            treatment = health.getTreatment();
            condition = health.getCondition();
            healthID = health.getHealthID();
            description = health.getDescription();
            history = health.getHistory();
            return this;
        }

        public AnimalHealth build() {
            return new AnimalHealth(this);
        }

    }

    public String getCondition() {
        return condition;
    }

    public String getDescription() {
        return description;
    }

    public Long getHealthID() {
        return healthID;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public List<MedicalHistory> getHistory() {
        return history;
    }

    public List<Treatment> getTreatment() {
        return treatment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.healthID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AnimalHealth other = (AnimalHealth) obj;
        if (!Objects.equals(this.healthID, other.healthID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AnimalHealth{" + "healthID=" + healthID + '}';
    }

}