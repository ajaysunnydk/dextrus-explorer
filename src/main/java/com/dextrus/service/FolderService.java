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
	

	
}
