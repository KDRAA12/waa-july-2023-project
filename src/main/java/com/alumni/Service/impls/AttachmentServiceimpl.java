package com.alumni.Service.impls;

import com.alumni.Service.AttachmentService;
import com.alumni.dtos.response.AttachmentDTO;
import com.alumni.dtos.response.AttachmentUploadResponseDTO;
import com.alumni.entity.Attachment;
import com.alumni.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class AttachmentServiceimpl implements AttachmentService {

    @Autowired
    public AttachmentRepository attachmentRepository;

    private final String STORAGE_PATH = "/Users/poweruser/Desktop/waa-project/storage/";
    private final String API_HOST = "http://localhost:8080/api/v1/attachments";


    @Override
    public AttachmentUploadResponseDTO uploadAttachment(MultipartFile file) throws IOException {

        int hash_code = file.hashCode();

        String filePath = STORAGE_PATH + file.getOriginalFilename() + hash_code;
        String fileName = file.getOriginalFilename() + hash_code;

        String url = API_HOST + "/" + fileName;
        System.out.println(url);

        Attachment attachment = new Attachment ();

        attachment.setName(fileName);
        attachment.setUrl(url);
        attachment.setType(file.getContentType());
        attachment.setFilePath(filePath);

        attachment = attachmentRepository.save(attachment);

        file.transferTo(new File(filePath));

        if (attachment != null) {
            return AttachmentUploadResponseDTO.builder()
                    .id(attachment.getId())
                    .type(attachment.getType())
                    .url(attachment.getUrl()).build();
        }

        return null;
    }

    @Override
    public AttachmentDTO getAttachment(String name) throws IOException {
        System.out.println(name);
        Optional<Attachment> attachment = attachmentRepository.findByName(name);
        String filePath = attachment.get().getFilePath();
        byte[] data = Files.readAllBytes(new File(filePath).toPath());
        return AttachmentDTO.builder()
                .type(attachment.get().getType())
                .data(data)
                .build();
    }
}
