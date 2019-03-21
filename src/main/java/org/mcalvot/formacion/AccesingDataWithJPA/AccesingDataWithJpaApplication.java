package org.mcalvot.formacion.AccesingDataWithJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AccesingDataWithJpaApplication {

	private static final Logger log =  LoggerFactory.getLogger(AccesingDataWithJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccesingDataWithJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner informacion(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer("Claudia", "Garcia"));
			repository.save(new Customer("alvaro", "Lopez"));
			repository.save(new Customer("Beatriz", "Gomez"));
			repository.save(new Customer("Carlos", "Torres"));
			repository.save(new Customer("Marta", "Garcia"));

			log.info("Informacion de los clientes: ");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			repository.findById(1L).ifPresent(customer -> {//te muestra el cliente que tenga el id1

				log.info("Mostrar el cliente que tenga el Id 1: ");
				log.info("----------------------------------------");
				log.info(customer.toString());
				log.info(" ");

			});

				//Buscar un cliente por su apellido
				log.info("Todos los cliente que se apellidan Garcia");
				log.info("------------------------------------------------");

				repository.findByLastName("Garcia").forEach(Garcia ->{

					log.info(Garcia.toString());

				});

			log.info("");




		};
	}


}
