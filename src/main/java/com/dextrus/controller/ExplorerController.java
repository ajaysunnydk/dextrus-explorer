package com.dextrus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dextrus.entity.Explorer;
import com.dextrus.service.FolderService;

@RestController
@RequestMapping("/dextrus")
public class ExplorerController {
	
	@Autowired
	private FolderService folderService;
	
	@GetMapping("/explorer")
	private ResponseEntity<Explorer> getExplorer(){
		List<Explorer> explorer = folderService.getExplorer();
		Explorer exp = explorer.get(0);
		return new ResponseEntity<Explorer>(exp,HttpStatus.OK) ;
	}
	
}
