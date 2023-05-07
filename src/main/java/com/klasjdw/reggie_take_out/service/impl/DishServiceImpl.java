package com.klasjdw.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klasjdw.reggie_take_out.dto.DishDto;
import com.klasjdw.reggie_take_out.entity.Dish;
import com.klasjdw.reggie_take_out.entity.DishFlavor;
import com.klasjdw.reggie_take_out.mapper.DishMapper;
import com.klasjdw.reggie_take_out.service.DishFlavorService;
import com.klasjdw.reggie_take_out.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.service.impl
 * @date 2023/4/15 09:34
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;
    /**
     * 新增菜品同时保存对应的口味数据
     * @param dishDto
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        //保存菜品的基本信息到dish表
        this.save(dishDto);

        Long dishId = dishDto.getId();

        //菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //保存菜品口味数据到菜品口味表dish_flavor
//        dishFlavorService.saveBatch(dishDto.getFlavors());

    }
}
