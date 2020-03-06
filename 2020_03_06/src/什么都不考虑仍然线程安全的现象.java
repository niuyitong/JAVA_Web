public class 什么都不考虑仍然线程安全的现象 {
    private static int[] array = new int[10000];

    private static class 计算前半段 extends Thread {
        @Override
        public void run() {
            long n = 0;
            for (int i = 0; i < 10000; i++) {
                //for (int i = 0; i < 5000; i++) {
                n += array[i];
            }
            System.out.println(n);
        }
    }

    private static class 计算后半段 extends Thread {
        @Override
        public void run() {
            long n = 0;
            for (int i = 0; i < 10000; i++) {
                //for (int i = 0; i < 5000; i++) {
                //n += array[i + 5000];
                n += array[i];
            }
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            array[i] = 1;
        }

        Thread front = new 计算前半段();
        Thread back = new 计算后半段();
        front.start();
        back.start();
    }
}

