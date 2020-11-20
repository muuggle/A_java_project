//public class Person {
//    private String name;
//    private int age;
//
//
//    public Person(String name) {
//        this.name = name;
////        this.age = age;
//    }
//
//    public void setName(String name1, String name2) {
//        this.name = name1 + " " + name2;
//
//    }
//
//    public String getName() {
//        return name;
//
//    }
//
//        public int getAge() {
//        return age;
//
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public void setAge(int age){
//        if (age < 0 || age > 100) {
//            throw new IllegalArgumentException("invalid age value");
//        }
//        this.age = age;
//    }
//}
public class Person {

    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;

    @Range(min = 1, max = 100)
    public int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{Person: name=%s, city=%s, age=%d}", name, city, age);
    }
}


