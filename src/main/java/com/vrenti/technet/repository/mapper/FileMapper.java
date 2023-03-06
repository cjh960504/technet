package com.vrenti.technet.repository.mapper;

import com.vrenti.technet.domain.dto.File;
import com.vrenti.technet.repository.sql.FileSQL;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FileMapper {
    @Insert(FileSQL.INSERT_IMAGE)
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    public int insertImage(@Param("file") File file);
}
