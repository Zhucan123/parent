package com.zc.loginserver.singleton;

/**
 * Created by zhuCan
 * Project parent.
 * Date 2019/3/26   Time 11:20.
 * <p>
 * 枚举单例,因为枚举本质上也是一个类,只不过是继承了Enum并且是final修饰的,
 * 并且enum有且仅有private修饰的构造方法,
 * 特点,1.简洁 2.天然线程安全 3.支持序列化
 */
public enum EnumSingleton {
    INSTANCE;
    private SingletonInstance singletonInstance;

    EnumSingleton() {
        singletonInstance = new SingletonInstance();
    }

    public SingletonInstance getSingletonInstance() {
        return singletonInstance;
    }
}

class SingletonInstance {

}

class test {
    private SingletonInstance instance = EnumSingleton.INSTANCE.getSingletonInstance();
}

/**
 * @author zhuCan
 * date 2019/3/26 11:25
 * description :
 * <p>
 * public enum T {
 * SPRING,SUMMER,AUTUMN,WINTER;
 * }
 * <p>
 * 编译后的状态
 * public final class T extends Enum
 * {
 * <p>
 * public static final T SPRING;
 * public static final T SUMMER;
 * public static final T AUTUMN;
 * public static final T WINTER;
 * private static final T ENUM$VALUES[];
 * static
 * {
 * SPRING = new T("SPRING", 0);
 * SUMMER = new T("SUMMER", 1);
 * AUTUMN = new T("AUTUMN", 2);
 * WINTER = new T("WINTER", 3);
 * ENUM$VALUES = (new T[] {
 * SPRING, SUMMER, AUTUMN, WINTER
 * });
 * }
 * }
 */