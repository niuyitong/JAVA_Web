public class 线程的所有状态 {
    public static void main(String[] args) {
        // 遍历该枚举中所有的可选项
        // 也就是线程所有的状态
        Thread.State[] values = Thread.State.values();

        for (Thread.State state : values) {
            System.out.println(state);
        }
    }
}