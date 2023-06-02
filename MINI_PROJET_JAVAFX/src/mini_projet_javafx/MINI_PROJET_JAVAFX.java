
package mini_projet_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MINI_PROJET_JAVAFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Instanciation de la vue
        Vue vue = new Vue();
        
        // Instanciation du contrôleur
        Controleur controleur = new Controleur(vue);
        
        // Obtention de la scène de la vue
        Scene scene1 = vue.getScene1();
        
        primaryStage.setTitle("Bienvenue à l'ENSAO");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
