package com.zc.loginserver.singleton;

/**
 * Created by zhuCan
 * Project parent.
 * Date 2019/2/22   Time 10:46.
 * <p>
 * 静态内部类单例
 */


/**
 * @author zhuCan
 * date 2019/2/22 10:47
 * description :这种方式跟饿汉式方式采用的机制类似，但又有不同。 两者都是采用了类装载的机制来保证初始化实例时只有一个线程。不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 * 所以在这里，利用 JVM的 classloder 的机制来保证初始化 instance 时只有一个线程。JVM 在类初始化阶段会获取一个锁，这个锁可以同步多个线程对同一个类的初始化
 * 优点：避免了线程不安全，延迟加载，效率高。
 * 缺点：依旧不能解决在反序列化、反射、克隆时重新生成实例对象的问题
 */
public class StaticSingleton {
    private StaticSingleton() {
    }

    private static class SingletonInstance {
        private final static StaticSingleton singleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonInstance.singleton;
    }
}
