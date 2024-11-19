package org.example;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
// creamos y empezamos la sesión
        System.out.println("hola bienvenido!");
        Session newSession = null;
        try {
            newSession = new Configuration().configure().buildSessionFactory().openSession();
        }catch (Throwable ex){
            System.err.println("Ha fallado la creación de la Sesión " + ex);
            throw new ExceptionInInitializerError(ex);
        }
        //consultamos la tabla city
        Query qDL = newSession.createQuery("From Dim_Language", Dim_language.class);
        List<Dim_language> resultListDL = qDL.list();
        System.out.println("numero de idiomas" + resultListDL.size());
        for (Dim_language next : resultListDL) {
            System.out.println("siguientes lenguajes: " + next.getLanguage());
        }

        //insertamos el registro en la tabla Dim_Language
        try{
            //Iniciamos una transacción para guardar un nuevo lenguaje.
            newSession.beginTransaction();
            Dim_language new_language = new Dim_language();
            new_language.setLanguagecode("Ita");
            new_language.setLanguage("Italian");
            new_language.setCreated_dt(java.time.LocalDateTime.now());
            new_language.setUpdate_dt(java.time.LocalDateTime.now());
            newSession.save(new_language);
            newSession.getTransaction().commit();
        }catch(Exception ex){  //manejamos cualquier excepción durante la Transacción
            System.out.println("SQLException:" + ex.getMessage());
        }




    }
}