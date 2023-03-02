package com.dextrus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private ResponseEntity<Explorer> getExplorer() {
		List<Explorer> explorer = folderService.getExplorer();
		Explorer exp = explorer.get(0);
		return new ResponseEntity<Explorer>(exp, HttpStatus.OK);
	}

	@PostMapping("/{type}/{name}/{parentId}")
	private ResponseEntity<Void> addFolderOrFile(@PathVariable String type, @PathVariable String name,
			@PathVariable int parentId) {
		folderService.addFolderOrFile(type, name, parentId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> deleteFileOrFolder(@PathVariable int id) {
		if (folderService.deleteFileOrFolder(id) == "PARENT_NULL") {
			return new ResponseEntity<String>("PARENT_NULL",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("DELETED",HttpStatus.OK);
		}
	}

	@PutMapping("/{id}/{newName}")
	private ResponseEntity<Void> renameFileOrFolder(@PathVariable int id, @PathVariable String newName) {
		folderService.renameFileOrFolder(id, newName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
