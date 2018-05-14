package fr.gtm.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name = "login")
public class Login {

	// Declaration des attributs caracterisant un objet de type Login

	@Id
	@Column(name = "idLogin")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLogin;
	private String login;
	private String motDePasse;
	private Integer idConseiller;
	// Constructeur parametre

	public Login() {
		this.login = "Entrez votre login";
		this.motDePasse = "Entrez votre mot de passe";

	}
	// Getters et Setters

	public Integer getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Integer getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
	}

	

}
