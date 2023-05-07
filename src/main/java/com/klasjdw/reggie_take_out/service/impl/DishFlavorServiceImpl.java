package com.klasjdw.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klasjdw.reggie_take_out.entity.DishFlavor;
import com.klasjdw.reggie_take_out.mapper.DishFlavorMapper;
import com.klasjdw.reggie_take_out.service.DishFlavorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.service.impl
 * @date 2023/5/4 15:12
 */
@Service
@Slf4j
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
