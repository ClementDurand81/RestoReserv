package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Classe.Reservation;
import Classe.Table;

public class LectureBDD {

    private Connection connection;

    public LectureBDD(Connection connection) {
        this.connection = connection;
    }

    public List<Reservation> obtenirListeReservations() {
    	
    	//Création d'un tableau 
    	
        List<Reservation> listeReservations = new ArrayList<>();
        
        //Jointure SQL pour obtenir toutes les reservations
        //https://www.baeldung.com/sql-joins
        
        String query = "SELECT r.numéro, r.id_client, r.nbPersonne, r.date, r.heureDebut, r.heureFin, c.nom, c.prenom, c.societe " +
                       "FROM reservation r " +
                       "JOIN client c ON r.id_client = c.id_client"; 

        //Requete préparé qui place les paramêtres dans la requete
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

        	//Parcours de la base de donnée afin de créer un objet "Reservation"
        	//Aide sur la structure 
        	//https://stackoverflow.com/questions/57219316/how-do-i-iterate-over-a-result-set-and-add-values-to-objects
        	
            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                    resultSet.getInt("numéro"),
                    resultSet.getInt("id_client"),
                    resultSet.getInt("nbPersonne"),
                    resultSet.getString("date"),
                    resultSet.getString("heureDebut"),
                    resultSet.getString("heureFin"),
                    resultSet.getString("Nom"),
                    resultSet.getString("Prenom"),
                    resultSet.getString("Societe")
                );

                //Ajoute l'objet Reservation dans le tableau listeReservation 
                listeReservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeReservations;
    }
    
    public Table obtenirTableDisponible(String date, String heureDebut, String heureFin, int nbPersonnes) {
    	
    	//Requete imbrique / sous requete 
    	//https://sql.sh/cours/sous-requete
    	//Requete qui permet de rechercher une table dans la table tablerestaurant disponible en fonction de la date et de l'heure de debut et de l'heure de fin
    	//La requete verifie aussi si le nombre de place des tables disponible sont ok
    	
        String query = "SELECT t.id, t.nbPlace " +
                       "FROM tablerestaurant t " +
                       "WHERE t.id NOT IN (SELECT r.id_table FROM reservation r " +
                                         "WHERE r.date = ? " +
                                         "AND ((? BETWEEN r.heureDebut AND r.heureFin) OR (? BETWEEN r.heureDebut AND r.heureFin) OR (r.heureDebut BETWEEN ? AND ?) OR (r.heureFin BETWEEN ? AND ?))) " +
                       "AND t.nbPlace >= ?";

        //Requete préparé qui place les paramêtres dans la requete
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, heureDebut + ":00");
            preparedStatement.setString(3, heureFin + ":00");
            preparedStatement.setString(4, heureDebut + ":00");
            preparedStatement.setString(5, heureFin + ":00");
            preparedStatement.setString(6, heureDebut + ":00");
            preparedStatement.setString(7, heureFin + ":00");
            preparedStatement.setInt(8, nbPersonnes);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                	
                	//Recupere les informations de la tables "id" et "nbPlace"
                	
                    int tableId = resultSet.getInt("id");
                    int nbPlace = resultSet.getInt("nbPlace");

                	//Créer un objet Table et retourne l'objet
                    
                    Table table = new Table(tableId, nbPlace);
                    
                    //Retourne l'objet table
                    
                    return table;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    

    public List<Table> obtenirTablesDisponibles(String date, String heureDebut, String heureFin, int nbPersonnes) {
    	
    	//Requete imbrique / sous requete 
    	//https://sql.sh/cours/sous-requete
    	//Requete qui permet de rechercher une table dans la table tablerestaurant disponible en fonction de la date et de l'heure de debut et de l'heure de fin
    	//La requete verifie aussi si le nombre de place des tables disponible sont ok
    	
        String query = "SELECT t.id, t.nbPlace " +
                       "FROM tablerestaurant t " +
                       "WHERE t.id NOT IN (SELECT r.id_table FROM reservation r " +
                                         "WHERE r.date = ? " +
                                         "AND ((? BETWEEN r.heureDebut AND r.heureFin) OR (? BETWEEN r.heureDebut AND r.heureFin) OR (r.heureDebut BETWEEN ? AND ?) OR (r.heureFin BETWEEN ? AND ?))) " +
                       "AND t.nbPlace >= ?";

        //Requete préparé qui place les paramêtres dans la requete
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, heureDebut + ":00");
            preparedStatement.setString(3, heureFin + ":00");
            preparedStatement.setString(4, heureDebut + ":00");
            preparedStatement.setString(5, heureFin + ":00");
            preparedStatement.setString(6, heureDebut + ":00");
            preparedStatement.setString(7, heureFin + ":00");
            preparedStatement.setInt(8, nbPersonnes);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	
            	//Créer un tableau 
                List<Table> tablesDisponibles = new ArrayList<>();

                while (resultSet.next()) {
                	
                	//Recupere les informations de la tables "id" et "nbPlace"
                	
                    int tableId = resultSet.getInt("id");
                    int nbPlace = resultSet.getInt("nbPlace");

                    //Créer un objet Table et retourne l'objet
                    
                    Table table = new Table(tableId, nbPlace);
                    
                    //Ajoute l'objet Table à la liste des tables disponible 
                    
                    tablesDisponibles.add(table);
                }
                
                //Retourne le tableau tablesDisponibles
                
                return tablesDisponibles;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    
}
