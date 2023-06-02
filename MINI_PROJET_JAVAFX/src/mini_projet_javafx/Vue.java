/*
Format de ce code
   - Les imports nécessaires 
   - Des données membres : Controls des différents scènes 
   - Un constructeur sans arguments de la classe qui contient la construction des scènes 
   - Des getters pour tous les éléments de contrôle pour pouvoir les utiliser dans les autres classes 
   - Des getters des scènes 




*/
package mini_projet_javafx;



//---------------------------------------------- IMPORT nécessaires ------------------------------------------------------------------------------



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import mini_projet_javafx.Connexion; 
import mini_projet_javafx.Etudiant; 






public class Vue {
        private Connexion connexion = new Connexion();
    
    // ---------------------------------------- SCENE 1 ET COMPOSANTS DE LA SCENE 1 -------------------------------------------------------------
    
    // La scène 
    private Scene scene1;
    
    // Le layout manager 
    private GridPane gridPane1;
    
    //Les bouttons 
    private Button S_inscrire;
   
    private Button Liste_etudiants;
    
    //Les labels 
    
     private Label heading ; 

    private Label nom ; 
    private Label cne ; 
    private Label prenom ; 
    private Label anneeNaissance; 
    private Label adresse ; 
    private Label telephone ; 
    private Label email ; 
    private Label nationalite ; 
    private Label cin; 
    private Label anneBac ; 
    private Label mention_bac ; 
    private Label filliere ; 
    
    
    
    // Les textFields , DatePicker , ChoiceBox 
    
    private TextField tf1 ; 
    private TextField tf2 ; 
    DatePicker datePicker ; 
    private TextField tfcne; 
    private TextField tf4 ; 
    private TextField tf5 ;  
    private TextField tf6 ; 
    private TextField tf7 ; 
    private TextField tf8 ; 
    private TextField tf9 ; 
    private ChoiceBox <String>mention10 ; 
    private TextField tf11 = new TextField(); 
    private TextField tf12 = new TextField(); 
    
    
   
    // ---------------------------------------- SCENE 2 ET COMPOSANTS DE LA SCENE 2 -------------------------------------------------------------
    
    //La scène 
    private Scene scene2 ; 
    
    
    // Les layouts 
    private BorderPane borderPane2 ; 
    
    private VBox vbox1 ; 
    
    // Les bouttons 
    private Button Voir_profil ; 
    private Button Supprimer ; 
    private Button mettre_a_jour; 
    private Button Acceuil ; 
    
    //La table View 
    
    private TableView<Etudiant> tableView_etudiants  ; 
    
    // ---------------------------------------- SCENE 3 ET COMPOSANTS DE LA SCENE 3 -------------------------------------------------------------
    
    
    
    //Layout de la scène  3
    
    StackPane stack = new StackPane();
    private VBox vboxProfil ; 
    
    
    
    
    
    // -------------------------------------------------- CONSTRUCTEUR -------------------------------------------------------------------------------
    
