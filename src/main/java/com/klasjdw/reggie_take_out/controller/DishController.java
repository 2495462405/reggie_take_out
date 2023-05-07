package com.klasjdw.reggie_take_out.controller;

import com.klasjdw.reggie_take_out.common.R;
import com.klasjdw.reggie_take_out.dto.DishDto;
import com.klasjdw.reggie_take_out.entity.Dish;
import com.klasjdw.reggie_take_out.service.DishFlavorService;
import com.klasjdw.reggie_take_out.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.controller
 * @date 2023/5/4 15:15
 */
@RestController
@RequestMapping("/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private DishFlavorService dishFlavorService;

    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto) {
        log.info(dishDto.toString());
        return null;
    }
}
