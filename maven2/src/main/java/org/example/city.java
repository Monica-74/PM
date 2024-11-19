//esta clase modela la tabla de la base de datos world.
//importamos las librerias y se crean las variables que modelan las columnas de las tablas.
//se crea una lista de objetos de la clase city para recuperar las consultas sobre la tabla.

package org.example;
import javax.persistence.Entity;  //para que me funcionaran he tenido que actualizar en el pom.xml una version nueva.
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity  //esto sirve para Marca la clase como una entidad JPA. Es obligatorio que cada entidad tenga un identificador primario,
// así este identificador identifica de manera única cada instancia de la entidad en la base de datos.
@Table (name="city")  //esto significa que Especifica que la clase city está mapeada a una tabla llamada city en la base
// de datos. Esto es útil para asegurar que JPA utilice el nombre correcto de la tabla, especialmente si difiere del nombre de la clase.

public class city {
    private int ID;   //se crean las variables que modelan las columnas de las tablas.
    private String Name;
    private String CountryCode;
    private String District;
    private int Population;
    private List<city> cities = new ArrayList<city>();  //una lista para la consulta de las ciudades

    // creamos los get y set para recuperar y establecer los valores de las variables


    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getDistrict() {
        return District;
    }

    public int getPopulation() {
        return Population;
    }

    public List<city> getCities() {
        return cities;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setCountryCode(String countryCode) {
        this.CountryCode = countryCode;
    }

    public void setDistrict(String district) {
        this.District = district;
    }

    public void setPopulation(int population) {
        this.Population = population;
    }

    public void setCities(List<city> cities) {
        this.cities = cities;
    }
}
