package com.mojdan.admin;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mojdan.admin.model.user.Customer;
import com.mojdan.admin.model.user.CustomerRepository;
import com.mojdan.admin.model.user.Seller;
import com.mojdan.admin.model.user.SellerRepository;
import com.mojdan.admin.model.user.User;
import com.mojdan.admin.model.user.UserRepository;

@EntityScan("com.mojdan.app.model")
@SpringBootApplication
public class MojdanApplication {

	private static final Logger log = LoggerFactory.getLogger(MojdanApplication.class);

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	  public static void main(String[] args) {
	    SpringApplication.run(MojdanApplication.class);
	  }

	  @Bean
	  public CommandLineRunner demo(UserRepository userRepo) {
	    return (args) -> {
	      // save a few users
	     
	    		userRepo.save(new User("jack", bCryptPasswordEncoder.encode("prueba1"), "Jack", "Aaa"));
			userRepo.save(new User("chloe", bCryptPasswordEncoder.encode("prueba2"), "Chloe", "Heinz"));
			userRepo.save(new User("kim", bCryptPasswordEncoder.encode("prueba3"), "Kim", "Jones"));
			userRepo.save(new User("michelle", bCryptPasswordEncoder.encode("prueba4"), "Michelle", "Hanss"));
			userRepo.save(new User("admin", bCryptPasswordEncoder.encode("admin"), "admin", "--"));
			userRepo.save(new User("jack", bCryptPasswordEncoder.encode("user"), "user", "Radd"));
			userRepo.save(new Customer("customer", bCryptPasswordEncoder.encode("customer"), "user", "Radd", "Prueba "));			
			userRepo.save(new Seller("seller", bCryptPasswordEncoder.encode("seller"), "user", "Radd", 234));
			
	      // fetch all users
	      log.info("Users found with findAll():");
	      log.info("-------------------------------");
	      for (User user : userRepo.findAll()) {
	        log.info(user.toString());
	      }
	      log.info("");

	      // fetch an individual user by ID
	      Optional<User> user = userRepo.findById(1L);
	      log.info("User found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(user.toString());
	      log.info("");

	      // fetch users by last name
	      log.info("User found with findByLastName('Bauer'):");
	      log.info("--------------------------------------------");
	      userRepo.findByName("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      // for (User bauer : repository.findByLastName("Bauer")) {
	      //  log.info(bauer.toString());
	      // }
	      log.info("");
	    };
	  }

}
