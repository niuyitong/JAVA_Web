public class 演示不同线程下的状态 {
    private static void print() {
        Thread current = Thread.currentThread();

        // 之所以全部带着 id，是希望能分辨出我的打印是哪个线程打的
        System.out.println(current.getId() + ":" + current.getName());
        System.out.println(current.getId() + ":" + current.getPriority());
        System.out.println(current.getId() + ":" + current.getState());
        System.out.println(current.getId() + ":" + current.isDaemon());
        System.out.println(current.getId() + ":" + current.isAlive());
        System.out.println(current.getId() + ":" + current.isInterrupted());
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            print();    // 在子线程中打印
        });
        t.start();

        print();        // 在主线程中打印
    }
}
