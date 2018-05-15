package fr.gtm.domaine;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "conseiller")
public class Conseiller {

	// Declaration des attributs caracterisant un objet de type Conseiller

	@Id
	@Column(name = "idConseiller")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConseiller;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy="conseiller")
	private Collection<ClientDomaine> Clients;

	// Constructeur par defaut et parametre

	public Conseiller() {
		super();
	}

	public Conseiller(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	// Getters et Setters

	public Integer getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
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


}
