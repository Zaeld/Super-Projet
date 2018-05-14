package fr.gtm.domaine;

/**
 * @author Stagiaire
 *
 */
public class Login {

	// Declaration des attributs caracterisant un objet de type Login

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
