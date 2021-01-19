package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.entity.Etudiant;
import org.example.repository.EtudiantRepository;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        //getById
        EtudiantRepository etudiantRepository = new EtudiantRepository();
        Etudiant simo = etudiantRepository.getById(2);
        System.out.println(simo.getNom()+" " + simo.getPrenom()+" "+ simo.getEmail()+" "+ simo.getTelephone()+" "+ simo.getId_spcialite());

        //Create Etudiant
        //Etudiant simo = new Etudiant();
        simo.setEmail("simo@gmail.com");
        simo.setId_spcialite(4);
        simo.setNom("simo");
        simo.setPrenom("zoubir");
        simo.setTelephone(1234);
        etudiantRepository.create(simo);

        //Update
        //Etudiant simo = new Etudiant();
        //simo.setEmail("simo@gmail.com");
        //simo.setId_spcialite(4);
        //simo.setNom("simo");
        //simo.setPrenom("zoubir");
        //simo.setTelephone(1234);
        //simo.setId(3);
        //etudiantRepository.update(simo);

        //delete
        //etudiantRepository.delete(1);

        //List

        /*List<Etudiant> liste = etudiantRepository.list();

        for (Etudiant etudiant : liste){
            System.out.println(etudiant.getNom()+" " + etudiant.getPrenom()+" "+ etudiant.getEmail()+" "+ etudiant.getTelephone()+" "+ etudiant.getId_spcialite());
        }*/
    }

}