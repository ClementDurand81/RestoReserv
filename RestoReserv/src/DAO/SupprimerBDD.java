package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Classe.Reservation;

public class SupprimerBDD {

    private Connection connection;

    public SupprimerBDD(Connection connection) {
        this.connection = connection;
    }
    
    //Fonction qui permet de supprimer dans la vue VueListeReservation
    
    public void supprimerReservation(Reservation reservation) throws SQLException {
        String query = "DELETE FROM reservation WHERE numéro = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservation.getNumero());
            preparedStatement.executeUpdate();
        }
    }
}
