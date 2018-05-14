package fr.gtm.presentation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.CompteBancaire;
import fr.gtm.service.ClientService;
import fr.gtm.service.GestionCompteService;

/**
 * Bean permettant de récupérer les attributs de l'objet client sur la vue de la
 * modification du client, de l'acceuil et des diverses opérations associés à un
 * client comme la suppresion, l'affichage ou le virement. Cette classe permet
 * aussi la redirection vers les vues réalisant ces fonctionnalités
 * 
 * @author ademolis
 *
 */
@ManagedBean(name = "beanclient")
@SessionScoped
public class BeanClient {

	private ClientDomaine clientDomaine = new ClientDomaine();
	private List<ClientDomaine> listClients;
	ClientService service = new ClientService();
	GestionCompteService serviceCompte = new GestionCompteService();
	CompteBancaire compte;

	public BeanClient() {
		super();
	}

	public ClientDomaine getClient() {
		return clientDomaine;
	}

	public void setClient(ClientDomaine clientDomaine) {
		this.clientDomaine = clientDomaine;
	}

	/**
	 * @return
	 */
	public List<ClientDomaine> getListClients() {
		listClients = service.getAllClient();
		return listClients;
	}

	public void setListClients(List<ClientDomaine> listClients) {
		this.listClients = listClients;
	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public Object modifierClient(ClientDomaine clientDomaine) {
		this.setClient(clientDomaine);
		return "modifierClient";
	}

	/**
	 * @return
	 */
	public Object createClient() {
		if (service.createClient(clientDomaine)) {
			return "operationreussie";
		}
		return "operationrate";
	}

	/**
	 * @return
	 */
	public Object updateClient() {
		ClientDomaine test;
		test = service.updateClient(clientDomaine);
		if (test != null) {
			return "operationreussie";
		}
		return "operationrate";

	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public Object deleteClient(ClientDomaine clientDomaine) {
		if (service.deleteClient(clientDomaine)) {
			return "operationreussie";
		}
		return "operationrate";
	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public Object afficherClient(ClientDomaine clientDomaine) {
		this.setClient(clientDomaine);
		return "afficherClient";
	}

	/**
	 * @param clientDomaine
	 * @return
	 */
	public Object virement(ClientDomaine clientDomaine) {
		this.setClient(clientDomaine);
		return "virement";
	}

	/**
	 * @return
	 */
	public List<CompteBancaire> afficherListeComptes() {
		List<CompteBancaire> listeComptes = service.getAllCompteClient(clientDomaine);
		return listeComptes;
	}

	/**
	 * @return
	 */
	public List<CompteBancaire> afficherItemsComptes() {
		return service.getAllCompteClient(clientDomaine);
	}

	/**
	 * @return
	 */
	public List<CompteBancaire> afficherItemsAllComptes() {
		return serviceCompte.getAllCompte();
	}
}
