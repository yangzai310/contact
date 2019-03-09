package com.gp.study.design.singleton.inner;

/**
 * 内部静态类 单例
 */
public class InnerSingleton {

    private InnerSingleton(){}

    public static InnerSingleton getInstance (){
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final InnerSingleton INSTANCE = new InnerSingleton();
    }
}
