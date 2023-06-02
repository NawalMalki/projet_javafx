/*
Format de ce code : 
   - Les imports necéssaires
   - Données membres : 
       - instance du Stage 
       - instance de la classe Connexion
       - instance de la classe Vue
   - Constructeur :
       - Gestion des évènements sur les différents bouttons 
   - Des fonctions qui contiennent le code de la gestion des évènements sur ces bouttons .
     - de la scène 1 :
       - handleSInscrire() : Ajoute l'étudiant à la base de données
       - handleListeEtudiants()  : Affichage de la liste des étudiants dans la tableView 
     - de la scène 2 : 
       - handleAcceuil() : Revenir à la scène 1 
       - handleSupprimer : Suppression de l'étudiant de la base de données et de la tableView 
       - handleMettreAjour() : Mise à jour d'un étudiant : L'une de ses informations 
       - handleVoirProfil() : Aller vers la scène 3

     - de la scène 3 :
       - handleImprimer() : Impression de la fiche récapitulatif 

*/




package mini_projet_javafx;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.Printer;

import javafx.print.PrinterJob;
import javafx.scene.Node;


import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebView;
import javafx.stage.Stage;




public class Controleur {
    
    private Stage primaryStage; 
    private Connexion connexion;
    private Vue vue;
    private Text jobStatus = new Text();
    
    

    public Controleur(Vue vue) {
        // Assigner la vue passée en paramètre à la variable d'instance
        this.vue = vue;
        
        // Création d'une instance de Connexion
        connexion = new Connexion();
        
        // Configurer l'action sur le bouton "S'inscrire"
/* 
   J'ai essayé d'implémenter cette action sans utiliser une expression lambda.
   J'ai créé un gestionnaire d'événements (EventHandler) spécifique pour l'événement ActionEvent.
   Le bouton "S'inscrire" est la cible de cet événement.
   Dans la méthode handle, j'appelle la méthode handleSInscrire() pour gérer l'action.

   Si je n'avais pas créé la méthode handleSInscrire, j'aurais pu mettre le code directement ici.

   On peut également créer le gestionnaire d'événements de manière générale, puis l'appliquer au bouton de la manière suivante :

   EventHandler<ActionEvent> handler1 = new EventHandler<ActionEvent>() {
       @Override
       public void handle(ActionEvent event) {
           handleSInscrire();
       }
   };

   vue.getS_inscrire().setOnAction(handler1);
*/
vue.getS_inscrire().setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        handleSInscrire();
    }
});


        vue.getMettre_a_jour().setOnAction(e-> handleMettreAjour()); 
        vue.getListe_etudiants().setOnAction(e -> handleListeEtudiants());
        
        vue.getAcceuil().setOnAction(e-> handleAcceuil()); 
        
        
       
        vue.getVoir_profil().setOnAction(e-> handleVoirProfil());
        vue.getSupprimer().setOnAction(e-> handleSupprimer());
        
        
        
        
        
       

    }
    
