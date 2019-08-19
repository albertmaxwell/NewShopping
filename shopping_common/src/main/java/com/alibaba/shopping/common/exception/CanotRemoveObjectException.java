package com.alibaba.shopping.common.exception;




/**
 * 自定义异常
 */
public class CanotRemoveObjectException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public void printStackTrace(){
        System.out.println("删除对象错误!");
        super.printStackTrace();
    }
}