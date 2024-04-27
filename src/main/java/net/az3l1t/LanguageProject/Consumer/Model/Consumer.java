package net.az3l1t.LanguageProject.Consumer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Consumer {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String password;
    private String email;
    private int letter;
    private String jwtToken;

    public Consumer(Long id, String nickname, String password, String email, int letter, String jwtToken) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.letter = letter;
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public int addLetter(){
        letter++;
        return letter;
    }

    /*
        Пустой конструктор для DB
    */
    public Consumer(){
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }
}
