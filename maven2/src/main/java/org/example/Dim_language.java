package org.example;
//se crea la clase para modelar esta tabla en la base de datos.


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="dim_language")
public class Dim_language {
    private  String Languagecode;
    private String Language;
    private LocalDateTime created_dt; //voy a utilizar created_dt para almacenar la fecha/hora en que
    //el objeto fue creado o el registro.
    private LocalDateTime update_dt; //con ella actualizo la última vez que se modificaron
    // los datos.

    private List<Dim_language>languages = new ArrayList<Dim_language>();

    //igual que las clases anteriores hacemos los sets y los gets


    public String getLanguagecode() {
        return Languagecode;
    }

    public String getLanguage() {
        return Language;
    }

    public LocalDateTime getCreated_dt() {
        return created_dt;
    }

    public LocalDateTime getUpdate_dt() {
        return update_dt;
    }

    public List<Dim_language> getLanguages() {
        return languages;
    }

    public void setLanguagecode(String languagecode) {
        Languagecode = languagecode;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setCreated_dt(LocalDateTime created_dt) {
        this.created_dt = created_dt;
    }

    public void setUpdate_dt(LocalDateTime update_dt) {
        this.update_dt = update_dt;
    }

    public void setLanguages(List<Dim_language> languages) {
        this.languages = languages;
    }
}


