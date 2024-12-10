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
     * Instantiates new AdditionalDetails.
     */
    public AdditionalDetails() {
    }

    public AdditionalDetails(String detailsText, Pet pet) {
        this.pet = pet;
        this.detailsText = detailsText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetailsText() {
        return detailsText;
    }

    public void setDetailsText(String detailsText) {
        this.detailsText = detailsText;
    }

    public Pet getPet() {
        return pet;
    }

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

