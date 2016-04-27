package com.gotprint.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gotprint.entity.Notes;

import com.gotprint.entity.User;
import com.gotprint.repository.NotesRepository;
import com.gotprint.repository.UserRepository;

@RestController
public class GotPrintController {
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    @RequestMapping("/createnotes")
    @Transactional
    public Notes create() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println("auth.getName::"+auth.getName());
    	Notes notes = new Notes();
    	notes.setCreateTime(new Date());
    	notes.setLastUpdateTime(new Date());
    	notes.setNote("My First Note");
    	notes.setTitle("My first note title");
    	notesRepository.save(notes);
        return notes;
    }
    
    
    @RequestMapping("/readnotes")
    @Transactional
    public List<Notes> read(){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println("auth.getName::"+auth.getName());
    	User users = userRepository.findByEmailId(auth.getName());
    	List<Notes> notes = (List<Notes>) users.getNotes();
       	return notes;
    }
    
    @RequestMapping(value="/delete/{id}/", method=RequestMethod.DELETE)
    @Transactional
    public String delete(@PathVariable Integer id){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println("auth.getName::"+auth.getName());
    	User users = userRepository.findByEmailId(auth.getName());
    	List<Notes> notes = (List<Notes>) users.getNotes();
    	for (Notes notes2 : notes) {
			if(notes2.getId() == id){
				notesRepository.delete(id);
				return "success";
			}
		}
    	return "failure";
    	
    	
    	
    }

	
    
}