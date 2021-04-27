package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Heat_storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Heat_storageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Heat_storage record);

    int insertSelective(Heat_storage record);

    Heat_storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Heat_storage record);

    int updateByPrimaryKey(Heat_storage record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Heat_storage> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Heat_storage> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
