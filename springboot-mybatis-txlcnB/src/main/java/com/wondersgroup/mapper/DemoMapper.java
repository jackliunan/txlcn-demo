package com.wondersgroup.mapper;

import com.wondersgroup.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 * Date: 2018/12/25
 *
 * @author ujued
 */
@Mapper
public interface DemoMapper {

    void save(Demo demo);

    void deleteByKId(Long id);
}
