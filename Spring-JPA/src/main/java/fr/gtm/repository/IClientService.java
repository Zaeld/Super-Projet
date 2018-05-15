package fr.gtm.repository;

import java.util.List;

import fr.gtm.domaine.ClientDomaine;

public interface IClientService {

	List<ClientDomaine> findClients();

}
