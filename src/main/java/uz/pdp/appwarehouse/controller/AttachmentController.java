package uz.pdp.appwarehouse.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.AttachmentService;

@RestController
@RequestMapping("/attachment")

public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @SneakyThrows
    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){

        Result result = attachmentService.uploadFile(request);
        return result;

    }

}
