package com.jpa.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.demo.Repository.UserRepository;
import com.jpa.demo.entities.User;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(JpaDemoApplication.class, args);
		UserRepository repository=context.getBean(UserRepository.class);
		
		//This method is used to save only one object
		/*
		 * User user=new User(); user.setName("Neem Karori");
		 * user.setCity("Kaichi Dhaam"); user.setStatus("Happy");
		 * 
		 * User user1=repository.save(user); System.out.println(user1);
		 */
		
		//This code is for saving multiple objects
		/*
		 * User user=new User(); user.setName("Krishna"); user.setCity("Kolhapur");
		 * user.setStatus("Happy");
		 * 
		 * User user1=new User(); user1.setName("avadhut"); user1.setCity("Kolhapur");
		 * user1.setStatus("Successful");
		 * 
		 * User user3=new User(); user3.setName("vaibhav"); user3.setCity("sangaon");
		 * user3.setStatus("Happy");
		 * 
		 * List<User>userList=List.of(user,user1,user3); Iterable<User> saveAll =
		 * repository.saveAll(userList);
		 * 
		 * saveAll.forEach(usrs->{ System.out.println(usrs); });
		 */
		
		//This code is for updating the single user
		/*
		 * Optional<User>optional=repository.findById(2); User user=optional.get();
		 * user.setStatus("Rich");
		 * 
		 * User saved = repository.save(user); System.out.println(saved);
		 */
		
		//This code for getting all the data
		/*
		 * Iterable<User>users=repository.findAll();
		 * Iterator<User>iter=users.iterator(); while(iter.hasNext()) { User
		 * usr=iter.next(); System.out.println(usr); }
		 */
		
		//Another way to fetch all data
		/*
		 * Iterable<User>users=repository.findAll(); users.forEach(usr->{
		 * System.out.println(usr); });
		 */
		
		//deleting the data
		/*repository.deleteById(4);
		System.out.println("deleted the user with id = 4"	);*/
		
		//deleting all the data
		Iterable<User> all = repository.findAll();
		repository.deleteAll(all);
	}

}
