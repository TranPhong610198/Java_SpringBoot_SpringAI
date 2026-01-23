# 🚀 Java Core Checklist: Hành Trang Vào Spring Boot

Tài liệu này tổng hợp các kiến thức nền tảng Java bắt buộc phải nắm vững trước khi đi sâu vào Spring Boot. Mục tiêu là lấp lỗ hổng kiến thức và chuẩn bị tư duy tốt nhất cho Backend Development.

---

## 1. Cú pháp & Tư duy cơ bản (Level: PRO192)
> 💡 **Tầm quan trọng:** Đây là nền móng. Nếu quên phần này, bạn sẽ không thể viết logic code cơ bản.

- [x] **Biến & Kiểu dữ liệu**
    <details>
    <summary>🔻 <em>Phân biệt int vs Integer & Collection Framework</em></summary>

  - **Phân biệt rõ `int` (primitive) và `Integer` (wrapper class):**
    - `int` (primitive) là một trong những kiểu dữ liệu nguyên thủy lưu giá trị thực tế, không dùng được trong Collection.
    - `Integer` (wrapper class) là một đối tượng trỏ tới vùng nhớ chứa giá trị, và vì là một đối tượng nên nó có nhiều hàm hỗ trợ, và dùng được trong Collection.
  - **Collection Framework:** Trong Java, Collection Framework là một kiến trúc thống nhất nằm trong gói `java.util`, cung cấp các **Interface** (giao diện) và **Class** (lớp) để lưu trữ và thao tác với một nhóm các đối tượng. Collection chia làm 3 nhóm chính (Interface con của `Collection`: List, Set, Queue) và 1 nhóm đặc biệt (`Map`).
  - *Lý do:* Trong Database Mapping và Generic của Spring, bắt buộc phải dùng Wrapper Class.
    </details>

- [x] **String vs StringBuilder**
    <details>
    <summary>🔻 <em>Cơ chế Immutable & StringBuilder</em></summary>

  - **Hiểu cơ chế Immutable của String:**
    - **"Immutable"** nghĩa là **"Không thể thay đổi"**. Trong Java, một khi đối tượng `String` đã được tạo ra trong bộ nhớ (Heap), nội dung của nó **vĩnh viễn không bao giờ thay đổi**.
    - *Ví dụ:*
        ```java
        String s = "Hello";
        s = s + " World";
        // Có vẻ biến s đã thay đổi từ "Hello" sang "Hello World", nhưng thực ra là JAVA ko sửa chữ "Hello" mà nó tạo mội chuỗi mới "Hello World" và chuyển con trỏ của biến s sang "Hello World"
        ```
  - **Lưu ý:** Tránh dùng cộng chuỗi (`+`) trong vòng lặp, hãy dùng `StringBuilder` để tối ưu hiệu năng.
    - **StringBuilder (Mutable):** Nó như cái bảng trắng, khi bạn muốn thêm chữ, thì chỉ cần viết tiếp vào, không cần thay bảng mới. Bên trong StringBuilder là 1 mảng kí tự char[], khi append(), nó sẽ điền tiếp vào mảng. Khi mảng đầy, nó tự động tạo ra mảng mới to gấp đôi, và copy dữ liệu sang rồi dùng tiếp.
    </details>

- [x] **Control Flow (Luồng điều khiển):**
    <details>
    <summary>🔻 <em>Chi tiết</em></summary>

  - Thành thạo `if-else`, `switch-case`.
  - Các loại vòng lặp: `for`, `for-each`, `while`.
    </details>

- [x] **Mảng (Array):** Cách khai báo, khởi tạo và truy xuất phần tử cơ bản.

---

## 2. Lập trình hướng đối tượng - OOP (🔥 QUAN TRỌNG NHẤT)
> 💡 **Tầm quan trọng:** Spring Boot vận hành hoàn toàn dựa trên các nguyên lý này (DI/IoC). Nếu hổng chỗ này, bạn sẽ chỉ biết copy code mà không hiểu bản chất.

- [x] **Class & Object:** Tư duy về Lớp và Đối tượng (Instance).
    <details>
    <summary>🔻 <em>Định nghĩa Class & Object</em></summary>

  - **Class** là bản vẽ thiết kế, là 1 khải niệm trừu tượng, nằm trên giấy tờ.
  - **Object** là vật cụ thể đc tạo từ bản vẽ (**class**).
    </details>

### 🌟 4 Tính chất OOP

#### 1. Đóng gói (Encapsulation)
<details>
<summary>🛡️ <em>Xem chi tiết về Access Modifiers & Getter/Setter</em></summary>

- Hiểu về `private`, `public`, `protected`. Sử dụng Getter/Setter (Spring dùng cái này để map JSON vào Object).
- **Định nghĩa:** Đóng gói chính là việc che giấu dữ liệu bên trong, chỉ lộ ra những cái cần thiết (method) ra bên ngoài.
- **4 cấp độ bảo mật (Access Modifiers):**
  - **Private**: Chỉ nội bộ class mới thấy. **Kinh nghiệm** là mặc định luôn để private cho tất cả các thuộc tính, chỉ mở rộng khi thực sự cần thiết.
  - **Protected**: Cùng package, lớp con mới thấy. **Kinh nghiệm** là dùng khi thiết kế thư viện hoặc Framework để cho phép class con override.
  - **Public**: Toàn bộ dự án có thể dùng. **Kinh nghiệm** chỉ dùng cho các hàm API, các hằng số, hoặc class chính.
