package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AdditionalDetails> additionalDetailsSet = new HashSet<>();

    /**
     * Instantiates a new Pet.
     */
    public Pet() {
    }

    /**
     * Instantiates a new Pet.
     *
     * @param id the id
     * @param petAge the age
     * @param petSpecies the species
     * @param petColor the color
     * @param petWeight the weight
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
     * @param id the id
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
     * @param petAge the age
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
     * Gets a pet's additonal details.
     * @return additonal details
     */
    public Set<AdditionalDetails> getAdditionalDetailsSet() {
        return additionalDetailsSet;
    }

    /**
     * Sets the additionalDetailsSet.
     * @param additionalDetailsSet additional details Set
     */
    public void setAdditionalDetailsSet(Set<AdditionalDetails> additionalDetailsSet) {
        this.additionalDetailsSet = additionalDetailsSet;
    }

    /**
     * Adds an additional details to the additonalDetails Set.
     * @param additionalDetails
     */
    public void addAdditionalDetails(AdditionalDetails additionalDetails) {
        additionalDetailsSet.add(additionalDetails);
        additionalDetails.setPet(this);
    }

    /**
     * Sets the additional details of a Pet.
     * @param additionalDetails
     */
    public void setAdditionalDetails(AdditionalDetails additionalDetails) {
        additionalDetails.setPet(this);
    }

    /**
     * Remove additional details.
     * @param additionalDetails an item note
     */
    public void removeAdditionalDetails(AdditionalDetails additionalDetails) {
        additionalDetailsSet.remove(additionalDetails);
        additionalDetails.setPet(null);
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

    /**
     * This method compares two objects for equality.
     * @param o an Object
     * @return a boolean indicating whether both objects are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return petAge == pet.petAge && petWeight == pet.petWeight && id == pet.id && Objects.equals(petSpecies, pet.petSpecies) && Objects.equals(petColor, pet.petColor);
    }

    /**
     * The hashCode method.
     * @return a hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(petAge, petWeight, petSpecies, petColor, id);
    }
}

