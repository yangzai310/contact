package com.gp.study.design.singleton.theadLocal;

// ???
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    private static final ThreadLocal<Object> THREAD_LOCAL;

    static {
        THREAD_LOCAL = new ThreadLocal<>();
    }

    public static Object getInstance(){
        return THREAD_LOCAL.get();
    }
}