- **Getter/Setter:** Dùng để kiểm soát dữ liệu, Read-only hoặc Write-only, và đặc biệt tương thích với Framework. **Kinh nghiệm** thay vì ngồi gõ một đống Getter/Setter cho 10 class entity thì có thể dùng **Lombok**.
</details>

#### 2. Kế thừa (Inheritance)
<details>
<summary>🧬 <em>Xem chi tiết (Extends, Super, Composition over Inheritance)</em></summary>

- Sử dụng từ khóa `extends`.
- **Bản chất:** Kế thừa hay chính là quan hệ Is-A, ví dụ `Dog` **is an** `Animal` $\rightarrow$ Hợp lý.
    ```java
    // Lớp Cha (Super Class / Parent Class)
    class Animal {
        protected String name; // protected để con cháu dùng được
        public void eat() {
            System.out.println("Đang ăn...");
        }
    }
    // Lớp Con (Sub Class / Child Class)
    class Dog extends Animal { // Dog kế thừa TẤT CẢ từ Animal
        public void bark() {
            System.out.println("Gâu gâu!");
        }
    }
    public class Main {
        public static void main(String[] args) {
            Dog dog = new Dog();
            dog.name = "Milu"; // Dùng tài sản của cha
            dog.eat();         // Dùng hành động của cha
            dog.bark();        // Hành động riêng của con
        }
    }
    ```
- **Các từ khóa quan trọng:**
  - `super`: Đại diện cho lớp cha, dùng để gọi hàm của cha khi lỡ bị con ghi đè.
  - `@Override`: Khi lớp con ko thích cách triển khai của lớp cha, muốn làm khác đi.
      ```java
      class Bird extends Animal{
          @Override
          public void move(){
              System.out.println("Đang bay...");
          }
      }
      ```
- **Lưu ý:** Trong Java không cho phép đa kế thừa class.
  - Vì dễ dẫn đến "tẩu hỏa nhập ma", do trường hợp 2 class cha đều có chung 1 method thì khi thằng con dùng không biết đang dùng của thằng nào.
  - Tuy ko thể đa kế thừa class, nhưng Java lại cho phép đa kế thừa interface.
- **Góc nhìn kinh nghiệm, Composition over Inheritance:**
  - Tức là ưu tiên ghép nối hơn là kế thừa.
  - Kế thừa tuy mạnh nhưng lại dẫn đến Tight Coupling, nếu sửa code ở cha, tất cả các thằng con sẽ bị ảnh hưởng.
  - **Vì thế** hạn chế extends nếu không thực sự cần thiết. Thay vào đó, hãy dùng Composition (Thành phần). Ví dụ:
    ```java
    // Composition: Window CÓ MỘT (Has-A) Rectangle 
    class Window { 
        private Rectangle rect = new Rectangle(); 
        public void draw() {
            rect.draw(); // Mượn Rectangle để vẽ 
        } 
    }
    ```
</details>

#### 3. Đa hình (Polymorphism)
<details>
<summary>🎭 <em>Phân biệt Overload & Override (Kèm ví dụ)</em></summary>

- Phân biệt Override (ghi đè) và Overload (nạp chồng).
- **Đa hình tĩnh (Static) - Method Overloading:**
  - Cùng tên hàm, nhưng khác tham số.
  - Tại sao lại cần? để người dùng đỡ phải nhớ nhiều tên hàm.
    ```java
    class Calculator {
        // Cộng 2 số nguyên
        int add(int a, int b){
            return a+b;
        }
        // Cộng 3 số nguyên
        int add(int a, int b, int c){
            return a+b+c;
        }
    }
    ```
- **Đa hình động (Dynamic) - Method Overriding - Trùm cuối:**
  - Kỹ thuật Upcasting (Ép kiểu lên) khai báo kiểu Cha, nhưng khởi tạo đối tượng kiểu Con.
    ```java
    // Cha
    class Animal {
        void speak() { System.out.println("..."); }
    }
    
    // Con1
    class Dog extends Animal {
        @Override
        void speak() { System.out.println("Go Go"); }
    }
    
    // Con2
    class Cat extends Animal {
        @Override
        void speak() { System.out.println("Meow meow"); }
    }
    
    public class Main {
        public static void main(String[] args){
            Animal a;
            
            a = new Dog();
            a.speak(); 
            
            a = new Cat();
            a.speak();
        }
    }
    ```
</details>

#### 4. Trừu tượng (Abstraction) & Interface
<details>
<summary>🧩 <em>Phân biệt Abstract Class vs Interface (Rất quan trọng)</em></summary>

- **Abstract Class:** Là một bản thiết kế dở dang, n chứa các hàm trừu tượng (abstract method), chỉ có tên hàm mà ko có ruột.
  - **Quy tắc khi dùng Abstract Class:**
    - Class con kế thừa bắt buộc phải viết code cho các hàm trừu tượng đó (trừ khi con cũng là abstract).
    - Dùng abstract class khi muốn các class con chia sẻ code chung nhưng bắt chúng phải tự định nghĩa một vài hành động riêng.
      ```java
      //Abstract Class: NhanVien
      abstract class Employee {
          String name;
          // Hàm thương: ai cũng cần -> Viết sẵn
          void checkin(){
              System.out.println("Quẹt thẻ chấm công");
          }
          // Hàm trừu tượng
          abstract double calculateSalary();
      }
      class Dev extends Employee{
          @Override
          double calculateSalary(){
              return 2000 * 1.5; 
          }
      }
      ```

