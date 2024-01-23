package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classe.Table;

public class EcritureBDD {

    private Connection connection;

    public EcritureBDD(Connection connection) {
        this.connection = connection;
    }
    
    //Fonction qui insère et récupere un id d'un client Particulier
    
    public int insererClientEtRecupererId(String nom, String prenom, String numTel) {
    	
        String query = "INSERT INTO client (Telephone, Nom, Prenom) VALUES (?, ?, ?)";
        
        try {
        	
        	//Aide pour le code suivant : 
        	//https://stackoverflow.com/questions/4224228/preparedstatement-with-statement-return-generated-keys
        	//Permet de recuperer la clé générer automatiquement 
        	
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, numTel);
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, prenom);
            
            int affectedRows = preparedStatement.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Erreur Insertion Client");
            }
            
            //Aide pour le code suivant :
            //https://stackoverflow.com/questions/17505964/how-can-i-get-auto-generated-keys-and-set-the-resultset-type
            //Permet de recuperer la valeur auto-incrementer
            
            try (ResultSet cleGenere = preparedStatement.getGeneratedKeys()) {
                if (cleGenere.next()) {
                    return cleGenere.getInt(1);
                } else {
                    throw new SQLException("Erreur");
                }
            }
        } catch (SQLException e) {
        		e.printStackTrace();
          return 0;
        }
    }
    
    //Fonction qui insère et récupere un id d'un client Pro
    
    public int insererClientEtRecupererIdPro(String Societe, String numTel) {
        String query = "INSERT INTO client (Telephone, Societe) VALUES (?, ?)";
        
        try {
        	
        	//Aide pour le code suivant : 
        	//https://stackoverflow.com/questions/4224228/preparedstatement-with-statement-return-generated-keys
        	
            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, numTel);
            preparedStatement.setString(2, Societe);
            int affectedRows = preparedStatement.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Erreur Insertion Client");
            }
            
            //Aide pour le code suivant :
            //https://stackoverflow.com/questions/17505964/how-can-i-get-auto-generated-keys-and-set-the-resultset-type
            //Permet de recuperer la valeur auto-incrementer
            
            try (ResultSet cleGenere = preparedStatement.getGeneratedKeys()) {
                if (cleGenere.next()) {
                    return cleGenere.getInt(1);
                } else {
                    throw new SQLException("Erreur");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //Permet d'inserer une reservation depuis la récupération des informations clients 
    
    public void insererReservation(String nbPlaces, String date, String heureDebut, String heureFin, int id_client) {
        LectureBDD lectureBDD = new LectureBDD(connection);
        
        Table tableDisponible = lectureBDD.obtenirTableDisponible(date, heureDebut, heureFin, Integer.parseInt(nbPlaces));

        //Verifie si des tables sont encore disponible 
        
        if (tableDisponible != null) {
            try {
            	
            	//Condition de vérification
            	
                if (nbPlaces != null && !nbPlaces.isEmpty() && date != null && !date.isEmpty()
                        && heureDebut != null && !heureDebut.isEmpty() && heureFin != null && !heureFin.isEmpty()) {

                    if (id_client > 0) {
                    	
                    	//Insere dans la base de données la réservation
                    	
                        String insererReservation = "INSERT INTO reservation (nbPersonne, date, heureDebut, heureFin, id_client, id_table) VALUES (?, ?, ?, ?, ?, ?)";
                        
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insererReservation)) {
                        	preparedStatement.setString(1, nbPlaces);
                        	preparedStatement.setString(2, date);
                        	preparedStatement.setString(3, heureDebut + ":00");
                        	preparedStatement.setString(4, heureFin + ":00");
                        	preparedStatement.setInt(5, id_client);
                        	preparedStatement.setInt(6, tableDisponible.getId());

                        	preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("ID du client invalide.");
                    }
                } else {
                    System.out.println("Valeurs nécessaires pour la réservation manquantes ou invalides.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Aucune table disponible pour la réservation.");
        }
    }

}
