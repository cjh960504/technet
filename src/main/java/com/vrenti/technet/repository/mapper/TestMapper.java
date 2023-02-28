package com.vrenti.technet.repository.mapper;

import com.vrenti.technet.domain.vo.TestVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Insert("INSERT INTO TEST(name) VALUES(#{test.name})")
    int insert(@Param("test") TestVO test);

    @Select("SELECT ID, NAME FROM TEST")
    List<TestVO> findAll();

    @Select("SELECT NAME FROM TEST WHERE ID = #{id}")
    TestVO findById(int id);
}