- **Interface (Cực kỳ quan trọng):** Như một Bản Hợp Đồng (Contract) hoặc Khả Năng (Capability).
  - Không phải là 1 class, mà là một tập hợp các quy định.
  - Tất cả các hàm bên trong đều mặc định là public abstract.
  - Một Class có thể implements nhiều Interface cùng lúc.
  - Dùng Interface khi muốn quy định hành vi cho các Class không liên quan j đến nhau.
    ```java
    interface Flyable { 
        void fly(); // Hợp đồng: Ai ký cái này thì phải biết bay 
    } 
    class Bird extends Animal implements Flyable { 
        public void fly() { 
            System.out.println("Vỗ cánh bay"); 
        } 
    } 
    class Airplane implements Flyable { 
        public void fly() { 
            System.out.println("Dùng động cơ phản lực"); 
        } 
    }
    ```
- *Ứng dụng:* Trong Spring, Service và Repository giao tiếp qua Interface để đảm bảo Loose Coupling (Lỏng lẻo sự phụ thuộc).
</details>

---

### 🧱 Dependency Injection & Testability
<details>
<summary>🔌 <em>Tại sao cần Interface & DI? (Đọc kỹ cho đồ án)</em></summary>

- Trong các dự án thực tế (và đồ án của em sắp tới), em sẽ thấy cấu trúc này suốt ngày:
  1. `UserService` (Interface): Định nghĩa xem service này làm được gì (thêm, sửa, xóa user).
  2. `UserServiceImpl` (Class): Code chi tiết thực hiện các việc đó.
- **Tại sao phải tách ra làm 2 file cho mệt?** - **Dependency Injection (DI)** và **Testability**. Khi em viết Controller, em chỉ gọi Interface:
  ```java
  @RestController
  public class UserController {
      @Autowired
      // Gọi Interface, không gọi Impl cụ thể
      private UserService userService; 
      // ...
  }
  ```
  - **Linh hoạt:** Hôm nay `userService` chạy code kết nối SQL. Ngày mai sếp bảo chuyển sang MongoDB, em chỉ cần viết một class `UserServiceMongoImpl` mới implement cái Interface cũ. Code ở Controller **không cần sửa một dòng nào**.
  - **Test:** Khi viết Unit Test, em có thể tạo một `FakeUserService` giả lập để test Controller mà không cần kết nối Database thật.
- **Lời khuyên cho đồ án tốt nghiệp:**
  - **Với Entity (Dữ liệu):** Dùng Class bình thường (hoặc Abstract Class nếu có phân cấp cha con rõ ràng).
  - **Với Service/Logic:** **Luôn bắt đầu bằng Interface**. Viết Interface trước để định hình xem chức năng đó cần input/output là gì, sau đó mới viết class `Impl` để code chi tiết. Đây gọi là **"Interface-driven development"**.
</details>

- [x] **Constructor:** Default constructor vs Parameterized constructor.
    <details>
    <summary>🛠️ <em>Các loại Constructor & Bẫy thường gặp</em></summary>

  - **Default constructor có 2 loại:**
    - **Implict (Tàng hình)**: Nếu trong class không viết cứ constructor nào thì trình biên dịch sẽ tự động tạo 1 construcstor rỗng.
        ```java
        class Student {
            String name;
            int age;
            // Không viết constructor nào cả
        }
        public class Main {
            public static void main(String[] args) {
                Student s = new Student(); // Vẫn chạy nhờ constructor ngầm
                System.out.println(s.name); // In ra null
                System.out.println(s.age);  // In ra 0
            }
        }
        ```
    - **Explict No-Args (Tường minh)**: Tương tự cái trên chỉ khác là do mình tự tay viết.
        ```java
        class Student {
            String name;
            // Tự viết Default Constructor
            public Student() {
                this.name = "Vô danh"; // Gán giá trị mặc định xịn hơn null
            }
        }
        ```
  - **Parameterized constructor - Hàm khởi tạo có tham số:**
    - Giúp code gọn hơn, người dùng có thể cung cấp dữ liệu ngay khi tạo đối tượng.
        ```java
        class Student {
            String name;
            int age;
            // Parameterized Constructor
            public Student(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }
        public class Main {
            public static void main(String[] args) {
                // Tạo phát ăn ngay, đầy đủ dữ liệu
                Student s1 = new Student("Trần Thập Nhất", 22); 
            }
        }
        ```
  - **Bẫy "The Missing Default Constructor Trap":**
    - Compiler chỉ tạo default constructor khi trong class chưa có bất cứ constructor nào, do đó cần phải chú ý khi viết **constructor** đối với ng mới.
    </details>

