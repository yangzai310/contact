package com.gp.study.design.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册容器 单例
 */
public class ContainerSingleton {

    private static final Map<String, Object> MAP = new ConcurrentHashMap<>(  );

    private ContainerSingleton(){}

    public static synchronized Object getInstance(String className) throws Exception {
        if(!MAP.containsKey( className )){
            Class<?> aClass = Class.forName( className );
            Object o = aClass.newInstance();
            MAP.put(className, o);
            return o;
        }
        return MAP.get( className );
    }

}
