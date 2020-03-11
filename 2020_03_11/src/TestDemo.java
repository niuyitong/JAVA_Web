class A{
    public int a = 10;
    public A(){
        System.out.println("A构造");
    }
    public void test(){
        System.out.println("testA");
    }
    public void Atest(){
        System.out.println("Atest");
    }
}
class B extends A {
    public int a = 10;

    public B() {
        System.out.println("B构造");
    }

    public void test() {
        System.out.println("testB");
    }
    public void Btest(){
        System.out.println("Btest");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        //A a = new A();
        //a.test();
        B  b = new B();
        b.test();
        b.Atest();
        A c = new B();
        c.test();
        //c.Btest();

    }
}
