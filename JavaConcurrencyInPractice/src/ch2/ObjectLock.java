package ch2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 黄世鹏
 * @date 2018/8/15 11:32
 * @description: 锁普通方法，会锁住该对象，对象的其他被锁的方法也需要等待，没有被锁的不需要。新的对象更不需要
 * 锁静态方法 会锁住class对象，其他的被锁的静态方法也需要等待，
 */
public class ObjectLock {

    private synchronized void fun1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fun1");
    }

    private void fun2() {
        System.out.println("fun2");
    }

    private synchronized static void staticFun1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static fun1 ");
    }

    private synchronized static void staticFun3() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static fun3 ");
    }

    private static void staticFun2() {
        System.out.println("static fun2 ");
    }

    public static void main(String[] args) {

//       test1();
        test2();
    }

    private static void test2() {
        Thread t1 = new Thread(() -> {
            ObjectLock.staticFun1();
        });
        Thread t2 = new Thread(() -> {
//            ObjectLock.staticFun2();
            try {
                Method method = ObjectLock.class.getDeclaredMethod("staticFun3");
                method.invoke(null, null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        System.out.println("t1 start ");
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep 500 t2 start");
        t2.start();
    }

    private static void test1() {
        ObjectLock objectLock = new ObjectLock();
//       Thread t1 =  new Thread(()->{
//            objectLock.fun1();
//        });
//        Thread t2 =  new Thread(()->{
//            objectLock.fun2();
//        });


//        t1.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t2.start();

    }
}
