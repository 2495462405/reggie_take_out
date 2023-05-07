package com.klasjdw.reggie_take_out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klasjdw.reggie_take_out.dto.DishDto;
import com.klasjdw.reggie_take_out.entity.Dish;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.service
 * @date 2023/4/15 09:33
 */
public interface DishService extends IService<Dish> {

    public void saveWithFlavor(DishDto dishDto);
}
