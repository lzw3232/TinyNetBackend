package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Cool_storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Cool_storageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cool_storage record);

    int insertSelective(Cool_storage record);

    Cool_storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cool_storage record);

    int updateByPrimaryKey(Cool_storage record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Cool_storage> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Cool_storage> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
