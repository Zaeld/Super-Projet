package fr.gtm.webservice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.gtm.controller.IndexController;
import fr.gtm.domaine.ClientDomaine;
import fr.gtm.domaine.Conseiller;
import fr.gtm.domaine.Login;
import fr.gtm.repository.ClientRepository;
import fr.gtm.repository.ConseillerRepository;
import fr.gtm.repository.LoginRepository;

@RestController
@RequestMapping("/api/conseiller")
public class ConseillerWebService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	ConseillerRepository conseillerRepo;
	
	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	ClientRepository clientRepo;

	@GetMapping({ "", "/" })
	Login List() {
		return this.loginRepo.findById(1).get();
		
	}

	@PostMapping(path = { "", "/" })
	Conseiller verifLogin(@RequestBody Login login) {
		ConseillerWebService.LOGGER.debug("Vérification du login");

		Optional<Conseiller> retourConseiller=null;
		Login reponse= this.loginRepo.findByLoginAndMotDePasse(login.getLogin(), login.getMotDePasse());
		if(reponse==null) {
		retourConseiller=null;
		ConseillerWebService.LOGGER.debug("Login incorrect");
		}
		else {
			retourConseiller=this.conseillerRepo.findById(reponse.getConseiller().getIdConseiller());
			ConseillerWebService.LOGGER.debug("Connexion réussi");

		}
		Conseiller conseillerReponse=retourConseiller.get();
		return conseillerReponse;
	

	}
	@GetMapping("/{idConseiller}")
	List<ClientDomaine> listeClientsConseiller(@PathVariable Integer idConseiller){
		ConseillerWebService.LOGGER.debug("Affichage de la liste des clients");
		List<ClientDomaine> listeClients = this.clientRepo.findByConseiller_idConseiller(idConseiller);
		return listeClients;
		
	}

}
