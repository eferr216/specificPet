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
    @Column(name = "user_name")
    private String userName;

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
    public String getuserName() {
        return userName;
    }

}

