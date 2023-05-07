package com.klasjdw.reggie_take_out.common;

/**
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.common
 * @date 2023/4/15 09:49
 * 自定义用户异常
 */
public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super(message);
    }
}
