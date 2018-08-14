package ch2.singleton;

/**
 * @author 黄世鹏
 * @date 2018/8/14 17:52
 * @description: 单例1 线程安全却没有延迟加载 使用到这个类就会构造一个单例 即使没有用到
 */
public class Singleton {
    private Singleton(){
        System.out.println("调用单例构造方法");
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}
