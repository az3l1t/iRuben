package net.az3l1t.LanguageProject.Game.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    private String word;
    private String wordRussian;

    public String getRussianWord() {
        return wordRussian;
    }

    public void setWordRussian(String wordRussian) {
        this.wordRussian = wordRussian;
    }

    public Game(Long id, String word, String wordRussian) {
        this.id = id;
        this.word = word;
        this.wordRussian = wordRussian;
    }

    public Game(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
