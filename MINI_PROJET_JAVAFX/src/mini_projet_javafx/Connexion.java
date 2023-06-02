
package mini_projet_javafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    String url = "jdbc:mysql://localhost:3306/projet"; 
    String user = "root";
    String password = ""; 

    private Connection connexion;

    public Connexion() {
        // Initialisation de la connexion à la base de données
        try {
            connexion = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void close() {
        try {
            if (connexion != null) {
                connexion.close();
                
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la connexion à la base de données : " + e.getMessage());
        }
    }
}



