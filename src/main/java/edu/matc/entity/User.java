package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a pet.
 */
@Table(name="user")
@Entity(name="User")
public class User {
    @Column(name = "user_email")
    private String userEmail;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "user_id")
    private int id;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //private Set<Pet> petsSet = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userEmail the user's email adress
     */
    public User(String userEmail) {
        this.userEmail = userEmail;
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
     * This method sets the user's email address
     * @param userEmail the user's email address
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * This method gets the user's email address.
     * @return the user's email address
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Gets a user's pet requests.
     * @return pet requests
     */
    /*public Set<Pet> getPetsSet() {
        return petsSet;
    }*/

    /**
     * Sets the petsSet.
     * @param petsSet pet requests Set
     */
    /*public void setPetsSet(Set<Pet> petsSet) {
        this.petsSet = petsSet;
    }*/

}

