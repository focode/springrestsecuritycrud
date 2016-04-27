package com.gotprint;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import com.gotprint.entity.Notes;
import com.gotprint.entity.User;
import com.gotprint.repository.NotesRepository;
import com.gotprint.repository.UserRepository;


@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@Configuration
@ComponentScan(basePackages = "com.gotprint")
@EnableJpaRepositories
@ImportResource("classpath:SpringContext.xml")
//@ImportResource("classpath:springsecurity.xml")
@SpringBootApplication
public class GotprintApplication implements CommandLineRunner{
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(GotprintApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Notes notes1 = new Notes();
    	notes1.setCreateTime(new Date());
    	notes1.setLastUpdateTime(new Date());
    	notes1.setNote("My First Note");
    	notes1.setTitle("My first note title");
    	
    	Notes notes2 = new Notes();
    	notes2.setCreateTime(new Date());
    	notes2.setLastUpdateTime(new Date());
    	notes2.setNote("My First Note");
    	notes2.setTitle("My first note title");
    	
    	List<Notes> notesList1 = new ArrayList<Notes>();
    	notesList1.add(notes1);
    	notesList1.add(notes2);
    	
    	User user1 = new User();
    	user1.setCreateTime(new Date());
    	user1.setEmail("a@a.a");
    	user1.setLastUpdateTime(new Date());
    	user1.setPassword("a");
        user1.setNotes(notesList1);
        
        userRepository.save(user1);
        
        Notes notes3 = new Notes();
    	notes3.setCreateTime(new Date());
    	notes3.setLastUpdateTime(new Date());
    	notes3.setNote("My  Note2");
    	notes3.setTitle("My  note2 title");
    	
    	Notes notes4 = new Notes();
    	notes4.setCreateTime(new Date());
    	notes4.setLastUpdateTime(new Date());
    	notes4.setNote("My Note");
    	notes4.setTitle("My first note title");
    	
    	List<Notes> notesList2 = new ArrayList<Notes>();
    	notesList2.add(notes3);
    	notesList2.add(notes4);
    	
    	User user2 = new User();
    	user2.setCreateTime(new Date());
    	user2.setEmail("b@b.b");
    	user2.setLastUpdateTime(new Date());
    	user2.setPassword("b");
        user2.setNotes(notesList2);
        
        userRepository.save(user2);
		
	}
	
}


