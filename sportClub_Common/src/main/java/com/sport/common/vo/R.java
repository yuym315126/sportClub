package com.sport.common.vo;



/**
 * @program: OpenMain
 * @description:
 * @author: Feri(邢朋辉)
 * @create: 2020-07-28 16:47
 */
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <E> R<E> ok(String msg, E obj){
        R<E> r=new R<>();
        r.setCode(200);
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }

    public static <E> R<E> ok(String msg){
        R<E> r=new R<>();
        r.setCode(200);
        r.setMsg(msg);
        return r;
    }

    public static <E> R<E> ok(E obj){
        R<E> r=new R<>();
        r.setCode(200);
        r.setData(obj);
        return r;
    }

    public static R ok(){
        return ok("OK",null);
    }

    public static <E> R<E> fail(String msg, E obj){
        R<E> r=new R<>();
        r.setCode(400);
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }

    public static <E> R<E> fail(String msg){
        R<E> r=new R<>();
        r.setCode(400);
        r.setMsg(msg);
        return r;
    }

    public static <E> R<E> fail(E obj){
        R<E> r=new R<>();
        r.setCode(400);
        r.setData(obj);
        return r;
    }

    public static R fail(){
        return R.fail("fail",null);
    }



}