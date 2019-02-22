package com.zc.loginserver.singleton;

/**
 * Created by zhuCan
 * Project parent.
 * Date 2019/2/21   Time 9:04.
 * <p>
 * 双检锁单例模式,线程安全
 */
public class SingletonLock {

    private static volatile SingletonLock singletonLock;

    private SingletonLock() {
    }

    public static SingletonLock getInstance() {
        if (singletonLock == null) {
            synchronized (SingletonLock.class) {
                if (singletonLock == null) {
                    singletonLock = new SingletonLock();
                }
            }
        }
        return singletonLock;
    }
}
