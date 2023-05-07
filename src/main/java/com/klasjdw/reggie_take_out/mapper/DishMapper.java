package com.klasjdw.reggie_take_out.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.klasjdw.reggie_take_out.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.mapper
 * @date 2023/4/15 09:32
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
