package fr.gtm.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import fr.gtm.domaine.Conseiller;
import fr.gtm.domaine.Login;

/**
 * La classe LoginService permet de faire le lien entre la couche présentation
 * et la classe LoginDAO
 * 
 * @author Stagiaire
 *
 */
public class LoginService {


	/**
	 * Méthode métier permettant verifier si le login et password correspondent à un
	 * conseiller enregistré
	 * 
	 * @param loginFromConnexion
	 * @return
	 */
	public Conseiller verifLogin(Login loginFromConnexion) {
		
		ObjectMapper mapper = new ObjectMapper();
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/Spring-JPA/api/conseiller");
		String output;
		Conseiller conseiller = null;
		try {
			String input = mapper.writeValueAsString(loginFromConnexion);
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		output = response.getEntity(String.class);
		conseiller=mapper.readValue(output, Conseiller.class);
		}
		catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conseiller.getNom());
		return conseiller;

		
	}
}