- [x] **Static & Final:** Khi nào dùng biến tĩnh (`static`), hằng số (`final`).
    <details>
    <summary>🔒 <em>Giải thích chi tiết Static & Final</em></summary>

  - **`static` = "Của chung" (Thuộc về tập thể/Class):**
    - **a. Biến tĩnh (Static Variable):** Khi muốn chia sẻ dữ liệu. Ví dụ: Bạn muốn đếm xem có bao nhiêu sinh viên đã được tạo ra.
        ```java
        class Student {
            String name; // Biến instance (Mỗi người 1 cái tên)
            static int count = 0; // Biến static (Cả lớp dùng chung 1 bộ đếm)
            
            public Student(String name) {
                this.name = name;
                count++; // Mỗi lần tạo mới, tăng bộ đếm chung lên
            }
        }
        // Main
        Student s1 = new Student("An");
        Student s2 = new Student("Bình");
        System.out.println(Student.count); 
        // Kết quả: 2 (Dù gọi từ s1 hay s2 hay Student đều ra 2)
        ```
      - Ví dụ đời thường: `name` là cái đồng hồ đeo tay (mỗi người 1 cái). `count` là cái đồng hồ treo tường của lớp học (cả lớp nhìn chung vào 1 cái).
    - **b. Phương thức tĩnh (Static Method)**: Khi viết **hàm tiện ích (Utility)**. Khi hàm của bạn không cần dùng đến dữ liệu riêng của đối tượng (không cần `this.name`, `this.age`), hãy biến nó thành `static` để gọi cho nhanh mà không cần `new`.
      - Ví dụ: `Math.sqrt()`, `Math.random()`. Bạn gọi trực tiếp `Math.sqrt(9)` chứ không ai rảnh đi `new Math().sqrt(9)` cả.
      - *Lưu ý:* Hàm `main` bắt buộc phải là `static` để Java có thể chạy nó đầu tiên mà không cần tạo đối tượng.
  - **`final` = "Chốt đơn" (Không được sửa đổi):**
    - Từ khóa này dùng để ngăn chặn sự thay đổi. Nó có thể dùng cho 3 chỗ: **Biến**, **Phương thức**, và **Lớp**.
    - Khi nào dùng `final`?
      - **a. Biến `final`: Tạo hằng số (Constant).** Gán giá trị 1 lần duy nhất, sau đó cấm sửa. `final double PI = 3.14;`
      - **b. Phương thức `final`: Cấm ghi đè (Prevent Overriding).** Khi bạn viết Class Cha và không muốn Class Con sửa lại logic của hàm đó.
          ```java
          class Cha {
              final void checkPassword() {
                  // Logic bảo mật cực quan trọng
              }
          }
          class Con extends Cha {
              // void checkPassword() { ... } 
              // LỖI: Không được phép sửa quy trình bảo mật của Cha
          }
          ```
      - **c. Lớp `final`: Cấm kế thừa (Prevent Inheritance).** Khi bạn muốn Class của mình là "vô sinh", không ai được phép `extends` nó. Ví dụ nổi tiếng: Class `String` của Java là `final`.
  - **Cặp bài trùng: `static final` (Hằng số toàn cục):**
    - Đây là combo bạn sẽ gặp nhiều nhất trong các dự án thực tế.
      - `static`: Để chỉ có 1 bản copy duy nhất trong bộ nhớ (tiết kiệm RAM).
      - `final`: Để không ai sửa được giá trị.
      - $\rightarrow$ Dùng để định nghĩa các **cấu hình hệ thống**.
      - **Quy tắc đặt tên (Convention):** Viết hoa toàn bộ và phân cách bằng dấu gạch dưới (`_`).
        ```java
        public class Config {
            public static final String DATABASE_URL =  "jdbc:mysql://localhost:3306/db";
            public static final int MAX_LOGIN_ATTEMPTS = 5;
        }
        ```
  - **Bẫy `final` với Object:**
    - "Biến `final` trỏ tới một List thì có thêm phần tử vào List đó được không?" - **Có**.
    - **Giải thích:** `final` với Object chỉ khóa cái **"dây buộc"** (Reference). Nó bắt cái dây đó phải buộc chặt vào đối tượng `ArrayList` ban đầu. Nhưng bản thân cái `ArrayList` đó (nội tại bên trong) vẫn có thể thay đổi (Mutable). Muốn khóa cả ruột? Phải dùng `Collections.unmodifiableList(names)`.
    </details>

---

## 3. Java Collections Framework
> 💡 **Tầm quan trọng:** Làm Backend thực chất là xử lý danh sách dữ liệu. Bạn không thể sống thiếu phần này.

