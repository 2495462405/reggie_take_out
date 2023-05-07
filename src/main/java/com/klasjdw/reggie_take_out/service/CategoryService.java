package com.klasjdw.reggie_take_out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klasjdw.reggie_take_out.entity.Category;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.service
 * @date 2023/4/15 09:05
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
