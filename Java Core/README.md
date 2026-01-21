# 🚀 Java Core Checklist: Hành Trang Vào Spring Boot

Tài liệu này tổng hợp các kiến thức nền tảng Java bắt buộc phải nắm vững trước khi đi sâu vào Spring Boot. Mục tiêu là lấp lỗ hổng kiến thức và chuẩn bị tư duy tốt nhất cho Backend Development.

---

## 1. Cú pháp & Tư duy cơ bản (Level: PRO192)
<details> 
    <summary><em>Cú pháp cơ bản & kiến thức nền tảng</em></summary>

> 💡 **Tầm quan trọng:** Đây là nền móng. Nếu quên phần này, bạn sẽ không thể viết logic code cơ bản.

- [x] **Biến & Kiểu dữ liệu**
    <details>
    <summary>🔻 <em>Phân biệt int vs Integer & Collection Framework</em></summary>

    - **Phân biệt rõ `int` (primitive) và `Integer` (wrapper class):**
        - `int` (primitive): Là một trong những kiểu dữ liệu nguyên thủy lưu giá trị thực tế, **không** dùng được trong Collection.
        - `Integer` (wrapper class): Là một đối tượng trỏ tới vùng nhớ chứa giá trị. Vì là một đối tượng nên nó có nhiều hàm hỗ trợ, và **dùng được** trong Collection.
    - **Collection Framework:** Trong Java, Collection nằm trong gói `java.util`, cung cấp các Interface và Class để lưu trữ nhóm đối tượng. Chia làm 3 nhóm chính (List, Set, Queue) và 1 nhóm đặc biệt (`Map`).
    - *Lý do:* Trong Database Mapping và Generic của Spring, bắt buộc phải dùng Wrapper Class.
    </details>

- [x] **String vs StringBuilder**
    <details>
    <summary>🔻 <em>Cơ chế Immutable & Tối ưu hiệu năng</em></summary>

    - **Hiểu cơ chế Immutable của String:**
        - **"Immutable"** nghĩa là **"Không thể thay đổi"**. Trong Java, một khi đối tượng `String` đã được tạo ra trong bộ nhớ (Heap), nội dung của nó **vĩnh viễn không bao giờ thay đổi**.
        - *Ví dụ:*
            ```java
            String s = "Hello";
            s = s + " World";
            // Có vẻ biến s đã thay đổi từ "Hello" sang "Hello World".
            // Thực ra: JAVA ko sửa chữ "Hello" mà nó tạo một chuỗi mới "Hello World" và chuyển con trỏ của biến s sang "Hello World".
            ```
    - **Lưu ý:** Tránh dùng cộng chuỗi (`+`) trong vòng lặp, hãy dùng `StringBuilder` để tối ưu hiệu năng.
    - **StringBuilder (Mutable):** Nó như cái bảng trắng, khi bạn muốn thêm chữ thì chỉ cần viết tiếp vào, không cần thay bảng mới. Bên trong `StringBuilder` là 1 mảng kí tự `char[]`. Khi `append()`, nó sẽ điền tiếp vào mảng. Khi mảng đầy, nó tự động tạo ra mảng mới to gấp đôi, copy dữ liệu sang rồi dùng tiếp.
    </details>

- [x] **Control Flow (Luồng điều khiển)**
    <details>
    <summary>🔻 <em>Chi tiết</em></summary>

    - Thành thạo `if-else`, `switch-case`.
    - Các loại vòng lặp: `for`, `for-each`, `while`.
    </details>

- [x] **Mảng (Array):** Cách khai báo, khởi tạo và truy xuất phần tử cơ bản.
</details>

---

## 2. Lập trình hướng đối tượng - OOP (🔥 QUAN TRỌNG NHẤT)
<details> 
    <summary><em>Kiến thức cần nhớ về OOP</em></summary>

> 💡 **Tầm quan trọng:** Spring Boot vận hành hoàn toàn dựa trên các nguyên lý này (DI/IoC). Nếu hổng chỗ này, bạn sẽ chỉ biết copy code mà không hiểu bản chất.

- [x] **Class & Object:** Tư duy về Lớp và Đối tượng (Instance).
    <details>
    <summary>🔻 <em>Định nghĩa Class & Object</em></summary>

    - **Class:** Là bản vẽ thiết kế, là 1 khái niệm trừu tượng, nằm trên giấy tờ.
    - **Object:** Là vật cụ thể đc tạo từ bản vẽ (Class).
    </details>

### 🌟 4 Tính chất OOP

#### 1. Đóng gói (Encapsulation)
<details>
<summary>🛡️ <em>Xem chi tiết về Access Modifiers & Getter/Setter</em></summary>

