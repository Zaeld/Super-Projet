package fr.gtm.service;

import java.io.IOException;
import java.util.ArrayList;


import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import fr.gtm.DAO.ClientDAO;
import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.domaine.Conseiller;

/**
 * La classe ClientService permet de faire le lien entre la couche présentation
 * et la classe ClientDAO
 * 
 * @author Stagiaire
 *
 */
public class ClientService {

	// Déclaration
	ClientDAO dao = new ClientDAO();

	/**
	 * @param clientDomaine
	 * @return
	 */
	public boolean createClient(ClientDomaine clientDomaine) {
		return dao.createClient(clientDomaine);
	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public ClientDomaine getClient(ClientDomaine clientDomaine) {
		return dao.getClient(clientDomaine);
	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public ClientDomaine updateClient(ClientDomaine clientDomaine) {
		return dao.updateClient(clientDomaine);
	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public boolean deleteClient(ClientDomaine clientDomaine) {
		return dao.deleteClient(clientDomaine);
	}

	/**
	 * @return
	 */
	public List<ClientDomaine> getAllClient() {
		return dao.getAllClient();
	}

	/**
	 * @param conseiller
	 * @return
	 */
	public List<ClientDomaine> getAllClientConseiller(Conseiller conseiller) {
		
		ObjectMapper mapper = new ObjectMapper();
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Spring-JPA/api/conseiller/"+conseiller.getIdConseiller());
		String output;
		List<ClientDomaine> listeClients = null;
		try {
			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
		output = response.getEntity(String.class);
		listeClients=mapper.readValue(output, List.class);
		}
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conseiller.getNom());
		return listeClients;
	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public List<CompteBancaire> getAllCompteClient(ClientDomaine clientDomaine) {
		List<CompteBancaire> listeComptes = dao.getAllCompte(clientDomaine);
		List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
		for (CompteBancaire compte : listeComptes) {
			if (compte != null)
				comptes.add(compte);
		}
		return comptes;
	}
}
