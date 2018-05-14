package fr.gtm.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.domaine.Conseiller;

/**
 * ConseillerDAO est la classe comportant la methode getConseiller qui permet de
 * retourner un objet de type Conseiller recupere dans la base de donnee en
 * prenant en entree un objet conseiller vide
 * 
 * @author ademolis
 *
 */
public class ConseillerDAO {

	// get all : Conseiller
	public ArrayList<Conseiller> getAll() {
		ArrayList<Conseiller> listConseiller = new ArrayList<Conseiller>();
		Statement stmt;
		try {
			stmt = Connexion.connexion().createStatement();
			String sql = "SELECT * FROM `conseiller`;";
			ResultSet result = stmt.executeQuery(sql); // Exécution de la requête
			while (result.next()) {
				Conseiller monConseiller = new Conseiller(); // Création de la variable de sortie
				monConseiller.setIdConseiller(result.getInt("idConseiller"));
				monConseiller.setNom(result.getString("nom"));
				monConseiller.setPrenom(result.getString("prenom"));

				listConseiller.add(monConseiller);
			}
			return listConseiller; // retour de la réponse

		} catch (SQLException e) {
			System.out.println("Problème lors de la methode getAll de la table 'conseiller'!");
			e.printStackTrace();
			return null;
		}

	}

}
