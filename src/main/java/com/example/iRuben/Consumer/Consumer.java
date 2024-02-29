package com.example.iRuben.Consumer;

import jakarta.persistence.*;

@Entity
@Table
public class Consumer {
    @Id
    @SequenceGenerator(
            name="consumer_sequence",
            sequenceName="consumer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "consumer_sequence"
    )
    private Long id;
    private String username;
    private String email;
    private String password;
    private int experience;

    public int addExperience(){
        experience++;
        return experience;
    }

    public Consumer(){
    }

    public Consumer(String username, String email, String password, int experience) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.experience = experience;
    }

    public Consumer(Long id, String username, String email, String password, int experience) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.experience = experience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}