package com.dextrus.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dextrus.entity.Folder;
@Repository
public interface FolderRepository extends JpaRepository<Folder, Integer>{
    @Modifying
    @Query("delete from Folder f where f.parentid = ?1")
    void deleteAllByParentId(Integer parentId);
}
