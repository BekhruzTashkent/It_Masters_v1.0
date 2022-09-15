//package com.example.itmasters.controller;
//
//
//import com.example.itmasters.entity.Attachment;
//import com.example.itmasters.entity.AttachmentContent;
//import com.example.itmasters.payload.AttachmentDto;
//import com.example.itmasters.repository.AttachmentContentRepository;
//import com.example.itmasters.repository.AttachmentRepository;
//import lombok.AllArgsConstructor;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Optional;
//
//
//@Controller
//@RestController
//@RequestMapping("/api/attachment")
//@AllArgsConstructor
//public class AttachmentController {
//
//    private final AttachmentRepository attachmentRepository;
//    private final AttachmentContentRepository attachmentContentRepository;
//
//    private static final String uploadDirectory = "yuklangan";
//
//    @PostMapping("/upload")
//    public String uploadFileToDB(MultipartHttpServletRequest request, AttachmentDto attachmentDto) throws IOException //we need this because file comes as a lot of part
//    {
//        Iterator<String> fileNames = request.getFileNames();
//        MultipartFile file = request.getFile(fileNames.next());
//
//        if (file != null) {
//
//            Attachment attachment = new Attachment();
//
//            String originalFileName = file.getOriginalFilename();
//            long size = file.getSize();
//            String contentType = file.getContentType();
//
//
//            attachment.setFileOriginalName(originalFileName);
//            attachment.setSize(size);
//            attachment.setContentType(contentType);
//            Attachment savedAttachment = attachmentRepository.save(attachment);
//
//            AttachmentContent attachmentContent = new AttachmentContent();
//            attachmentContent.setMainContent(file.getBytes());
//            attachmentContent.setAttachment(savedAttachment);
//            attachmentContentRepository.save(attachmentContent);
//
//            return "File saved. Id: " + savedAttachment.getId();
//        }
//        return "error";
//    }
//
//    @GetMapping("/download/{id}")
//    public void getFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
//
//        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
//        if (optionalAttachment.isPresent()) {
//            Attachment attachment = optionalAttachment.get();
//            Optional<AttachmentContent> contentOptional = attachmentContentRepository.findByAttachmentId(id);
//            if (contentOptional.isPresent()) {
//
//                AttachmentContent attachmentContent = contentOptional.get();
//
//
//                //sending to clientoriginal name
//                response.setHeader("Content-Disposition", "attachment; filename = \""
//                        + attachment.getFileOriginalName() + "\"");
//
//                response.setContentType(attachment.getContentType());  //sending to client content type
//
//                FileCopyUtils.copy(attachmentContent.getMainContent(), response.getOutputStream()); ////sending to client bytes
//
//            }
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteFile(@PathVariable Integer id) {
//        attachmentContentRepository.deleteById(id);
//    }
//
//
//    @PutMapping("/update/{id}")
//    public String updateFile(@PathVariable Integer id, MultipartHttpServletRequest request) throws IOException {
//        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
//        if (optionalAttachment.isPresent()) {
//            Attachment attachment = optionalAttachment.get();
//            Optional<AttachmentContent> contentOptional = attachmentContentRepository.findByAttachmentId(id);
//            if (contentOptional.isPresent()) {
//                AttachmentContent attachmentContent = contentOptional.get();
//                Iterator<String> fileNames = request.getFileNames();
//                MultipartFile file = request.getFile(fileNames.next());
//
//                if (file != null) {
//
//                    String originalFileName = file.getOriginalFilename();
//                    long size = file.getSize();
//                    String contentType = file.getContentType();
//
//
//                    attachment.setFileOriginalName(originalFileName);
//                    attachment.setSize(size);
//                    attachment.setContentType(contentType);
//                    Attachment savedAttachment = attachmentRepository.save(attachment);
//
//                    attachmentContent.setMainContent(file.getBytes());
//                    attachmentContent.setAttachment(savedAttachment);
//                    attachmentContentRepository.save(attachmentContent);
//
//                    return "File saved. Id: " + savedAttachment.getId();
//                }
//
//            }
//        }
//        return "error";
//    }
//}
