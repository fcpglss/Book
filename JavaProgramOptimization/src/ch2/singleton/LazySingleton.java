package ch2.singleton;

/**
 * @author 黄世鹏
 * @date 2018/8/14 17:57
 * @description: 单例没有被创建才构建单例，并且给获取单例的方法加锁，
 *  实现了懒加载，但构建单例的速度慢了
 */
public class LazySingleton {
    private LazySingleton() {
        System.out.println("调用单例构造方法");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
