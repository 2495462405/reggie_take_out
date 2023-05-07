package com.klasjdw.reggie_take_out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klasjdw.reggie_take_out.entity.Employee;
import com.klasjdw.reggie_take_out.mapper.EmployeeMapper;
import com.klasjdw.reggie_take_out.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.service.impl
 * @date 2023/3/21 14:14
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
