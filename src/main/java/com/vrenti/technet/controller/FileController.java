package com.vrenti.technet.controller;

import com.vrenti.technet.domain.dto.File;
import com.vrenti.technet.domain.vo.Message;
import com.vrenti.technet.domain.vo.StatusEnum;
import com.vrenti.technet.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @Value("${resources.location}")
    private String filePath;

    @ResponseBody
    @PostMapping(value = "/file/image", consumes = {"multipart/form-data"})
    public ResponseEntity<Message> uploadImage(@RequestParam(value = "image") MultipartFile image){
        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        message.setMessage("저장한 파일ID");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        String fileName = null;
        String fileExt = null;
        String fileNameKey = null;
        // 파일이 저장될 Path 설정

        //String filePath = "C:\\board\\file";
        LocalDate date = LocalDate.now();
        String addPath = date.getYear() + "/" + date.getMonthValue() + "/" + date.getDayOfMonth() + "/";
        filePath += addPath;


        java.io.File file = new java.io.File(filePath);
        if (file.exists() == false) {
            file.mkdirs();
        }

        fileName = image.getOriginalFilename();
        fileExt = fileName.substring(fileName.lastIndexOf("."));
        // 파일명 변경(uuid로 암호화) + 확장자
        fileNameKey = UUID.randomUUID().toString().replaceAll("-", "") + fileExt;

        try {
            file = new java.io.File(filePath + "/" + fileNameKey);

            image.transferTo(file);

            File fileDto = new File();
            fileDto.setMemberId(1); // 후에 게시판을 작성하는 회원ID로
            fileDto.setOrgName(fileName);
            fileDto.setType(fileExt); //이미지 형식만
            fileDto.setRegName(fileNameKey);
            fileDto.setSize((int) image.getSize());
            fileDto.setUploadIp("");
            fileDto.setUseAt(1);
            fileDto.setImageAt('1');


            if(fileService.insertImage(fileDto) == 0){
                message.setStatus(StatusEnum.BAD_REQUEST);
                message.setData("이미지 등록 실패");
            } else {
                HashMap<String, Object> map = new HashMap<>();
                map.put("orgFileName", fileDto.getOrgName());
                map.put("regFileName", fileDto.getRegName());
                message.setData(map);
            }
            return new ResponseEntity(message, headers, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @PostMapping(value = "/file/images", consumes = {"multipart/form-data"})
    public ResponseEntity<Message> uploadImages(@RequestParam(value = "image") List<MultipartFile> imageList){
        List<Map<String, Object>> resultData = new ArrayList<>();

        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        message.setMessage("저장한 파일ID");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));


        for (MultipartFile image : imageList){
            System.out.println(image.getOriginalFilename());
            HashMap<String, Object> map = new HashMap<>();
            map.put("파일이름", image.getOriginalFilename());
            map.put("등록된 파일ID", UUID.randomUUID());
            resultData.add(map);

        }
        message.setData(resultData);

        return new ResponseEntity(message, headers, HttpStatus.OK);
    }
}
