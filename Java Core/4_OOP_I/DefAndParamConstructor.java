public class DefAndParamConstructor {

    static class Student {
        String name;
        int age;

        // Không tạo constructor thì compiler sẽ tự động tạo default constructor cho
        public int getAge() {
            return age;
        }
        public String getName() {
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return new String(name+": "+age);
        }
    }

    public static void main(String[] args) {
        Student newStudent = new Student();
        int age = 11;
        String name = "Trần Thập Nhất";
        System.out.println(newStudent.toString()); // null: 0

        newStudent.name = name;
        newStudent.age = age;
        System.out.println(newStudent.toString()); // Trần Thập Nhất: 11

    }
}
