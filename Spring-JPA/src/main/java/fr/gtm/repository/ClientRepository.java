package fr.gtm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.domaine.ClientDomaine;

	public interface ClientRepository extends JpaRepository<ClientDomaine, Integer> {
		List<ClientDomaine> findByIdConseiller(Integer idConseiller);
	}
	

