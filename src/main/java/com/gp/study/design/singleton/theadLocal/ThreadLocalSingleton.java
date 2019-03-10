package com.gp.study.design.singleton.theadLocal;


/**
 * 为每个线程分配 独自的单例对象
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> INSTANCE = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static Object getInstance(){
        return INSTANCE.get();
    }
}