- [x] **List (ArrayList, LinkedList):** Các thao tác thêm, sửa, xóa, duyệt danh sách.
    <details>
    <summary>🔻 <em>Phân biệt ArrayList vs LinkedList</em></summary>

  - **`ArrayList` (Mảng động)** - **Dùng 98% trường hợp**
    - Bên trong nó là 1 mảng bình thường.
    - Cơ chế động của nó là khi mảng đầy, nó sẽ tự tạo 1 mảng to hơn thường là gấp 1.5 lần, coppy toàn bộ dữ liệu cũ sang r vất mảng cũ đi.
    - **Ưu điểm:** Truy cập cực nhanh, vì nó có tính toán đc địa chỉ ô nhớ.
    - **Nhược điểm:** Thêm/xóa ở giữa danh sách rất chậm. Vì nó phải dịch chuyển toàn bộ các phần tử phía sau lên hoặc xuống.
  - **`LinkedList` (Danh sách liên kết)** - **Dùng 2% còn lại**
    - **Cấu tạo:** Các phần tử (Node) nằm rải rác trong bộ nhớ. Mỗi Node cầm tay Node bên cạnh (Next/Prev).
    - **Ưu điểm:** Thêm/Xóa cực nhanh (O(1)). Chỉ cần cắt đứt liên kết cũ và nối dây mới là xong, không cần dịch chuyển ai cả.
    - **Nhược điểm:** Truy xuất cực chậm (O(n)). Muốn tìm thằng thứ 99, em phải đi từ thằng số 1, hỏi "thằng sau mày là ai", cứ thế bò dần tới thằng 99.
    </details>

- [x] **Set (HashSet):** Xử lý tập hợp không chứa phần tử trùng lặp. - **Thực ra là Map trá hình**.
    <details>
    <summary>🔻 <em>Sự thật về HashSet</em></summary>

  - **HashSet:** Em có tin không? Bên trong ruột của `HashSet` chính là một cái `HashMap`!
    - Khi em gọi `set.add("A")`, thực chất nó gọi `map.put("A", PRESENT)`. Nó dùng Key để đảm bảo tính duy nhất, còn Value là một object rỗng vô nghĩa.
  - **TreeSet:** Bên trong là `TreeMap` (dùng cây đỏ đen). Nó giúp dữ liệu luôn được sắp xếp tăng dần, nhưng tốc độ chậm hơn `HashSet`.
    </details>

- [x] **Map (HashMap, TreeMap):**
    <details>
    <summary>🔻 <em>HashMap hoạt động như thế nào? (Senior Interview)</em></summary>

  - `Map` không thuộc dòng họ `Collection` (nó không extend Collection interface), nhưng nó là cấu trúc quan trọng nhất. Lưu trữ dạng **Key-Value.**
  - **Cơ chế hoạt động của `HashMap` (Câu hỏi phỏng vấn Senior):** Em đã bao giờ thắc mắc làm sao `HashMap` tìm kiếm nhanh đến vậy (O(1)) chưa?
    1. **Hashing:** Khi em `put("Key", "Value")`, Java sẽ gọi hàm `hashCode()` của cái Key để ra một con số (Ví dụ: 12345).
    2. **Buckets (Cái xô):** `HashMap` bên trong là một mảng các cái "xô". Nó dùng số hash kia để chia lấy dư (modulo), quyết định xem quăng cặp dữ liệu này vào cái xô số mấy.
    3. **Collision (Va chạm):** Nếu 2 key khác nhau nhưng lại tính ra cùng một chỉ số xô?
      - **Trước Java 8:** Nó dùng LinkedList để nối đuôi nhau trong cái xô đó.
      - **Từ Java 8:** Khi cái xô quá đông (mặc định > 8 phần tử), nó chuyển LinkedList thành **Red-Black Tree** (Cây đỏ đen) để tìm kiếm nhanh hơn (từ O(n) xuống O(log n)).
  - **💡 Lưu ý sống còn:** Khi dùng Object tự tạo làm Key cho Map (ví dụ dùng `Student` làm Key), em **BẮT BUỘC** phải ghi đè (Override) cả 2 hàm `equals()` và `hashCode()`. Nếu không, Map sẽ coi 2 ông Student dù cùng tên cùng tuổi vẫn là 2 key khác nhau $\rightarrow$ Dữ liệu bị sai lệch.
  - *Ứng dụng:* Rất quan trọng khi xử lý cấu hình (Config) hoặc dữ liệu JSON động.
    </details>

- [x] **Generics:** - Kiểu tham số hóa
    <details>
    <summary>🔻 <em>Generics là gì?</em></summary>

  - Hiểu ý nghĩa dấu ngoặc nhọn `<T>`.
  - Ví dụ: `List<String>`, `Map<String, User>`. Spring Data JPA dùng cái này dày đặc.
    </details>

---

## 4. Java Modern (Java 8+, 10, 14)
> 💡 **Tầm quan trọng:** Code Spring Boot hiện đại yêu cầu sự ngắn gọn. Không ai viết code theo kiểu Java 5 cũ kỹ nữa.

- [x] **Lambda Expressions:** Viết hàm ẩn danh ngắn gọn `() -> {}`.
    <details>
    <summary>🔻 <em>Ví dụ so sánh Code cũ vs Code mới</em></summary>

  - Trước đây, để viết một hàm xử lý ngắn gọn (ví dụ: sắp xếp), bạn phải tạo một `Anonymous Class` dài ngoằng. Giờ đây, bạn chỉ cần một mũi tên `->`.
  - **Tư duy:** Input `->` Logic xử lý.
  - **Ví dụ:** Sắp xếp danh sách sinh viên theo tên.
    ```java
    // Cách cũ (Java 7): Dài dòng, nhiều code rác
    Collections.sort(students, new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    });
    // Cách Modern (Java 8): Ngắn gọn trong 1 dòng
    Collections.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
    ```
    </details>

