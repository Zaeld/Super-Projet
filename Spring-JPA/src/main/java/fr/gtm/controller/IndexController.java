package fr.gtm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.repository.ClientRepository;

@Controller
public class IndexController {

	@Autowired
	private ClientDomaine client;

	@Autowired
	private ClientRepository clientRepo;
	
	@RequestMapping(path = "/welcome", method = RequestMethod.GET)
	ModelAndView displayIndex() {
		ModelAndView mav = new ModelAndView("welcome");
		final List<ClientDomaine> clients = new ArrayList<>();
		clients.add(this.client);
		
		clients.addAll(this.clientRepo.findAll());
		mav.getModel().put("clients", clients);
		return mav;
	}
}