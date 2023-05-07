package com.klasjdw.reggie_take_out.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.klasjdw.reggie_take_out.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.mapper
 * @date 2023/3/21 14:11
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
