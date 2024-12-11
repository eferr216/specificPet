package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;
import java.util.Objects;

/**
 * A class to represent additional details about a pet.
 */
@Table(name="additionaldetails")
@Entity(name="AdditionalDetails")
public class AdditionalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="details_id")
    private int id;

    @Column(name = "details_text")
    private String detailsText;

    @ManyToOne
    @JoinColumn(name="pet_id", foreignKey = @ForeignKey(name = "PET_ID_FK"))
    private Pet pet;

    /**
     * Instantiates a new AdditionalDetails.
     */
    public AdditionalDetails() {
    }

    /**
     * Instantiates a new AdditionalDetails.
     * @param detailsText the AdditionalDetails text
     * @param pet the Pet associated with this AdditionalDetails.
     */
    public AdditionalDetails(String detailsText, Pet pet) {
        this.pet = pet;
        this.detailsText = detailsText;
    }

    /**
     * This method gets the id of this AdditionalDetails.
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * This method sets the id of this AdditionalDetails.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method gets the text for an AdditionalDetails.
     * @return
     */
    public String getDetailsText() {
        return detailsText;
    }

    /**
     * This method sets the text for an AdditionalDetails.
     * @param detailsText the details text
     */
    public void setDetailsText(String detailsText) {
        this.detailsText = detailsText;
    }

    /**
     * This method returns the pet that is associated with this AdditionalDetails.
     * @return a Pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * This method sets the Pet that is associated with this AdditionalDetails
     * @param pet a Pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "AdditionalDetails{" +
                "id=" + id +
                ", detailsText='" + detailsText + '\'' +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdditionalDetails)) return false;
        AdditionalDetails additionalDetails = (AdditionalDetails) o;
        return id == additionalDetails.id && Objects.equals(detailsText, additionalDetails.detailsText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, detailsText);
    }
}

