package com.dextrus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dextrus.entity.Folder;
@Repository
public interface FolderRepository extends JpaRepository<Folder, Integer>{
}
