package Services;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import Classe.Reservation;
import Classe.Table;
import DAO.ConnexionBDD;
import DAO.EcritureBDD;
import DAO.LectureBDD;
import DAO.SupprimerBDD;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Services {

    private static Connection connection;

    //Attribue 4 tables à "NOMBRE_DE_TABLES"
    
    private static final int NOMBRE_DE_TABLES = 4;

    static {
        try {
            connection = ConnexionBDD.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
  //Fonctionnalité d'enregistrer Particulier pour formulaire de reservation
    
    public static void enregistrementReservation(String numTel, String nom, String prenom, String nbPersonne, String date,String heureDebut, String heureFin) {
        EcritureBDD ecritureBDD = new EcritureBDD(connection);
        LectureBDD lectureBDD = new LectureBDD(connection);

        try {
            List<Table> tablesDisponibles = lectureBDD.obtenirTablesDisponibles(date, heureDebut, heureFin,Integer.parseInt(nbPersonne));

            //Veirifie si une table est disponible 
            
            if (!tablesDisponibles.isEmpty()) {
                int idClient = ecritureBDD.insererClientEtRecupererId(numTel, nom, prenom);
                ecritureBDD.insererReservation(nbPersonne, date, heureDebut, heureFin, idClient);
                afficherConfirmation("Reservation Ajouté");
            } else {
                afficherConfirmation("Aucune table disponible pour la réservation.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Fonctionnalité d'enregistrer Pro pour formulaire de reservation
    
    public static void enregistrementReservationPro(String numTel, String nbPersonne, String date, String heureDebut, String heureFin, String societe) {
        EcritureBDD ecritureBDD = new EcritureBDD(connection);
        LectureBDD lectureBDD = new LectureBDD(connection);

        try {
            Table tableDisponible = lectureBDD.obtenirTableDisponible(date, heureDebut, heureFin,Integer.parseInt(nbPersonne));

            //Veirifie si une table est disponible 
            
            if (tableDisponible != null) {
                int idClient = ecritureBDD.insererClientEtRecupererIdPro(societe, numTel);
                ecritureBDD.insererReservation(nbPersonne, date, heureDebut, heureFin, idClient);
                afficherConfirmation("Reservation Ajouté");
            } else {
                afficherConfirmation("Aucune table disponible pour la réservation.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Fonctionnalité de suppresion de Reservation pour le boutton dans la vue VueListeReservation
    
    public void supprimerReservation(Reservation reservation) {
        SupprimerBDD supprimerBDD = new SupprimerBDD(connection);

        try {
            supprimerBDD.supprimerReservation(reservation);

            afficherConfirmation("Réservation supprimée avec succès!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Fonction pour la Pop-UP
    //https://stackoverflow.com/questions/52417159/how-do-i-change-the-icon-of-an-alert-dialog
    
    public static void afficherConfirmation(String message) {
        Alert alert = new Alert(AlertType.CONFIRMATION);

        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //Fonction pour recup toute les Reservations à afficher
    
    public List<Reservation> obtenirListeReservations() {
        LectureBDD lectureBDD = new LectureBDD(connection);

        return lectureBDD.obtenirListeReservations();
    }

    //Source aide pour le code suivant :
    //https://jenkov.com/tutorials/java-nio/path.html
    
    public void chargerFichierSelectionne(Path resultatFichierSelectionner) {
        Path destinationDossier = Paths.get("C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\FichierWeb",resultatFichierSelectionner.getFileName().toString());

        copierFichier(resultatFichierSelectionner, destinationDossier,"Fichier copié vers FichierWeb : " + destinationDossier.toAbsolutePath(),"Erreur lors de la copie du fichier : ");
    }

    //Source aide pour le code suivant :
    //https://stackoverflow.com/questions/74843217/how-to-read-all-lines-from-a-java-file-and-split-the-elements-that-are-divided-b
    
    public void traiterFichier(Path fichier) throws IOException {
        List<String> lignes = Files.readAllLines(fichier);
        
        //Fonctionnalité pour traiter chaque élément du fichier et les classer 
        //Prend en compte le changement de parties grace aux ";"
        
        for (String ligne : lignes) {
            String[] parties = ligne.split(";");

            if (parties.length == 8) {
                String numTel = parties[0];
                String nom = parties[1];
                String prenom = parties[2];
                String nbPersonne = parties[3];
                String date = parties[4];
                String heureDebut = parties[5];
                String heureFin = parties[6];
                String societe = parties[7];

                //Verifie si dans le .txt la valeur société est = à NULL
                
                if ("NULL".equals(societe)) {
                    enregistrerParticulierDansBDD(numTel, nom, prenom, nbPersonne, date, heureDebut, heureFin);
                } else {
                    enregistrerProDansBDD(numTel, nom, prenom, nbPersonne, date, heureDebut, heureFin, societe);
                }
            } else {
                afficherConfirmation("Format incorrect dans le fichier : " + ligne);
            }
        }
        afficherConfirmation("Traitement du fichier terminé avec succès!");
    }
    
    //Fonctionnalité d'enregistrement Particulier pour le fichier txt
    
    private void enregistrerParticulierDansBDD(String numTel, String nom, String prenom, String nbPersonne,String date, String heureDebut, String heureFin) {
        EcritureBDD ecritureBDD = new EcritureBDD(connection);

        try {
            int idClient = ecritureBDD.insererClientEtRecupererId(nom, prenom, numTel);
            
            ecritureBDD.insererReservation(nbPersonne, date, heureDebut, heureFin, idClient);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Fonctionnalité d'enregistrement Pro pour le fichier txt
    
    private void enregistrerProDansBDD(String numTel, String nom, String prenom, String nbPersonne, String date,String heureDebut, String heureFin, String societe) {
        EcritureBDD ecritureBDD = new EcritureBDD(connection);

        try {
            int idClient = ecritureBDD.insererClientEtRecupererIdPro(societe, numTel);
            
            ecritureBDD.insererReservation(nbPersonne, date, heureDebut, heureFin, idClient);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Boolean> verifierTable(String heureDebut, String heureFin, String date) {
        LectureBDD lectureBDD = new LectureBDD(connection);
        List<Table> tablesDisponibles = lectureBDD.obtenirTablesDisponibles(date, heureDebut, heureFin, 0);
        
        //Aide pour le code :
        //https://stackoverflow.com/questions/38252515/java-int-array-to-hashmapinteger-boolean-with-intstream
        
        Map<Integer, Boolean> etatsTables = new HashMap<>();

        for (Table table : tablesDisponibles) {
            etatsTables.put(table.getId(), true);
        }

        for (int i = 1; i <= NOMBRE_DE_TABLES; i++) {
            if (!etatsTables.containsKey(i)) {
                etatsTables.put(i, false);
            }
        }

        return etatsTables;
    }

    public void changerImage(ImageView imageView, int tableId, boolean disponible) {
        String cheminImage;
        
        //Aide pour le code suivant :
        //https://www.data-transitionnumerique.com/java-switch-case/
        //Attribue un URL d'image a chaque cas en fonction de disponible ou Pas Disponible 
        
        switch (tableId) {
            case 1:
                cheminImage = disponible ? "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe4Disponible.png" : "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe4PasDisponible.png";
                break;
            case 2:
                cheminImage = disponible ? "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe4Disponible.png" : "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe4PasDisponible.png";
                break;
            case 3:
                cheminImage = disponible ? "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe6Disponible.png" : "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe6PasDisponible.png";
                break;
            case 4:
                cheminImage = disponible ? "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe8Disponible.png" : "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\Images\\TableDe8PasDisponible.png";
                break;
            default:
                cheminImage = "";
        }
        
        //Aide pour le code suivant :
        //https://www.tabnine.com/code/java/methods/java.io.File/toURI
        //Verifie si le chemin n'est pas vide et change l'image
        
        if (!cheminImage.isEmpty()) {
            File file = new File(cheminImage);
            String imageUrl = file.toURI().toString();
            imageView.setImage(new Image(imageUrl));
        }
    }

    private void copierFichier(Path source, Path destination, String messageConfirmation, String messageErreur) {
        try {
        	
        	//Aide pour le code suivant :
        	//https://stackoverflow.com/questions/17169541/copy-file-in-java-and-replace-existing-target
        	//Permet d'écraser et remplace le fichier existant par le nouveau fichier
        	
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            afficherConfirmation(messageConfirmation);
        } catch (IOException e) {
            e.printStackTrace();
            afficherConfirmation(messageErreur + e.getMessage());
        }
    }
}
