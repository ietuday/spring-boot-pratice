package com.uday.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
