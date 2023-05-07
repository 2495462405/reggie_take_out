package com.klasjdw.reggie_take_out.common;

/**
 * 基于ThreadLocal封装的工具类，用于保存和获取当前登陆用户的id
 * @author klasjdw
 * @Package com.klasjdw.reggie_take_out.common
 * @date 2023/4/15 08:49
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param id
     */
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    /**
     * 获取值
     * @return
     */
    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