- [x] **Stream API:** Dây chuyền sản xuất tự động
    <details>
    <summary>🏭 <em>Stream API (Tư duy dòng chảy)</em></summary>

  - Tư duy xử lý dữ liệu dạng dòng chảy.
  - Đây là phần **quan trọng nhất** bạn cần học. Hãy tưởng tượng `List` của bạn là nguyên liệu thô. `Stream` là một cái **băng chuyền nhà máy**. Dữ liệu chạy qua băng chuyền, đi qua các robot xử lý (Filter, Map), và cuối cùng đóng gói thành phẩm (Collect).
  - **Bài toán:** Cho một list số nguyên. Hãy tìm các số chẵn, bình phương chúng lên, và lấy ra list kết quả.
    - **Cách cũ (Dùng vòng lặp `for`):**
        ```java
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) { // Lọc số chẵn
                int sq = n * n; // Bình phương
                result.add(sq); // Thêm vào list mới
            }
        }
        ```
    - **Cách Modern (Stream API):**
        ```java
        List<Integer> result = numbers.stream()        
            // 1. Đưa lên băng chuyền
            .filter(n -> n % 2 == 0)                   
            // 2. Robot lọc: Chỉ giữ số chẵn
            .map(n -> n * n)                           
            // 3. Robot biến hình: Bình phương lên
            .collect(Collectors.toList());             
            // 4. Đóng gói: Về lại thành List
        ```
  - Các hàm phổ biến: `filter`, `map`, `sorted` (thay thế cho vòng lặp for truyền thống).
    1. **`filter(predicate)`**: Lọc dữ liệu (Giữ lại cái thỏa mãn điều kiện).
    2. **`map(function)`**: Biến đổi dữ liệu (Input là A, Output là B. Ví dụ: Từ `Student` biến thành `String` tên).
    3. **`sorted()`**: Sắp xếp.
    4. **`collect()`**: Kết thúc dòng chảy, gom dữ liệu về List/Set/Map.
    </details>

- [x] **Optional:** Cách xử lý lỗi `NullPointerException` thanh lịch, tránh crash ứng dụng.
    <details>
    <summary>📦 <em>Chiếc hộp Schrodinger (Trị bệnh Null)</em></summary>

  - Được ví như **"Chiếc hộp Schrodinger" (Trị bệnh Null):** `NullPointerException` (NPE) là lỗi ám ảnh nhất của Java dev. `Optional<T>` sinh ra để bao bọc một giá trị có thể bị null. Nó giống như một cái **hộp**. Hộp có thể có bánh, hoặc rỗng.
  - Thay vì kiểm tra `if (obj != null)`, bạn dùng các hàm sành điệu hơn.
      ```java
      // Cách cũ
      User user = repository.findUserById(1);
      if (user != null) {
          System.out.println(user.getName());
      } else {
          System.out.println("Không tìm thấy");
      }
      
      // Cách Modern (Optional)
      // findUserById giờ trả về Optional<User>
      repository.findUserById(1)
          .ifPresent(u -> System.out.println(u.getName()));
      
      // Hoặc cung cấp giá trị mặc định nếu null
      User user = repository.findUserById(1)
                            .orElse(new User("Default Name")); 
      ```
    </details>

- [x] `var` - **Local Variable Type Inference** - Java10
    <details>
    <summary>🔻 <em>Giải thích về var</em></summary>

  - Java tự đoán kiểu dữ liệu cho bạn. Code nhìn sạch hơn hẳn. _Lưu ý: **Chỉ dùng cho biến cục bộ (trong hàm)**.
      ```java
      // Thay vì viết
      HashMap<String, List<Student>> map = new HashMap<>();
      
      // Viết thế này (Java tự hiểu map là kiểu gì)
      var map = new HashMap<String, List<Student>>(); 
      var name = "An"; // Tự hiểu là String
      ```
    </details>

- [x] `record` - **Java14 - Hủy diệt Lombok/Getter/Setter**
    <details>
    <summary>🔻 <em>Giải thích về record</em></summary>

  - Khi bạn tạo các class DTO (Data Transfer Object) chỉ để chứa dữ liệu, bạn phải viết một đống field, constructor, getter, setter, toString... `record` giúp bạn làm điều đó trong **1 dòng code**.
      ```java
      // Cách cũ (Class thường)
      class Point {
          private final int x;
          private final int y;
          // Phải viết Constructor, Getter, hashCode, equals... mỏi tay
      }
      
      // Cách Modern (Record)
      // Tự động sinh Constructor, Getter (x(), y()), toString, equals...
      public record Point(int x, int y) {} 
      ```
    </details>

---

