package com.klasjdw.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klasjdw.reggie_take_out.entity.Setmeal;
import com.klasjdw.reggie_take_out.mapper.SetmealMapper;
import com.klasjdw.reggie_take_out.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.service.impl
 * @date 2023/4/15 09:35
 */
@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
