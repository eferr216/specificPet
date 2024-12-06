package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;

/**
 * A class to represent a pet.
 */
@Table(name="pet")
@Entity(name="Pet")
public class Pet {
    @Column(name = "pet_age")
    private int petAge;

    @Column(name = "pet_weight")
    private int petWeight;

    @Column(name = "pet_species")
    private String petSpecies;

    @Column(name = "pet_color")
    private String petColor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "pet_id")
    private int id;

    /**
     * Instantiates a new Pet.
     */
    public Pet() {
    }

    /**
     * Instantiates a new Pet.
     *
     * @param id
     * @param petAge
     * @param petSpecies
     * @param petColor
     * @param petWeight
     */
    public Pet(int id, int petAge, String petSpecies, String petColor, int petWeight) {

        this.id = id;
        this.petAge = petAge;
        this.petSpecies = petSpecies;
        this.petColor = petColor;
        this.petWeight = petWeight;
    }

    /**
     * The setter method for the id instance variable.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getter method for the id instance variable.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * This method sets the pet's age.
     * @param petAge
     */
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    /**
     * This method gets the pet's age.
     * @return the petAge
     */
    public int getPetAge() {
        return petAge;
    }

    /**
     * This method sets the pet's weight.
     * @param petWeight the pet weight
     */
    public void setPetWeight(int petWeight) {
        this.petWeight = petWeight;
    }

    /**
     * This method gets the pet's weight.
     * @return the petWeight
     */
    public int getPetWeight() {
        return petWeight;
    }

    /**
     * This method sets the pet's species.
     * @param petSpecies the pet species
     */
    public void setPetSpecies(String petSpecies) {
        this.petSpecies = petSpecies;
    }

    /**
     * This method gets the pet's species.
     * @return the petSpecies
     */
    public String getPetSpecies() {
        return petSpecies;
    }

    /**
     * This method sets the pet's color.
     * @param petColor the pet color
     */
    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    /**
     * This method gets the pet's color.
     * @return the petColor
     */
    public String getPetColor() {
        return petColor;
    }

    /**
     * The toString method.
     * @return a string representation of this class's object.
     */
    @Override
    public String toString() {
        return "Pet{"+
                "petAge='" + petAge + '\'' +
                ", petWeight='" + petWeight + '\'' +
                ", petSpecies='" + petSpecies + '\'' +
                "', petColor='" + petColor + "}'";
    }

}

