import java.util.Scanner;

public class 普通状态位的通知停止 {
    private static boolean condition = true;

    static class 写作业 implements Runnable {
        @Override
        public void run() {
            while (condition) {
                try {
                    System.out.println("写第一份作业");
                    Thread.sleep(3 * 1000);
                    System.out.println("写第二份作业");
                    Thread.sleep(3 * 1000);
                    System.out.println("写第三份作业");
                    Thread.sleep(3 * 1000);
                    System.out.println("写第四份作业");
                    Thread.sleep(3 * 1000);
                    System.out.println("写第五份作业");
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    // 如果睡了，通过这里来知道要停止的消息
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new 写作业());
        t.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("准备通知停止写作业");
        condition = false; // 不具备让 A 的 sleep 抛异常的功能
        System.out.println("已经通知停止写作业");
        t.join();
        System.out.println("已经停止写作业");
    }
}


