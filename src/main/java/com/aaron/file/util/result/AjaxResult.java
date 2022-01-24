package com.aaron.file.util.result;

/**
 * Created by  on 2017/11/8.
 */
public class AjaxResult {
    public  static  final  String STATE_SUCCESS ="0";//success
    public static  final  String STATE_ERROR="1";//error

    public static AjaxResult success() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(STATE_SUCCESS);
        return ajaxResult;
    }
    public static AjaxResult successWithData(Object data) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(STATE_SUCCESS);
        ajaxResult.setData(data);
        return ajaxResult;
    }
    public  static  AjaxResult successState(String message,int code,Object data){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setMessage(message);
        ajaxResult.setCode(code);
        ajaxResult.setData(data);
       return  ajaxResult;
    }
    public static AjaxResult error(String message) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setState(STATE_ERROR);
        ajaxResult.setMessage(message);
        return ajaxResult;
    }
    public static AjaxResult error(String message,int code) {
        AjaxResult ajaxResult = new AjaxResult();
       ajaxResult.setCode(code);
        ajaxResult.setMessage(message);
        return ajaxResult;
    }


    private  String state;

    public  AjaxResult(){}
    public  AjaxResult(String state,String message){
        this.state=state;
        this.message=message;
    }
    public  AjaxResult(String state){
        this.state=state;
    }
    public AjaxResult(String state,Object data){
        this.state=state;
        this.data=data;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private String message;
    private Object data;
    private  int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}