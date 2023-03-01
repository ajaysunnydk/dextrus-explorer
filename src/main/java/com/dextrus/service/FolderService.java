package com.dextrus.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextrus.dao.FolderRepository;
import com.dextrus.entity.Explorer;
import com.dextrus.entity.Folder;

import jakarta.transaction.Transactional;

@Service
public class FolderService {

	@Autowired
	private FolderRepository folderRepository;
	
	public List<Explorer> getExplorer() {
        List<Folder> entities = folderRepository.findAll();
        
        Map<Integer, Explorer> expMap = new HashMap<>();
        for (Folder entity : entities) {
            Explorer node = new Explorer();
            node.setId(entity.getId());
            node.setName(entity.getName());
            node.setType(entity.getType());
            node.setParentId(entity.getParentID());
            expMap.put(entity.getId(), node);
        }  
        List<Explorer> roots = new ArrayList<>();
        for (Explorer node : expMap.values()) {
            if (node.getParentId() == null) {
                roots.add(node);
            } else {
                Explorer parent = expMap.get(node.getParentId());
                if (parent != null) {
                    parent.getChildren().add(node);
                }
            }
        }
        
        return roots;
    }

	public void addFolderOrFile(String type, String name, int parentId) {
		int count = folderRepository.countOfRowsWithSameNameAndParentId(parentId, name);
		if(count==0) {
			Folder folder = new Folder();
			folder.setName(name);
			folder.setParentID(parentId);
			folder.setType(type);
			folderRepository.save(folder);			
		}
		else {
			name += "("+count+")";
			Folder folder = new Folder();
			folder.setName(name);
			folder.setParentID(parentId);
			folder.setType(type);
			folderRepository.save(folder);	
		}
	}

	@Transactional
	public void deleteFileOrFolder(int id) {
		folderRepository.deleteAllByParentId(id);
		folderRepository.deleteById(id);
	}

	public void renameFileOrFolder(int id, String newName) {

	}
	

	
}
