package com.warren.thread.single;

/**
 * 枚举单例
 * enum 是一个什么？ 本身也是一个Class类
 */
public enum EnumSingle {
    INSTANCE;
    public static EnumSingle getInstance(){
        return INSTANCE;
    }

    // 模拟网站的访问数量
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num + 1;
    }
}
