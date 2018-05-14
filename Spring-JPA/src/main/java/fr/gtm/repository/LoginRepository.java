package fr.gtm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.domaine.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{
	Login findByLoginAndMotDePasse(String login, String motDePasse);

}
