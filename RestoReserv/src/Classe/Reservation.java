package Classe;


public class Reservation {
	 private int numero;
	 private int id_client;
	 private int nombrePersonne;
	 private String date;
	 private String heureDebut;
	 private String heureFin;
	 private String Nom;
	 private String Prenom;
	 private String Societe;
	
	 public Reservation(int numero, int id_client, int nombrePersonne, String date, String heureDebut, String heureFin, String Nom, String Prenom, String Societe) {
	     this.numero = numero;
	     this.id_client = id_client;
		 this.nombrePersonne = nombrePersonne;
	     this.date = date;
	     this.heureDebut = heureDebut;
	     this.heureFin = heureFin;
	     this.Nom = Nom;
	     this.Prenom = Prenom;
	     this.Societe = Societe;
	 }
	
	
	 public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public int getNombrePersonne() {
	     return nombrePersonne;
	 }
	
	 public void setNombrePersonne(int nombrePersonne) {
	     this.nombrePersonne = nombrePersonne ;
	 }
	
	 public String getDate() {
	     return date;
	 }
	
	 public void setDate(String date) {
	     this.date = date;
	 }
	
	 public String getHeureDebut() {
	     return heureDebut;
	 }
	
	 public void setHeureDebut(String heureDebut) {
	     this.heureDebut = heureDebut;
	 }
	
	 public String getHeureFin() {
	     return heureFin;
	 }
	
	 public void setHeureFin(String heureFin) {
	     this.heureFin = heureFin;
	 }


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getPrenom() {
		return Prenom;
	}


	public void setPrenom(String prenom) {
		Prenom = prenom;
	}


	public String getSociete() {
		return Societe;
	}


	public void setSociete(String societe) {
		Societe = societe;
	}
	}

