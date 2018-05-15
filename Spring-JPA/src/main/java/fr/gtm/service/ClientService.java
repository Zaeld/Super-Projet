package fr.gtm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.repository.ClientRepository;
import fr.gtm.repository.IClientService;;

@Service
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientRepo;
	
	public List<ClientDomaine> findClients(){
		return clientRepo.findAll();
		
	}
}