// ----------------------------------- GESTION DES EVENEMENTS SUR LES BOUTTONS DE LA SCENE 1 -----------------------------------------------------
     
    
    // Configurer l'action sur le bouton Liste des étudiants 
      
    private void handleListeEtudiants() {
        // Remplissage des données de la table depuis la base de données
        List<Etudiant> etudiants = new ArrayList<>();



        Connection connection = connexion.getConnexion(); // Méthode pour obtenir la connexion

        try  {   
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Etudiant");  // la méthode executeQuery retourne un objet de type ResultSet
        while (resultSet.next()) {
           String _nom_affich = resultSet.getString("nom");
           String prenom_affich = resultSet.getString("prenom");
           String naissance = resultSet.getString("anneeNaissance"); 
           String adresse_affich = resultSet.getString("adresse"); 
           int tel = resultSet.getInt("telephone"); 
           String mail = resultSet.getString("email"); 
           String natio = resultSet.getString("nationalite"); 
           String cneaffich = resultSet.getString("cne"); 
           String cin_affich = resultSet.getString("cin"); 
           String anneeBac = resultSet.getString("anneeBac"); 
           String mention = resultSet.getString("mentionBac"); 
           String fil = resultSet.getString("filiere"); 
        
        
         //A chaque fois on crée un nouveau étudiant qu'on ajoute à la liste 
           Etudiant etudiant = new Etudiant(_nom_affich, prenom_affich,naissance ,   cneaffich ,  adresse_affich , tel , mail ,natio, cin_affich , anneeBac , mention , fil );
           etudiants.add(etudiant);
    }
} catch (SQLException e) {
    e.printStackTrace();
}


          // Supprimer les anciennes données de la table
            vue.getTableView_etudiants().getItems().clear();
          // Ajout des données à la table
            vue.getTableView_etudiants().getItems().addAll(etudiants);
        Scene scene2 = vue.getScene2();
        Stage primaryStage = (Stage) vue.getListe_etudiants().getScene().getWindow();
        primaryStage.setScene(scene2);
          
    }
     
    // Configurer l'action sur le bouton S'inscrire
    private void handleSInscrire() {
        // Récupération des valeurs saisies dans les TextFields
        
        String saisi_nom = vue.getTf1().getText();
        String saisi_prenom = vue.getTf2().getText();
        LocalDate dateNaissance = vue.getDatePicker().getValue();
        String saisi_naissance = (dateNaissance != null) ? dateNaissance.toString() : "";
        String saisi_adr = vue.getTf4().getText();
        String saisi_cne = vue.getTfcne().getText(); 
        String saisi_telephoneStr = vue.getTf5().getText();
        int saisi_telephone = (saisi_telephoneStr.isEmpty()) ? 0 : Integer.parseInt(saisi_telephoneStr);
        String saisi_email = vue.getTf6().getText();
        String saisi_natio = vue.getTf7().getText();
        String saisi_cinStr = vue.getTf8().getText();
        
        String saisi_annee_bac = vue.getTf9().getText();
        String saisi_mention = (vue.getMention10().getValue() != null) ? vue.getMention10().getValue().toString() : "";
        String saisi_filliere = vue.getTf11().getText();
        
        
        //Ici j'utilise la méthode de preparedStatement pour exécuter ma requête SQL

        // Requête d'insertion
        String query = "INSERT INTO Etudiant (nom, prenom, anneeNaissance, adresse, telephone, email, nationalite , cne, cin, anneeBac, mentionBac, filiere) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?)";

        try {
            // Obtenir la connexion
            PreparedStatement statement = connexion.getConnexion().prepareStatement(query);

            // Remplir les paramètres de la requête
                //setString pour une chaine decaractères et setInt pour un entier 
            statement.setString(1, saisi_nom);  //ça correspond au premier placeholder ?
            statement.setString(2, saisi_prenom); // ... ainsi de suite 
            statement.setString(3, saisi_naissance);
            statement.setString(4, saisi_adr);
            statement.setInt(5, saisi_telephone);
            statement.setString(6, saisi_email);
            statement.setString(7, saisi_natio);
            statement.setString(8, saisi_cne);
            statement.setString(9, saisi_cinStr);
            statement.setString(10, saisi_annee_bac);
            statement.setString(11, saisi_mention);
            statement.setString(12, saisi_filliere);

            // Exécution de la requête d'insertion
            statement.executeUpdate(); //executeUpdate()est utilisée pour les requêtes de type INSERT , DELETE , UPDATE
            

            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        
           
    }
    //Configurer l'action du boutton mettre à jour 
    
    
    
// ----------------------------------- GESTION DES EVENEMENTS SUR LES BOUTTONS DE LA SCENE 2 -----------------------------------------------------
    
     
    
//---------------------------------------------------- MISE A JOUR --------------------------------------------------------------------------------
    private void handleMettreAjour() {
    // Vérifier si une ligne est sélectionnée
    Etudiant ligneSelectionnee = vue.getTableView_etudiants().getSelectionModel().getSelectedItem();
    if (ligneSelectionnee != null) {
        // Traitement 
        
        Label indication = new Label("Veuillez choisir le champ à modifier"); 
        indication.setStyle("-fx-font-family: Georgia; ");
        
        ChoiceBox<String> choix = new ChoiceBox<>();
        choix.getItems().addAll("nom", "prenom", "anneeNaissance", "adresse", "telephone", "cne", "cin", "anneeBac", "email", "nationalite", "mentionBac");
        choix.setStyle("-fx-font-family: Georgia; ");
        
        TextField modif = new TextField();
        
        Button ok = new Button("✔"); 
        VBox vbox = vue.getVbox1();
        
        int index1 = vbox.getChildren().indexOf(vue.getMettre_a_jour()) + 1;
        vbox.getChildren().add(index1, indication);
        int index2 = vbox.getChildren().indexOf(indication) + 1;
        vbox.getChildren().add(index2, choix); 
        
        choix.setOnAction(event -> {
            int index3 = vbox.getChildren().indexOf(choix) + 1;
            vbox.getChildren().add(index3, modif);
            int index4 = vbox.getChildren().indexOf(modif)+1 ; 
            vbox.getChildren().add(index4,ok); 
        });
            ok.setOnAction(event -> {
            String champSelectionne = choix.getValue();
            String nouvelleValeur = modif.getText();

            if (champSelectionne != null && nouvelleValeur != null) {
                // Mettre à jour le champ sélectionné dans l'objet ligneSelectionnee
                if (champSelectionne.equals("nom")) {
                    ligneSelectionnee.setNom(nouvelleValeur);
                } else if (champSelectionne.equals("prenom")) {
                    ligneSelectionnee.setPrenom(nouvelleValeur);
                } else if (champSelectionne.equals("anneeNaissance")) {
                    ligneSelectionnee.setAnneeNaissance(nouvelleValeur);
                } else if (champSelectionne.equals("adresse")) {
                    ligneSelectionnee.setAdresse(nouvelleValeur);
                } else if (champSelectionne.equals("telephone")) {
    // Vérifier si la nouvelle valeur est un entier valide
    try {
        int telephone = Integer.parseInt(nouvelleValeur);
        ligneSelectionnee.setTelephone(telephone);
    } catch (NumberFormatException e) {
        
    }
                } else if (champSelectionne.equals("cne")) {
                    ligneSelectionnee.setCne(nouvelleValeur);
                } else if (champSelectionne.equals("cin")) {
                    ligneSelectionnee.setCin(nouvelleValeur);
                } else if (champSelectionne.equals("anneeBac")) {
                    ligneSelectionnee.setAnneeBac(nouvelleValeur);
                } else if (champSelectionne.equals("email")) {
                    ligneSelectionnee.setEmail(nouvelleValeur);
                } else if (champSelectionne.equals("nationalite")) {
                    ligneSelectionnee.setNationalite(nouvelleValeur);
                } else if (champSelectionne.equals("mention")) {
                    ligneSelectionnee.setMentionBac(nouvelleValeur);
                }
               

                // Rafraîchir la TableView
                vue.getTableView_etudiants().refresh();

                //Modification dans la base de données
                     // Etape 1 : Supprimer l'ancienne valeur du champ
                     String id = ligneSelectionnee.getCin(); 
                     SupprimerAncienChamp(id,champSelectionne); 
                     // Etape 2 : Inserer la nouvelle valeur
                     InsererNouvelleValeur(id , nouvelleValeur,champSelectionne); 
            }
            // Supprimer le champ "indication"
vbox.getChildren().remove(indication);

// Supprimer le champ "choix"
vbox.getChildren().remove(choix);

// Supprimer le champ "modif"
vbox.getChildren().remove(modif);

// Supprimer le bouton "ok"
vbox.getChildren().remove(ok);
        });
            
           
            
        
       
}
                }
    


 
    //Fonction de suppression de l'ancien champ
    private void SupprimerAncienChamp(String id,String champ){
         String sql_supp = "UPDATE Etudiant SET " + champ + " = NULL WHERE cin = ?";
    try {
        PreparedStatement statement = connexion.getConnexion().prepareStatement(sql_supp);
        statement.setString(1, id);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    
    // Fonction d'insertion de la nouvelle valeur
    private void InsererNouvelleValeur(String id , String nouvelleValeur, String champ) {
    String sql_insert = "UPDATE Etudiant SET " + champ + " = ? WHERE cin = ?";
    try {
        PreparedStatement statement = connexion.getConnexion().prepareStatement(sql_insert);
        statement.setString(1, nouvelleValeur);
        statement.setString(2, id);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
     //Configurer l'action du boutton imprimer
    
    
 //---------------------------------------------------- FIN - MISE A JOUR -------------------------------------------------------------------------------- 
    
    
    
    
    private void handleImprimer(Node node) {
    jobStatus.textProperty().unbind();


    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null) {
        jobStatus.textProperty().bind(job.jobStatusProperty().asString());

        // Mise à l'échelle de la scène pour s'adapter à la taille du papier A4
        PageLayout pageLayout = Printer.getDefaultPrinter().getDefaultPageLayout();
        double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        node.getTransforms().add(new Scale(scaleX, scaleY));

        boolean printed = job.printPage(node);
        if (printed) {
            job.endJob();
        } else {
            jobStatus.textProperty().unbind();
           
        }

        // Supprimer la mise à l'échelle après l'impression
        node.getTransforms().remove(node.getTransforms().size() - 1);
    } 
}


     
      
     
    //Configurer l'action du boutton Voir profil
  private void handleVoirProfil() {
    // Récupérer l'étudiant sélectionné dans la table
    Etudiant etudiantSelectionne = vue.getTableView_etudiants().getSelectionModel().getSelectedItem();

    if (etudiantSelectionne != null) {
        // Effacer le contenu précédent de la VBox
        VBox vboxProfil = vue.getVboxProfil();
        vboxProfil.getChildren().clear();
        vboxProfil.setSpacing(10);

        // Créer les labels avec les informations de l'étudiant
        Label heading = new Label("Profil de l'étudiant");
        heading.setStyle("-fx-font-family: Georgia; -fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: orange;");
        Label labelNom = new Label("Nom : " + etudiantSelectionne.getNom());
        Label labelPrenom = new Label("Prénom : " + etudiantSelectionne.getPrenom());
        Label labelanneNai = new Label("Année de naissance :" + etudiantSelectionne.getAnneeNaissance());
        Label labelcne = new Label("CNE ( Code Massar ) :" + etudiantSelectionne.getCne());
        Label labelcin = new Label("CIN :" + etudiantSelectionne.getCin());
        Label labelanneBac = new Label("Année d'obtention du bac :" + etudiantSelectionne.getAnneeBac());
        Label labelMention = new Label("Mention du bac :" + etudiantSelectionne.getMentionBac());
        Label labelNatio = new Label("Nationalité :" + etudiantSelectionne.getNationalite());
        Label labelAdr = new Label("Adresse :" + etudiantSelectionne.getAdresse());
        Label labelTel = new Label("Téléphone :" + etudiantSelectionne.getTelephone());
        Label labelEmail = new Label("Adresse Email :" + etudiantSelectionne.getEmail());

        // Créer le bouton "Imprimer"
        Button imprimer = new Button("Imprimer fiche récapitulative");
        imprimer.setStyle("-fx-font-size: 15px; -fx-background-color: orange; -fx-font-family: Georgia; -fx-font-weight: bold; -fx-text-fill: white;");
        imprimer.setOnAction(e -> handleImprimer(vboxProfil));

        // Ajouter les éléments à la VBox et la centrer
        vboxProfil.getChildren().addAll(heading, labelNom, labelPrenom, labelanneNai, labelcne, labelcin, labelanneBac, labelMention, labelNatio, labelAdr, labelTel, labelEmail);
        vboxProfil.setAlignment(Pos.CENTER);

        // Créer le BorderPane principal
        BorderPane principal = new BorderPane();
        principal.setCenter(vue.getStack());

        // Créer le conteneur HBox pour le bouton "Imprimer"
        HBox hbox = new HBox(imprimer);
        hbox.setPadding(new Insets(-10, 0, 10, 0));
        hbox.setAlignment(Pos.CENTER);
        principal.setBottom(hbox);

        // Créer la scène avec le BorderPane principal
        Scene scene3 = new Scene(principal, 460, 600);
        StackPane.setMargin(vboxProfil, new Insets(0, 0, 0, scene3.getWidth() * 0.001)); // Marge de 10% de la largeur de la scène

        // Mettre à jour la scène du stage principal
        Stage primaryStage = (Stage) vue.getVoir_profil().getScene().getWindow();
primaryStage.setScene(scene3);
}
}



     
     
    //Configurer l'action du boutton de retour à la page initiale
    //Je l'ai fait parce que je trouve que ça facilite l'utilisation à l'utilisateur 
    private void handleAcceuil(){
        Scene scene1 = vue.getScene1();
        Stage primaryStage = (Stage) vue.getAcceuil().getScene().getWindow();
        primaryStage.setScene(scene1);
     }
     
     
//---------------------------------------------------- SUPPRESSION --------------------------------------------------------------------------------
   
    
            //configurer l'action sur le boutton supprimer
    private void handleSupprimer() {
        //Récupérer la ligne selectionnée par l'utilisateur dans la tableView 
        Etudiant etudiantSelectionne = vue.getTableView_etudiants().getSelectionModel().getSelectedItem();
        
        //Suppression de la base de données et de la table View 
    if (etudiantSelectionne != null) {
        //Supprimer l'étudiant de la base de données 
        supprimerEtudiant(etudiantSelectionne.getCin());
        //Supprimer l'étudiant de la table View 
        vue.getTableView_etudiants().getItems().remove(etudiantSelectionne);
    }
}

    private void supprimerEtudiant(String cin) {
    String query = "DELETE FROM Etudiant WHERE cin = ?"; //ça ne peut déclencher aucune exception donc je peux la mettre à l'extérieur de try
    try {
        PreparedStatement statement = connexion.getConnexion().prepareStatement(query);
        statement.setString(1, cin);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


//---------------------------------------------------- FIN - SUPPRESSION --------------------------------------------------------------------------------










 

}