## 5. Xử lý lỗi (Exception Handling)
- [x] **Try - Catch - Finally:** Cấu trúc bắt lỗi cơ bản.
    <details>
    <summary>🔻 <em>Chi tiết cấu trúc Try-Catch-Finally</em></summary>

  - Hình dung Exception như việc đi xe máy:
    - **Bình thường:** Xe chạy bon bon (`try`).
    - **Lỗi (Exception):** Xe thủng lốp.
    - **Xử lý (`catch`):** Dắt vào tiệm vá xe thay vì vứt luôn cái xe ngoài đường.
    - **Dọn dẹp (`finally`):** Rửa tay sạch sẽ sau khi sửa xe xong.
  - **Cấu trúc `try - catch - finally`:** Đây là khung sườn cơ bản nhất để bắt lỗi.
      ```java
      public void readFile() {
          FileReader reader = null;
          try {
              // 1. Khu vực rủi ro: Code có thể gây lỗi
              reader = new FileReader("file_khong_ton_tai.txt");
              System.out.println("Đọc file thành công"); 
              // Dòng này sẽ bị bỏ qua nếu lỗi
          } catch (FileNotFoundException e) {
              // 2. Khu vực cứu thương: Chạy khi có lỗi xảy ra
              System.err.println("Lỗi rồi: Không tìm thấy file! " 
              + e.getMessage());
          } finally {
              // 3. Khu vực dọn dẹp: LUÔN LUÔN CHẠY (dù có lỗi hay không)
              // Thường dùng để đóng kết nối Database, đóng File
              System.out.println("Đóng kết nối tại đây.");
              if (reader != null) {
                  try { reader.close(); } catch (IOException e) {}
              }
          }
      }
      ```
    </details>

- [x] **Throw vs Throws:** Phân biệt ném lỗi chủ động và khai báo lỗi.
    <details>
    <summary>🔻 <em>Phân biệt Throw vs Throws</em></summary>

  - Đây là cặp từ khóa dễ nhầm lẫn nhất về mặt chính tả, nhưng ý nghĩa khác hẳn nhau.
    - **throw**: Dùng trong thân hàm, chủ động tạo ra 1 lỗi và ném nó ra, chỉ 1 lỗi tại 1 thời điểm. VD: `throw new Exception("Lỗi")`
    - **throws**: Dùng sau tên hàm, cảnh báo cho người gọi hàm biết rằng hàm này rủi ro, có thể khai báo nhiều loại lỗi. VD: `void method() throws Exception {...}`
  - **Ví dụ kết hợp:**
      ```java
      // 1. throws: Cảnh báo "Hàm này nguy hiểm nha, cẩn thận"
      public void checkAge(int age) throws Exception {
          if (age < 18) {
              // 2. throw: Thực hiện hành động ném lỗi
              throw new Exception("Chưa đủ 18 tuổi, đi về!"); 
          }
          System.out.println("Mời vào bar.");
      }
      ```
    </details>

- [x] **Custom Exception:** Tự tạo Exception riêng (ví dụ: `UserNotFoundException`).
    <details>
    <summary>🔻 <em>Custom Exception & Checked vs Unchecked</em></summary>

  - **1. Custom Exception (Tự chế lỗi riêng):**
    - Tại sao phải tự tạo Exception? - Vì các lỗi có sẵn của Java như `RuntimeException`, `IOException` quá chung chung.
    - Khi làm dự án (ví dụ Spring Boot), bạn muốn báo lỗi cụ thể như: _"User không tồn tại"_, _"Hết hàng trong kho"_, _"Sai mật khẩu"_... để Frontend dễ xử lý hiển thị.
    - **Cách tạo: Kế thừa từ `RuntimeException` (Khuyên dùng):**
        ```java
        // 1. Tạo class lỗi riêng
        // Extend RuntimeException để code gọn hơn (Unchecked Exception)
        public class UserNotFoundException extends RuntimeException {
            public UserNotFoundException(String message) {
                super(message); // Gọi constructor của cha để gán thông báo
            }
        }
        
        // 2. Sử dụng trong Service
        public User findUser(String username) {
            User user = userRepo.findByUsername(username);
            if (user == null) {
                // Ném lỗi "xịn" do mình tự chế
                throw new UserNotFoundException("Không tìm thấy user có tên: " 
                + username);
            }
            return user;
        }
        ```
  - **2. Kiến thức nền tảng: Checked vs Unchecked Exception:**
    - **Checked Exception (Bắt buộc bắt):**
      - Là các class kế thừa trực tiếp từ `Exception` (trừ Runtime).
      - Ví dụ: `IOException`, `SQLException`.
      - **Đặc điểm:** Trình biên dịch **ép buộc** bạn phải `try-catch` hoặc `throws`. Nếu không code sẽ báo đỏ lòm. Thường dùng cho lỗi khách quan (mất mạng, lỗi file).
    - **Unchecked Exception (Không bắt buộc):**
      - Là các class kế thừa từ `RuntimeException`.
      - Ví dụ: `NullPointerException`, `ArithmeticException` (chia cho 0), `UserNotFoundException` (của bạn).
      - **Đặc điểm:** Trình biên dịch **không ép** bắt lỗi. Code vẫn chạy, lỗi thì crash. Thường dùng cho lỗi logic code hoặc lỗi nghiệp vụ.
    - **Tại sao xu hướng hiện đại (Spring Boot) thích Unchecked?** - Vì nó giúp code sạch sẽ (`Clean Code`). Bạn không muốn cứ gọi 1 hàm là phải bọc `try-catch` rối rắm. Thay vào đó, bạn ném lỗi thoải mái, và dùng một nơi duy nhất để xử lý toàn bộ lỗi (Global Exception Handler).
    </details>

---

