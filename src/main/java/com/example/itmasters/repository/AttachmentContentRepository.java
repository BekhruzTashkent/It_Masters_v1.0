package com.example.itmasters.repository;

import com.example.itmasters.entity.Attachment;
import com.example.itmasters.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {

}
