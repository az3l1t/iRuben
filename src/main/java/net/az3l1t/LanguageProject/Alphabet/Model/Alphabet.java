package net.az3l1t.LanguageProject.Alphabet.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Alphabet {
    @Id
    @GeneratedValue
    private Long id;
    private Character letterArmenian;
    private String assosiation;

    public Alphabet(){

    }

    public Alphabet(Long id, Character letterArmenian, String assosiation) {
        this.id = id;
        this.letterArmenian = letterArmenian;
        this.assosiation = assosiation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getLetterArmenian() {
        return letterArmenian;
    }

    public void setLetterArmenian(Character letterArmenian) {
        this.letterArmenian = letterArmenian;
    }

    public String getAssosiation() {
        return assosiation;
    }

    public void setAssosiation(String assosiation) {
        this.assosiation = assosiation;
    }
}
