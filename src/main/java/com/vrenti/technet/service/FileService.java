package com.vrenti.technet.service;

import com.vrenti.technet.domain.dto.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public int insertImage(File file);
}
