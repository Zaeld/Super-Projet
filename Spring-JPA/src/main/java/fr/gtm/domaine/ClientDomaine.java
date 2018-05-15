package fr.gtm.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */

@Entity
@Table(name = "client")
public class ClientDomaine {

	// Declaration des attributs caracterisant un objet de type Client
	
	@Id
	@Column(name = "idClient")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String email;
	private String telephone;
	private Double soldeTotal;
	
	@ManyToOne
	private Conseiller conseiller;

	// Constructeur par defaut et parametre

	public ClientDomaine() {
		super();
		this.nom = "Entrez votre nom";
		this.prenom = "Entrez votre prenom";
		this.adresse = "Entrez votre adresse";
		this.codePostal = "Entrez votre Code Postal";
		this.ville = "Entrez votre ville";
		this.email = "Entrez votre email";
		this.telephone = "Entrez votre téléphone";
	}

	// Getters et Setters
	


	/* Redéfinition de la méthode toString()
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.nom + " " + this.prenom + " est le client " + this.getIdClient()
				+ " avec comme conseiller le conseiller " + this.conseiller.getIdConseiller() + " ";
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Double getSoldeTotal() {
		return soldeTotal;
	}

	public void setSoldeTotal(Double soldeTotal) {
		this.soldeTotal = soldeTotal;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
}
