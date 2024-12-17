package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a user.
 */
@Table(name="user")
@Entity(name="User")
public class User {
    @Column(name = "user_name")
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "user_id")
    private int id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Pet> petsSet = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName the userName
     */
    public User(String userName) {
        this.userName = userName;
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
     * This method sets the user's userName.
     * @param userName the user's userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method gets the user's userName.
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets a user's pets.
     * @return pets
     */
    public Set<Pet> getPetsSet() {
        return petsSet;
    }

    /**
     * Sets the petsSet.
     * @param petsSet pets Set
     */
    public void setPetsSet(Set<Pet> petsSet) {
        this.petsSet = petsSet;
    }

    /**
     * Adds a pet to the pets Set.
     * @param pet
     */
    public void addPet(Pet pet) {
        petsSet.add(pet);
        pet.setUser(this);
    }

    /**
     * Sets the pets of a User.
     * @param pet
     */
    public void setPet(Pet pet) {
        pet.setUser(this);
    }

    /**
     * Remove a pet.
     * @param pet a pet
     */
    public void removePet(Pet pet) {
        petsSet.remove(pet);
        pet.setUser(null);
    }

}

