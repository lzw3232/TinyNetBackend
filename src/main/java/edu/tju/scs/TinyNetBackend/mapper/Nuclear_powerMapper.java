package edu.tju.scs.TinyNetBackend.mapper;

import edu.tju.scs.TinyNetBackend.model.po.Nuclear_power;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Nuclear_powerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nuclear_power record);

    int insertSelective(Nuclear_power record);

    Nuclear_power selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nuclear_power record);

    int updateByPrimaryKey(Nuclear_power record);
    Integer countB();
    Integer countB1(@Param("val") String val);

    List<Nuclear_power> selectByOwner(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps);
    List<Nuclear_power> selectByOwner1(@Param("username")String username, @Param("pi") Integer pi, @Param("ps")Integer ps,@Param("val") String val);
}