- **Định nghĩa:** Đóng gói chính là việc che giấu dữ liệu bên trong, chỉ lộ ra những cái cần thiết (method) ra bên ngoài.
- **4 cấp độ bảo mật (Access Modifiers):**
    - `Private`: Chỉ nội bộ class mới thấy.
        - *Kinh nghiệm:* Mặc định luôn để private cho tất cả các thuộc tính, chỉ mở rộng khi thực sự cần thiết.
    - `Protected`: Cùng package, lớp con mới thấy.
        - *Kinh nghiệm:* Dùng khi thiết kế thư viện hoặc Framework để cho phép class con override.
    - `Public`: Toàn bộ dự án có thể dùng.
        - *Kinh nghiệm:* Chỉ dùng cho các hàm API, các hằng số, hoặc class chính.
- **Getter/Setter:** Dùng để kiểm soát dữ liệu (Read-only hoặc Write-only), và đặc biệt tương thích với Framework.
    - *Kinh nghiệm:* Thay vì ngồi gõ một đống Getter/Setter cho 10 class entity thì có thể dùng **Lombok**.
</details>

#### 2. Kế thừa (Inheritance)
<details>
<summary>🧬 <em>Xem chi tiết (Extends, Super, Composition over Inheritance)</em></summary>

- **Bản chất:** Kế thừa hay chính là quan hệ **Is-A**, ví dụ `Dog` **is an** `Animal` → Hợp lý.
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
        class Bird extends Animal {
            @Override
            public void move(){
                System.out.println("Đang bay...");
            }
        }
        ```
- **Lưu ý về Đa kế thừa:** Trong Java không cho phép đa kế thừa Class (vì dễ dẫn đến xung đột method). Nhưng Java cho phép đa kế thừa Interface.
- **Góc nhìn kinh nghiệm: Composition over Inheritance**
    - Tức là ưu tiên **ghép nối** hơn là kế thừa.
    - Kế thừa tuy mạnh nhưng lại dẫn đến *Tight Coupling*, nếu sửa code ở cha, tất cả các thằng con sẽ bị ảnh hưởng.
    - *Vì thế:* Hạn chế `extends` nếu không thực sự cần thiết. Thay vào đó, hãy dùng Composition (Thành phần).
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

- **Đa hình tĩnh (Static) - Method Overloading:**
    - Cùng tên hàm, nhưng khác tham số.
    - *Tại sao cần?* Để người dùng đỡ phải nhớ nhiều tên hàm.
    ```java
    class Calculator {
        // Cộng 2 số nguyên
        int add(int a, int b){ return a+b; }
        // Cộng 3 số nguyên
        int add(int a, int b, int c){ return a+b+c; }
    }
    ```
- **Đa hình động (Dynamic) - Method Overriding (Trùm cuối):**
    - Kỹ thuật **Upcasting** (Ép kiểu lên): Khai báo kiểu Cha, nhưng khởi tạo đối tượng kiểu Con.
    ```java
    // Cha
    class Animal { void speak() { System.out.println("..."); } }
    
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
            a.speak(); // Output: Go Go
            
            a = new Cat();
            a.speak(); // Output: Meow meow
        }
    }
    ```
</details>

#### 4. Trừu tượng (Abstraction) & Interface
<details>
<summary>🧩 <em>Phân biệt Abstract Class vs Interface (Rất quan trọng)</em></summary>

- **Abstract Class:** Là một bản thiết kế dở dang, chứa các hàm trừu tượng (abstract method) - chỉ có tên hàm mà ko có ruột.
    - *Quy tắc:*
        - Class con kế thừa bắt buộc phải viết code cho các hàm trừu tượng đó.
        - Dùng abstract class khi muốn các class con chia sẻ code chung nhưng bắt chúng phải tự định nghĩa một vài hành động riêng.
    - *Ví dụ:*
        ```java
        // Abstract Class: NhanVien
        abstract class Employee {
            String name;
            // Hàm thường: ai cũng cần -> Viết sẵn
            void checkin(){
                System.out.println("Quẹt thẻ chấm công");
            }
            // Hàm trừu tượng
            abstract double calculateSalary();
        }
        class Dev extends Employee {
            @Override
            double calculateSalary(){
                return 2000 * 1.5; 
            }
        }
        ```

- **Interface (Cực kỳ quan trọng):** Như một Bản Hợp Đồng (Contract) hoặc Khả Năng (Capability).
    - Không phải là 1 class, mà là một tập hợp các quy định.
    - Tất cả các hàm bên trong đều mặc định là `public abstract`.
    - Một Class có thể `implements` nhiều Interface cùng lúc.
    - Dùng Interface khi muốn quy định hành vi cho các Class không liên quan gì đến nhau.
    - *Ví dụ:*
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

</details>

---

### 🧱 Dependency Injection & Testability
<details>
    <summary><em>DI</em></summary>

<details>
<summary>🔌 <em>Tại sao cần Interface & DI? (Đọc kỹ cho đồ án)</em></summary>

Trong các dự án thực tế (và đồ án sắp tới), cấu trúc này xuất hiện liên tục:
1. `UserService` (Interface): Định nghĩa xem service này làm được gì.
2. `UserServiceImpl` (Class): Code chi tiết thực hiện các việc đó.

- **Tại sao phải tách ra làm 2 file?** -> Vì **Dependency Injection (DI)** và **Testability**.
    - Khi viết Controller, chỉ gọi Interface:
        ```java
        @RestController
        public class UserController {
            @Autowired
            // Gọi Interface, không gọi Impl cụ thể
            private UserService userService; 
            // ...
        }
        ```
    - **Linh hoạt:** Hôm nay `userService` chạy SQL. Mai chuyển sang MongoDB, chỉ cần viết `UserServiceMongoImpl` implement Interface cũ. Controller **không cần sửa một dòng nào**.
    - **Test:** Khi viết Unit Test, có thể tạo `FakeUserService` để test Controller mà không cần DB thật.

> 🎓 **Lời khuyên cho đồ án tốt nghiệp:**
> * **Với Entity (Dữ liệu):** Dùng Class bình thường.
> * **Với Service/Logic:** **Luôn bắt đầu bằng Interface**. Viết Interface trước để định hình input/output, sau đó mới viết class `Impl`. Đây gọi là **"Interface-driven development"**.
</details>

- [ ] **Constructor:** Default constructor vs Parameterized constructor.
- [ ] **Static & Final:** Khi nào dùng biến tĩnh (`static`), hằng số (`final`).
</details>

---

## 3. Java Collections Framework
<details> 
    <summary><em>Collections</em></summary>

> 💡 **Tầm quan trọng:** Làm Backend thực chất là xử lý danh sách dữ liệu. Bạn không thể sống thiếu phần này.

- [ ] **List (ArrayList, LinkedList):** Các thao tác thêm, sửa, xóa, duyệt danh sách.
    <details>
    <summary>🔻 <em>Cơ chế ArrayList</em></summary>

    - **ArrayList (Mảng động) - Dùng 98% trường hợp:**
        - Bên trong nó là 1 mảng bình thường.
        - Cơ chế động: Khi mảng đầy, nó tự tạo 1 mảng to hơn (thường gấp 1.5 lần), copy toàn bộ dữ liệu cũ sang rồi vứt mảng cũ đi.
        - Ưu điểm: Truy cập cực nhanh vì tính toán được địa chỉ ô nhớ.
    </details>

- [ ] **Set (HashSet):** Xử lý tập hợp không chứa phần tử trùng lặp.
- [ ] **Map (HashMap, TreeMap):**
    <details>
    <summary>🔻 <em>Map dùng để làm gì?</em></summary>

    - Lưu trữ dạng Key-Value.
    - *Ứng dụng:* Rất quan trọng khi xử lý cấu hình (Config) hoặc dữ liệu JSON động.
    </details>

- [ ] **Generics:**
    <details>
    <summary>🔻 <em>Giải thích Generics</em></summary>

    - Hiểu ý nghĩa dấu ngoặc nhọn `<T>`.
    - Ví dụ: `List<String>`, `Map<String, User>`. Spring Data JPA dùng cái này dày đặc.
    </details>
</details>

---

## 4. Java Modern (Java 8+)
<details> 
    <summary><em>J Mordern là gì</em></summary>

> 💡 **Tầm quan trọng:** Code Spring Boot hiện đại yêu cầu sự ngắn gọn. Không ai viết code theo kiểu Java 5 cũ kỹ nữa.

- [ ] **Lambda Expressions:** Viết hàm ẩn danh ngắn gọn `() -> {}`.
- [ ] **Stream API:**
    <details>
    <summary>🔻 <em>Chi tiết Stream API</em></summary>

    - Tư duy xử lý dữ liệu dạng dòng chảy.
    - Các hàm phổ biến: `filter`, `map`, `sorted` (thay thế cho vòng lặp for truyền thống).
    </details>

- [ ] **Optional:** Cách xử lý lỗi `NullPointerException` một cách thanh lịch, tránh crash ứng dụng.
</details>

---

## 5. Xử lý lỗi (Exception Handling)
- [ ] **Try - Catch - Finally:** Cấu trúc bắt lỗi cơ bản.
- [ ] **Throw vs Throws:** Phân biệt ném lỗi chủ động và khai báo lỗi.
- [ ] **Custom Exception:** Tự tạo Exception riêng (ví dụ: `UserNotFoundException`).

---

## 6. Các khái niệm bổ trợ (Spring Essentials)
- [ ] **Annotation:**
    <details>
    <summary>🔻 <em>Ví dụ Annotation</em></summary>

    - Hiểu các ký hiệu bắt đầu bằng `@` (ví dụ `@Override`).
    - *Chuẩn bị:* Spring Boot là thiên đường của Annotation (`@Component`, `@Service`, `@Controller`).
    </details>

- [ ] **Maven/Gradle:** Hiểu file `pom.xml` dùng để quản lý thư viện (Dependency Management).