package com.example.itmasters.repository;

import com.example.itmasters.entity.Attachment;
import com.example.itmasters.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}
