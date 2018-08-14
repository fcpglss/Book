package ch2.singleton;

/**
 * @author 黄世鹏
 * @date 2018/8/14 20:16
 * @description: 调用getInstance时才会加载内部类，懒加载完成
 *      jvm保证加载类时的原子性，并发安全
 */
public class InnerSingleton {
    private InnerSingleton(){
        System.out.println("初始化单例");
    }
    private static class Inner{
        private static InnerSingleton instance = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return Inner.instance;
    }
}
