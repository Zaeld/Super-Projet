package fr.gtm.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fr.gtm.domaine.ClientDomaine;
import fr.gtm.repository.ClientRepository;


@RestController
@RequestMapping("/api/client")
public class ClientWebService {
	

		@Autowired
		private ClientRepository clientRepo;

		@PostMapping(path = { "", "/" })
		ClientDomaine create(@RequestBody ClientDomaine client) {
			return this.clientRepo.save(client);

		}

		@GetMapping("/{clientId}")
		ClientDomaine read(@PathVariable Integer clientId) {
			return this.clientRepo.getOne(clientId);
		}

		@PutMapping("/{clientId}")
		ClientDomaine update(@PathVariable Integer clientId, @RequestBody ClientDomaine client) {
			return this.clientRepo.save(client);
		}

		@DeleteMapping("/{clientId}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		void delete(@PathVariable Integer clientId) {
			this.clientRepo.deleteById(clientId);
		}

		@GetMapping({ "", "/" })
		List<ClientDomaine> List() {
			return this.clientRepo.findAll();
		}

	}


