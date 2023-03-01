package com.vrenti.technet.service;

import com.vrenti.technet.domain.dto.File;
import com.vrenti.technet.repository.mapper.FileMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService{

    private final FileMapper fileMapper;

    @Override
    public int insertImage(File file)  {
        return fileMapper.insertImage(file);
    }
}
