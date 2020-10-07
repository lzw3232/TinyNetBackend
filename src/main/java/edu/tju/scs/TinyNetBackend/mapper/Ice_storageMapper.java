package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Battery;
import edu.tju.scs.TinyNetBackend.model.po.Ice_storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Ice_storageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ice_storage record);

    int insertSelective(Ice_storage record);

    Ice_storage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ice_storage record);

    int updateByPrimaryKey(Ice_storage record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Ice_storage> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Ice_storage> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
