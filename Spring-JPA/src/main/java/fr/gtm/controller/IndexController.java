package fr.gtm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.repository.ClientRepository;
import fr.gtm.repository.IClientService;

@Controller
public class IndexController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private ClientDomaine client;

	@Autowired
	private IClientService clientRepo;
	
	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	ModelAndView displayIndex() {
		ModelAndView mav = new ModelAndView("welcome");
		IndexController.LOGGER.debug("Requête HTTP déclenchant la méthode displayIndex().");
		final List<ClientDomaine> clients = new ArrayList<>();
		clients.add(this.client);
		clients.addAll(this.clientRepo.findClients());
		mav.getModel().put("clients", clients);
		return mav;
	}
}