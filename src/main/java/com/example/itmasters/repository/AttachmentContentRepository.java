package com.example.itmasters.repository;

import com.example.itmasters.entity.Attachment;
import com.example.itmasters.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
//    @Query(value = "select a from AttachmentContent a where a.attachment.id = ?1")
//    Optional<AttachmentContent> findByAttachmentId(Integer attachment_id);
}
