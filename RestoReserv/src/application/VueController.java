package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import Classe.Reservation;
import Services.Services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VueController {

	@FXML
	private Button btnInternet;
	
	@FXML
	private Button btnReservation;
	
	@FXML
	private Button btnSalle;
	
	@FXML
	private Button btnListeReservation;
	
	@FXML
	private Button btnCreerReservation;
	
	@FXML
	private Button btnPro;
	
	@FXML
	private Button btnParticulier;
	
	@FXML
	private Button btnAccueil;
	
	@FXML
	private Button btnValider;
	
	@FXML
	private TextField txtNom;
	
	@FXML
	private TextField txtPrenom;
	
	@FXML
	private TextField txtNumTel;
	
	@FXML
	private TextField txtNbPlace;
	
	@FXML
	private TextField txtHeureDebut;
	
	@FXML
	private TextField txtHeureFin;
	
	@FXML
	private DatePicker dateDate;
	
	@FXML
	private Button btnRafraichir;
	
	@FXML
	private Button btnSupprimer;
	
	@FXML
	private TextField txtNumTelPro;
	
	@FXML
	private TextField txtSociete;
	
	@FXML
	private Button btnValiderPro;
	
	@FXML
	private TextField txtHeureDebutPro;
	
	@FXML
	private TextField txtNbPlacePro;
	
	@FXML
	private TextField txtHeureFinPro;
	
	@FXML
	private DatePicker dateDatePro;
	
	@FXML
	private Button btnChargerFichierSelectionner;

	@FXML
	private Button btnTraitementFichier;
	
	@FXML
	private TableView<Reservation> tableReservation;

	@FXML
	private TableColumn<Reservation, Integer> colNumero;

	@FXML
	private TableColumn<Reservation, Integer> colNbPersonne;

	@FXML
	private TableColumn<Reservation, String> colDate;

	@FXML
	private TableColumn<Reservation, String> colHeureDebut;

	@FXML
	private TableColumn<Reservation, String> colHeureFin;
    
	@FXML
	private TableColumn<Reservation, String> colNom;
	
	@FXML
	private TableColumn<Reservation, String> colPrenom;
	
	@FXML
	private TableColumn<Reservation, String> colSociete;
	
	@FXML
	private Button btnVerifierTable ;
	
	@FXML
	private DatePicker dateDateTable;
	
	@FXML
	private TextField txtHeureDebutTable;
	
	@FXML
	private TextField txtHeureFinTable;
	
	@FXML
	private ImageView imgTableDe41;
		
	@FXML
	private ImageView imgTableDe42;
	
	@FXML 
	private ImageView imgTableDe6;
	
	@FXML
	private ImageView imgTableDe8;
	
	private Services service;
	
    public void initialize() {
        service = new Services();
    }

	@FXML
    private void btnInternet(MouseEvent e) throws IOException {

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("VueListeWeb.fxml"));
		 Parent root = loader.load();

		 Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 Scene scene2 = new Scene(root);
		 stage.setScene(scene2);
		 stage.show();      
    }
	
	@FXML
    private void btnReservation(MouseEvent e) throws IOException {

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("VueReservation.fxml"));
		 Parent root = loader.load();

		 Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 Scene scene2 = new Scene(root);
		 stage.setScene(scene2);
		 stage.show();      
    }
	
	@FXML
    private void btnSalle(MouseEvent e) throws IOException {

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("VueTable.fxml"));
		 Parent root = loader.load();

		 Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 Scene scene2 = new Scene(root);
		 stage.setScene(scene2);
		 stage.show();      
    }
	
	@FXML
    private void btnListeReservation(MouseEvent e) throws IOException {

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("VueListeReservation.fxml"));
		 Parent root = loader.load();

		 Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 Scene scene2 = new Scene(root);
		 stage.setScene(scene2);
		 stage.show();      
    }
	
	@FXML
    private void btnCreerReservation(MouseEvent e) throws IOException {

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("VueChoixFormulaire.fxml"));
		 Parent root = loader.load();

		 Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 Scene scene2 = new Scene(root);
		 stage.setScene(scene2);
		 stage.show();      
    }

	@FXML
    private void btnParticulier(MouseEvent e) throws IOException {

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("VueFormulaireParticulier.fxml"));
		 Parent root = loader.load();

		 Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 Scene scene2 = new Scene(root);
		 stage.setScene(scene2);
		 stage.show();      
    }
	
	@FXML
    private void btnPro(MouseEvent e) throws IOException {

		 FXMLLoader loader = new FXMLLoader(getClass().getResource("VueFormulaireSociete.fxml"));
		 Parent root = loader.load();

		 Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		 Scene scene2 = new Scene(root);
		 stage.setScene(scene2);
		 stage.show();      
    }
	
	@FXML
	private void btnValiderParticulier(MouseEvent e) throws IOException {
	    String Nom = txtNom.getText();
	    String Prenom = txtPrenom.getText();
	    String numTel = txtNumTel.getText();
	    String NbPlaces = txtNbPlace.getText();
	    String HeureDebut = txtHeureDebut.getText();
	    String HeureFin = txtHeureFin.getText();
	    String Date = dateDate.getValue().toString();

	    Services.enregistrementReservation(Nom, Prenom, numTel, NbPlaces, Date , HeureDebut, HeureFin);
	}
	
	@FXML
	private void btnValiderPro(MouseEvent e) throws IOException {
		
		String Societe = txtSociete.getText();
	    String numTel = txtNumTelPro.getText();
	    String NbPlaces = txtNbPlacePro.getText();
	    String HeureDebut = txtHeureDebutPro.getText();
	    String HeureFin = txtHeureFinPro.getText();
	    String Date = dateDatePro.getValue().toString();

	    Services.enregistrementReservationPro(numTel, NbPlaces, Date, HeureDebut, HeureFin, Societe);
	}
	
    @FXML
    private void btnRetourAccueil(MouseEvent event) throws IOException {
    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Vue.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    //Source aide pour le code suivant :
    //https://stackoverflow.com/questions/16377820/how-to-use-the-propertyvaluefactory-correctly
    
    @FXML
    private void btnChargerListeReservations() {
    	
    	//Appele la liste de reservation
    	
        List<Reservation> reservations = service.obtenirListeReservations();
        
        //Supprime les éléments présent dans le tableau
        
        tableReservation.getItems().clear();
        
        //Source aide pour le code suivant :
        //http://www.java2s.com/example/java-api/javafx/collections/fxcollections/observablearraylist-1-2.html
        
        ObservableList<Reservation> observableReservations = FXCollections.observableArrayList(reservations);
        
        //Ajout des valeurs dans leurs colonnes respectives
        
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colNbPersonne.setCellValueFactory(new PropertyValueFactory<>("nombrePersonne"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colHeureDebut.setCellValueFactory(new PropertyValueFactory<>("heureDebut"));
        colHeureFin.setCellValueFactory(new PropertyValueFactory<>("heureFin"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        colSociete.setCellValueFactory(new PropertyValueFactory<>("Societe"));

        tableReservation.setItems(observableReservations);
    }
    
    @FXML
    private void btnSupprimer() {
    	
    	//Source aide pour le code suivant :
    	//https://openclassrooms.com/forum/sujet/javafx-observablelist-recupere-un-item-specifique
    	
        ObservableList<Reservation> reservationSelectionne = tableReservation.getSelectionModel().getSelectedItems();
        
        for (Reservation reservation : reservationSelectionne) {
            service.supprimerReservation(reservation);
        }

        btnChargerListeReservations();
    }
  
    @FXML
    private void btnChargerFichierSelectionner() {
    	
        //Source aide pour le code suivant : 
        //https://stackoverflow.com/questions/10524250/set-initial-file-extension-while-saving-the-file
    	//Ouvre une page de dialogues dans la quelle on peut selectionner un fichier .txt
    	
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionner un fichier");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichiers texte (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File fichierSelectionner = fileChooser.showOpenDialog(btnChargerFichierSelectionner.getScene().getWindow());

    	//Copie le fichier selectionner dans le dossier FichierWeb de l'application
        
        if (fichierSelectionner != null) {
            Path resultFichierSelect = fichierSelectionner.toPath();
            Services services = new Services();
            
            //Appele la methode chargerFichierSelectionne de la classe Services
            
            services.chargerFichierSelectionne(resultFichierSelect);
        }
    }
    
    @FXML
    private void btnTraitementFichier() {
    	
        String dossierFichierWeb = "C:\\Users\\Eleve\\eclipse-workspace\\RestoReserv\\src\\FichierWeb";
        String nomFichier = "ReservationWeb.txt";
        
        //Source aide pour le code suivant :
        //https://stackoverflow.com/questions/2417485/difference-between-file-separator-and-slash-in-paths
        
        String cheminFichier = dossierFichierWeb + File.separator + nomFichier;
        Services services = new Services();

        //Récupère le chemin du fichier puis appele la methode traiterFichier de la classe Services
        
        try {
            Path pathFichier = Paths.get(cheminFichier);
            services.traiterFichier(pathFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void btnVerifierTable() {
    	
        String heureDebut = txtHeureDebutTable.getText();
        String heureFin = txtHeureFinTable.getText();
        String date = dateDateTable.getValue().toString();

        Services services = new Services();
        
        //Source aide pour le code suivant :
        //https://developer.jboss.org/thread/213883
        
        //Permet de verifier l'état des tables
        
        Map<Integer, Boolean> etatsTables = services.verifierTable(heureDebut, heureFin, date);

        //Change de façon dynamique l'affichage en fonction de l'état des tables
        
        services.changerImage(imgTableDe41, 1, etatsTables.get(1));
        services.changerImage(imgTableDe42, 2, etatsTables.get(2));
        services.changerImage(imgTableDe6, 3, etatsTables.get(3));
        services.changerImage(imgTableDe8, 4, etatsTables.get(4));
    }
}
