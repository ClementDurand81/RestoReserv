package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
}
