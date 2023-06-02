
package mini_projet_javafx;

public class Etudiant {
    private String nom; 
    private String prenom;
    private String anneeNaissance;
    private String cne ; 
    private String adresse;
    private int telephone;
    private String email;
    private String nationalite;
    private String cin;
    private String anneeBac;
    private String mentionBac;
   
  
    private String filiere;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String anneeNaissance , String cne, String adresse, int telephone, String email,
                    String nationalite, String cin, String anneeBac, String mentionBac
                    , String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.cne=cne ; 
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.nationalite = nationalite;
        this.cin = cin;
        this.anneeBac = anneeBac;
        this.mentionBac = mentionBac;
        
        
        this.filiere = filiere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCne() {
        return cne;
    }
    
    

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(String anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getCin() {
        return cin;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }
    
    

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAnneeBac() {
        return anneeBac;
    }

    public void setAnneeBac(String anneeBac) {
        this.anneeBac = anneeBac;
    }

    public String getMentionBac() {
        return mentionBac;
    }

    public void setMentionBac(String mentionBac) {
        this.mentionBac = mentionBac;
    }


   

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    
}
