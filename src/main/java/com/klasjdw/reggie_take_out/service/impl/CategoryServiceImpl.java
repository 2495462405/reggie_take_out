package com.klasjdw.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klasjdw.reggie_take_out.common.CustomException;
import com.klasjdw.reggie_take_out.entity.Category;
import com.klasjdw.reggie_take_out.entity.Dish;
import com.klasjdw.reggie_take_out.entity.Setmeal;
import com.klasjdw.reggie_take_out.mapper.CategoryMapper;
import com.klasjdw.reggie_take_out.service.CategoryService;
import com.klasjdw.reggie_take_out.service.DishService;
import com.klasjdw.reggie_take_out.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.service.impl
 * @date 2023/4/15 09:06
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;
    //根据id删除分类，删除之前需要判断
    @Override
    public void remove(Long ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        int count = dishService.count(dishLambdaQueryWrapper);
        //查询是否关联了菜品
        if (count > 0) {
            //已经关联菜品抛出异常
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }


        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        int count1 = setmealService.count(setmealLambdaQueryWrapper);
        //是否关联了套餐
        if (count1 > 0) {
            //已经关联套餐，抛出异常
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }
        //正常删除分类
        super.removeById(ids);
    }
}
