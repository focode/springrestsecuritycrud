package com.gotprint.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
    @RequestMapping(value = "/createnotes",method=RequestMethod.POST,consumes = "application/json")
    @Transactional
    public Notes create(@RequestBody Notes note) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println("auth.getName::"+auth.getName());
    	notesRepository.save(note);
        return note;
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
    
    @RequestMapping(value="/delete/{id}/", method=RequestMethod.DELETE,consumes = "application/json")
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
    
    @RequestMapping(value="/update", method=RequestMethod.PUT,consumes = "application/json")
    @Transactional
    public ResponseEntity<?> update(@RequestBody Notes note){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println("auth.getName::"+auth.getName());
    	User users = userRepository.findByEmailId(auth.getName());
    	List<Notes> notes = (List<Notes>) users.getNotes();
    	for (Notes notes2 : notes) {
    		if(note.getId() == notes2.getId()){
    			// note belongs to user update it
    			notesRepository.save(note);
    			return new ResponseEntity<>(note, HttpStatus.OK);
    		}
    	}
    	return new ResponseEntity<>("", HttpStatus.NO_CONTENT); 
    }
    
}