## 6. Các khái niệm bổ trợ (Spring Essentials)
- [x] **Annotation:**
    <details>
    <summary>🏷️ <em>Annotation là gì & Các loại phổ biến</em></summary>

  - [x] Hiểu các ký hiệu bắt đầu bằng `@` (ví dụ `@Override`).
    - **Bản chất:** Annotation là **Metadata** (Dữ liệu mô tả dữ liệu). Hãy tưởng tượng Class của bạn là một thùng hàng.
      - **Code bình thường**: Là hàng hóa bên trong.
      - **Annotation**: Là **tờ giấy Note** dán bên ngoài thùng hàng: _"Hàng dễ vỡ"_, _"Giao hỏa tốc"_, _"Hàng đông lạnh"_.
  - [x] ***Chuẩn bị:*** Spring Boot là thiên đường của Annotation
    - **Spring Boot hoạt động dựa trên cơ chế Reflection**. Khi ứng dụng khởi động, Spring sẽ đi "soi đèn" vào tất cả các Class.
      - Nếu nó thấy class nào dán nhãn `@Controller`: Nó hiểu _"À, ông này chuyên tiếp khách (nhận Request)"_.
      - Nếu nó thấy nhãn `@Service`: Nó hiểu _"Ông này chuyên xử lý logic nghiệp vụ"_.
      - Nếu nó thấy nhãn `@Autowired`: Nó hiểu _"Chỗ này cần tiêm thuốc (Dependency Injection), để mình đi tìm đối tượng phù hợp nhét vào"_.
    - $\rightarrow$ **Thay đổi tư duy:** Thay vì viết code dài dòng để cấu hình (như ngày xưa phải viết XML), giờ bạn chỉ cần **dán nhãn**, Spring sẽ tự hiểu và làm phần còn lại.
  - [x] **Các Annotation sẽ gặp 100%:**
    1. `@Component`: Đánh dấu "Đây là một Bean, Spring hãy quản lý nó".
    2. `@Service`, `@Repository`, `@Controller`: Con của `@Component`, nhưng dán nhãn cụ thể chức năng hơn.
    3. `@SpringBootApplication`: Cái nhãn to nhất, đánh dấu điểm bắt đầu của dự án.
    </details>

- [x] **Maven/Gradle:** Hiểu file `pom.xml` dùng để quản lý thư viện (Dependency Management).
    <details>
    <summary>📦 <em>Maven & Gradle (Quản gia thông minh)</em></summary>

  - **Maven & `pom.xml`: Quản gia thông minh**
    - Ngày xưa, khi muốn dùng thư viện bên ngoài (ví dụ thư viện kết nối Database MySQL driver, hay thư viện Lombok):
      1. Bạn lên Google tìm.
      2. Tải file `.jar` về máy.
      3. Copy vào thư mục dự án.
      4. Add to Path thủ công.
      - $\rightarrow$ **Cơn ác mộng:** Khi thư viện A cần thư viện B, thư viện B lại cần thư viện C... Bạn sẽ chết chìm trong đống file `.jar` (gọi là **Jar Hell**).
      - **Maven sinh ra để giải quyết việc này.** Nó là một công cụ **Quản lý sự phụ thuộc (Dependency Management)** và **Build Tool**.
    - **"Trái tim" của Maven: File `pom.xml`**
      - (POM = Project Object Model). Đây là tờ danh sách đi chợ của bạn.
      - Cấu trúc quan trọng nhất trong `pom.xml` là **G.A.V** (Tọa độ của một thư viện):
        - **G - GroupId:** Tên tổ chức/công ty (VD: `org.springframework.boot`).
        - **A - ArtifactId:** Tên dự án/thư viện (VD: `spring-boot-starter-web`).
        - **V - Version:** Phiên bản (VD: `3.2.0`).
      - **Cách hoạt động:** Bạn chỉ cần khai báo trong `pom.xml`:
          ```xml
          <dependency>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
              <version>1.18.30</version>
          </dependency>
          ```
        Maven sẽ tự động:
        1. Kết nối Internet tới kho chứa khổng lồ (Maven Central Repository).
        2. Tải file `.jar` của Lombok về.
        3. Tự động tải luôn các thư viện con mà Lombok cần (nếu có).
        4. Cấu hình vào dự án cho bạn.
  - **Maven Lifecycle (Vòng đời Build):**
    - Ngoài tải thư viện, Maven còn giúp bạn đóng gói phần mềm chỉ bằng 1 cú click chuột (hoặc 1 dòng lệnh):
    - `mvn clean`: Dọn dẹp rác của lần build trước.
    - `mvn test`: Tự động chạy các file Test Case.
    - `mvn package`: Đóng gói code thành file `.jar` hoặc `.war` để đem đi deploy (triển khai) lên server.
  - **Gradle là gì?**
    - Gradle cũng giống Maven (cùng mục đích), nhưng sinh sau đẻ muộn nên hiện đại hơn.
    - **Maven:** Dùng XML (hơi dài dòng, rườm rà).
    - **Gradle:** Dùng ngôn ngữ Groovy hoặc Kotlin (ngắn gọn, build nhanh hơn).
  - **Thực tế:** Các dự án cũ hoặc doanh nghiệp lớn (Ngân hàng, Nhật Bản) vẫn chuộng **Maven** vì sự ổn định. Các startup hoặc dự án Android thì chuộng **Gradle**.
  - _Lời khuyên:_ Học **Maven** trước vì nó tường minh, dễ hiểu cấu trúc. Sau này chuyển sang Gradle rất dễ.
    </details>