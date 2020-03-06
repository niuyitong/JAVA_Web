public class 演示枚举 {
    enum Gender {
        男性, 女性;
    }

    static class Person {
        // 性别
        String genderStr = "男性"; // 明确，缺点是浪费

        int genderInt = 1;         // 存储简单，但意义容易丢失

        boolean genderBoolean = true; // 存储简单，但意义容易丢失

        Gender gender = Gender.男性;  // 存储简单，意义明确，也不能随便填
    }

    public static void main(String[] args) {
        Gender[] values = Gender.values();
        for (Gender gender : values) {
            System.out.println(gender);
        }
    }
}
