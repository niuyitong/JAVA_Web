public class synchronized语法演示 {
    synchronized void 普通方法() {
    }
    void 普通方法2(){
        synchronized (this) {
        }
    }
    synchronized static void 静态方法() {
    }
    //等价于
    static void 静态方法2(){
        synchronized (synchronized语法演示.class) {
            // 随便什么
        }
    }
    void 其他方法() {
        Object 一个引用 = new Object();
        synchronized (一个引用) {
        }
    }
}