    public Vue() {
        
        
        // ---------------------------------------- MANIPULATION DE LA SCENE 1 ---------------------------------------------------------------------------
        
        // Initialisation des composants de la scène 1
        gridPane1 = new GridPane();
        
        
        // ---------------------------------------- PROPRIETES DU GRID PANE  --------------------------------------------------------------------------
        
        
        // Définir la taille des colonnes en pourcentage par rapport à la largeur de la scène
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30); 
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50); 
        gridPane1.getColumnConstraints().addAll(column1, column2);
        gridPane1.setVgap(10);
        gridPane1.setHgap(0);
        gridPane1.setAlignment(Pos.CENTER);
        // Ajouter du padding avec des marges
        gridPane1.setPadding(new Insets(15)); 
        
        
        // -------------------------------------------- INITIALISATION DES BOUTTONS  ---------------------------------------------------------------------
        
        S_inscrire = new Button("S'inscrire");
        S_inscrire.setStyle("-fx-font-family: Georgia; -fx-font-weight: bold;");
        GridPane.setHalignment(S_inscrire, javafx.geometry.HPos.CENTER); // Centrer horizontalement le boutton
        Liste_etudiants = new Button("Liste des étudiants");
        Liste_etudiants.setStyle("-fx-background-color: orange; -fx-font-family: Georgia; -fx-font-weight: bold; -fx-text-fill: white;");
        GridPane.setHalignment(Liste_etudiants, javafx.geometry.HPos.RIGHT); 
        
        // -------------------------------------------- INITIALISATION DES LABELS ---------------------------------------------------------------------
        
        heading = new Label("Bienvenue à l'ENSAO");
        heading.setStyle("-fx-font-family: Georgia; -fx-font-size: 25px; -fx-font-weight: bold; -fx-text-fill: orange;");
        GridPane.setHalignment(heading, javafx.geometry.HPos.CENTER); // Centrer horizontalement le Label
        GridPane.setMargin(heading, new Insets(0, 0, 15, 0)); // Ajouter un espace de 5 pixels en bas du Label
        nom = new Label("Nom :");
        nom.setStyle("-fx-font-family: Georgia;"); 
        prenom = new Label("Prénom :");
        prenom.setStyle("-fx-font-family: Georgia;");
        anneeNaissance = new Label("Année de naissance :");
        anneeNaissance.setStyle("-fx-font-family: Georgia;");
        adresse = new Label("Adresse :");
        adresse.setStyle("-fx-font-family: Georgia;");
        telephone = new Label("Téléphone :");
        telephone.setStyle("-fx-font-family: Georgia;");
        email = new Label("Email :");
        email.setStyle("-fx-font-family: Georgia;");
        nationalite = new Label("Nationalité :");
        nationalite.setStyle("-fx-font-family: Georgia;");
        cne = new Label("CNE ( Code Massar)");
        cne.setStyle("-fx-font-family: Georgia;");
        cin = new Label("CIN :");
       cin.setStyle("-fx-font-family: Georgia;");
        anneBac = new Label("Année d'obtention du Bac :");
        anneBac.setStyle("-fx-font-family: Georgia;");
        mention_bac = new Label("Mention du Bac :");
        mention_bac.setStyle("-fx-font-family: Georgia;");
       
        filliere = new Label("Filière  :");
        filliere.setStyle("-fx-font-family: Georgia;");
        
        
        // -------------------------------------------- INITIALISATION DES TEXT FIELDS ----------------------------------------------------------------------
        tf1 = new TextField();
        tf2 = new TextField();
        datePicker = new DatePicker(); 
        tf4 = new TextField();
        tf5 = new TextField();
        tf6 = new TextField();
        tf7 = new TextField();
        tf8 = new TextField();
        tf9 = new TextField();
        tfcne = new TextField(); 
        tf11 = new TextField();
        mention10 = new ChoiceBox<>();
        // Ajouter les mentions de baccalauréat disponibles
        mention10.getItems().addAll(
            "Très bien",
            "Bien",
            "Assez bien",
            "Passable"
        );
        
       
       
        
        // -------------------------------------------- AJOUT DES CONTROLS AU LAYOUT  ---------------------------------------------------------------------
        
        gridPane1.add(heading, 0, 0, 2, 1);
        gridPane1.add(nom,0,1); 
        gridPane1.add(tf1,1,1); 
        gridPane1.add(prenom, 0, 2);
        gridPane1.add(tf2, 1, 2);
        gridPane1.add(anneeNaissance, 0, 3);
        gridPane1.add(datePicker, 1, 3);
        gridPane1.add(adresse, 0, 4);
        gridPane1.add(tf4, 1, 4);
        gridPane1.add(telephone, 0, 5);
        gridPane1.add(tf5, 1, 5);
        gridPane1.add(email, 0, 6);
        gridPane1.add(tf6, 1, 6);
        gridPane1.add(nationalite, 0, 7);
        gridPane1.add(tf7, 1, 7);
        gridPane1.add(cne, 0, 8);
        gridPane1.add(tfcne, 1, 8);
        gridPane1.add(cin, 0, 9);
        gridPane1.add(tf8, 1, 9);
        gridPane1.add(anneBac, 0, 10);
        gridPane1.add(tf9, 1, 10);
        gridPane1.add(mention_bac, 0, 11);
        gridPane1.add(mention10, 1, 11);
        gridPane1.add(filliere, 0, 12);
        gridPane1.add(tf11, 1, 12);
      
        gridPane1.add(S_inscrire, 0, 13, 2, 1);
        gridPane1.add(Liste_etudiants, 0, 14, 2, 1);
        
        
        
        // -------------------------------------------- AJOUT DU LAYOUT A LA SCENE 1  ---------------------------------------------------------------------
        scene1 = new Scene(gridPane1, 800, 600);
        
        

        
        
        
        // ---------------------------------------- MANIPULATION DE LA SCENE 2 ---------------------------------------------------------------------------
        
        
        //Initialisation des composants de la scene 2
        borderPane2 = new BorderPane(); 
        
        // -------------------------------------- INITIALISATION DU VBOX ET SES ELEMENTS  ---------------------------------------------------------------------------
        
        //Les différents bouttons 
        
        Voir_profil  = new Button("Voir profil "); 
        Acceuil = new Button("Acceuil"); 
        Acceuil.setStyle("-fx-font-family: Georgia; -fx-min-width: 150px; -fx-min-height: 30px; " );
        Voir_profil.setStyle("-fx-font-family: Georgia; -fx-min-width: 150px; -fx-min-height: 30px;");
        Supprimer =  new Button("Supprimer ");
        Supprimer.setStyle("-fx-font-family: Georgia; -fx-min-width: 150px; -fx-min-height: 30px;");
        mettre_a_jour = new Button("Mettre à jour");
        mettre_a_jour.setStyle("-fx-font-family: Georgia; -fx-min-width: 150px; -fx-min-height: 30px;");
    
        
        //Création du layout 
        
        vbox1 = new VBox(); 
        
        //Propriétés du layout 
        vbox1.setStyle("-fx-background-color: orange;");
        vbox1.setSpacing(20); // Ajouter un espacement de 20 pixels entre les éléments
        vbox1.setPadding(new Insets(15)); 
        vbox1.setAlignment(Pos.CENTER); // Centrer les éléments dans le VBox
        vbox1.getChildren().addAll(Acceuil , Voir_profil,mettre_a_jour,Supprimer);
        
       
       
        // -------------------------------------- AJOUT DU VBOX AU LAYOUT PRINCIPAL  ---------------------------------------------------------------------------
        
        borderPane2.setRight(vbox1);
        
        
        // -------------------------------------- CREATION DE LA TABLE VIEW  ---------------------------------------------------------------------------
        
        //Initialisation
        tableView_etudiants = new TableView<>();
        
        //Pour pouvoir aprés manipuler le boutton mettre à jour 
        tableView_etudiants.setEditable(true);

        // Initialisation des colonnes
        
        TableColumn<Etudiant, String> colonneNom = new TableColumn<>("Nom");
        TableColumn<Etudiant, String> colonnePrenom = new TableColumn<>("Prénom");
        TableColumn<Etudiant, String> colonneAnneeNaissance = new TableColumn<>("Année de naissance");
        TableColumn<Etudiant, String> colonneAdresse = new TableColumn<>("Adresse");
        TableColumn<Etudiant, Integer> colonneTelephone = new TableColumn<>("Téléphone");
        TableColumn<Etudiant, String> colonneCNE = new TableColumn<>("CNE");
        TableColumn<Etudiant, String> colonneCin = new TableColumn<>("CIN");
        TableColumn<Etudiant, String> colonneAnneeBac = new TableColumn<>("Année du bac");
        TableColumn<Etudiant, String> colonneEmail = new TableColumn<>("Email");
        TableColumn<Etudiant, String> colonneNationalite = new TableColumn<>("Nationalité");
        TableColumn<Etudiant, String> colonneMentionBac = new TableColumn<>("Mention du bac");

        // Définition des cellules pour chaque colonne
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colonneAnneeNaissance.setCellValueFactory(new PropertyValueFactory<>("anneeNaissance"));
        colonneAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        colonneTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        colonneCNE.setCellValueFactory(new PropertyValueFactory<>("cne"));
        colonneCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        colonneAnneeBac.setCellValueFactory(new PropertyValueFactory<>("anneeBac"));
        colonneEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colonneNationalite.setCellValueFactory(new PropertyValueFactory<>("nationalite"));
        colonneMentionBac.setCellValueFactory(new PropertyValueFactory<>("mentionBac"));

        // Ajout des colonnes à la table
        tableView_etudiants.getColumns().addAll(colonneNom, colonnePrenom, colonneAnneeNaissance, colonneAdresse, colonneTelephone,
        colonneCNE, colonneCin, colonneAnneeBac, colonneEmail, colonneNationalite, colonneMentionBac);




        
       
        //Ajout de la table View au layout 
        borderPane2.setCenter(tableView_etudiants);

        
        
        // -------------------------------------------- AJOUT DU LAYOUT A LA SCENE 2  ---------------------------------------------------------------------
        
        scene2 = new Scene(borderPane2, 800, 600);
        
        
        
        // -------------------------------------------- LAYOUT DE LA SCENE 3  ---------------------------------------------------------------------
        
        

        vboxProfil = new VBox();
        vboxProfil.setStyle("-fx-font-family: Georgia; -fx-font-size:20px;");
        vboxProfil.setAlignment(Pos.CENTER);

       
        StackPane.setAlignment(vboxProfil, Pos.CENTER);

        stack.getChildren().add(vboxProfil);
        

     
    }
    
    //Getters de tout ce que dont j'ai besoin dans le contrôleur 
    
    // ------------------------------------------- GETTERS DES ELEMENTS DE LA SCENE 1   ---------------------------------------------------------------------

    
    public Scene getScene1() {
        return scene1;
    }
    public Button getS_inscrire() {
        return S_inscrire;
    }

    public TextField getTfcne() {
        return tfcne;
    }
   
    public Button getListe_etudiants() {
        return Liste_etudiants;
    }

    public TextField getTf1() {
        return tf1;
    }

    public TextField getTf2() {
        return tf2;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public TextField getTf4() {
        return tf4;
    }

    public TextField getTf5() {
        return tf5;
    }

    public TextField getTf6() {
        return tf6;
    }

    public TextField getTf7() {
        return tf7;
    }

    public TextField getTf8() {
        return tf8;
    }

    public TextField getTf9() {
        return tf9;
    }

    public ChoiceBox<String> getMention10() {
        return mention10;
    }

    public TextField getTf11() {
        return tf11;
    }

    public TextField getTf12() {
        return tf12;
    }
   
    
    
    
    
    // -------------------------------------------- GETTERS DES ELEMENTS DE LA SCENE 2  ---------------------------------------------------------------------
    
    public Scene getScene2() {
        return scene2;
    }
    
      public Button getVoir_profil() {
        return Voir_profil;
    }

    public Button getSupprimer() {
        return Supprimer;
    }

    public Button getMettre_a_jour() {
        return mettre_a_jour;
    }
    
     public Button getAcceuil() {
        return Acceuil;
    }

    

    public VBox getVbox1() {
        return vbox1;
    }
    
    
    public TableView<Etudiant> getTableView_etudiants() {
        return tableView_etudiants;
    }
    // -------------------------------------------- GETTERS DES ELEMENTS DE LA SCENE 3  ---------------------------------------------------------------------
    
    public StackPane getStack(){
        return stack ; 
    }

    public VBox getVboxProfil() {
        return vboxProfil;
    }
    
    
    
    
}
    
  