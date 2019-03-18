package com.gupaoedu.vip.singleton.pattern.RegsiterSingletonPattern;

public enum EnumSingletonPattern {
    INSTANCE;

   private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public  static EnumSingletonPattern getInstance(){
        return  INSTANCE;
    }
}
