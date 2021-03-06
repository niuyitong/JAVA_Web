package 通讯录;


import java.io.*;
import java.util.*;

public class Main {
    // 所有的名单保存到一个 List 中
    private static List<Person> personList = new ArrayList<>();
    // 根据姓名，找个人信息
    private static Map<String, Person> namePersonMap = new HashMap<>();
    // 根据电话，找个人信息
    private static Map<String, Person> phonePersonMap = new HashMap<>();

    private static void add() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名> ");
        String name = scanner.nextLine();
        System.out.print("请输入电话> ");
        String phone = scanner.nextLine();
        System.out.print("请输入地址> ");
        String address = scanner.nextLine();
        System.out.print("请输入备注> ");
        String mark = scanner.nextLine();

        Person p = new Person(name, phone, address, mark);
        // 没有考虑姓名或者电话重复的情况
        personList.add(p);
        namePersonMap.put(p.name, p);
        phonePersonMap.put(p.phone, p);

        try (OutputStream os = new FileOutputStream("通讯录.dump")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(personList);
                oos.writeObject(namePersonMap);
                oos.writeObject(phonePersonMap);
                oos.flush();
            }
        }
    }

    private static void queryByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名> ");
        String name = scanner.nextLine();

        Person p = namePersonMap.get(name);
        if (p == null) {
            System.out.println("查无此人");
        } else {
            System.out.println(p);
        }
    }

    private static void queryByPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入电话> ");
        String phone = scanner.nextLine();

        Person p = phonePersonMap.get(phone);
        if (p == null) {
            System.out.println("查无此人");
        } else {
            System.out.println(p);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("通讯录.dump");
        if (file.exists()) {
            //如果文件存在，则读出来，读到personList、namePersonMap、
            // phonePersonMap里，供运行时查询使用
            try (InputStream is = new FileInputStream("通讯录.dump")) {
                try (ObjectInputStream ois = new ObjectInputStream(is)) {
                    personList = (List<Person>) ois.readObject();
                    namePersonMap = (Map<String, Person>) ois.readObject();
                    phonePersonMap = (Map<String, Person>) ois.readObject();
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. add");
            System.out.println("2. query by name");
            System.out.println("3. query by phone");

            int select = scanner.nextInt();
            scanner.nextLine();

            if (select == 1) {
                add();
            } else if (select == 2) {
                queryByName();
            } else {
                queryByPhone();
            }
        }
    }
}
