# 🚀 Java Core Checklist: Hành Trang Vào Spring Boot

> **Giới thiệu:** Tài liệu này tổng hợp các kiến thức nền tảng Java bắt buộc phải nắm vững trước khi đi sâu vào Spring Boot. Mục tiêu là lấp lỗ hổng kiến thức và chuẩn bị tư duy tốt nhất cho Backend Development.

---

## 1. Cú pháp & Tư duy cơ bản (Level: PRO192)
> 💡 **Tầm quan trọng:** Đây là nền móng. Nếu quên phần này, bạn sẽ không thể viết logic code cơ bản.

- [x] **Biến & Kiểu dữ liệu**
    - [x] Phân biệt `int` (primitive) và `Integer` (wrapper class).
    <details>
    <summary>📝 <em>Xem chi tiết sự khác biệt</em></summary>
    
    * **`int` (Primitive):** Lưu giá trị thực tế, nhẹ, nhanh, **không** dùng được trong Collection.
    * **`Integer` (Wrapper Class):** Là Object trỏ tới vùng nhớ, có method hỗ trợ (`.parseInt()`, ...), **dùng được** trong Collection.
    * *Lý do:* Trong Database Mapping (Hibernate) và Generic của Spring, bắt buộc phải dùng Wrapper Class.
    </details>

- [x] **String vs StringBuilder**
    - [x] Hiểu cơ chế **Immutable** (Bất biến) của String.
    <details>
    <summary>📝 <em>Tại sao String lại bất biến?</em></summary>

    ```java
    String s = "Hello";
    s = s + " World";
    // Java KO sửa chữ "Hello".
    // Java tạo chuỗi MỚI "Hello World" và trỏ s vào đó.
    ```
    </details>
    
    - [x] **StringBuilder (Mutable):** Dùng khi cần cộng chuỗi trong vòng lặp để tối ưu hiệu năng (tránh tạo rác bộ nhớ).

- [x] **Control Flow (Luồng điều khiển)**
    - [x] Thành thạo `if-else`, `switch-case`.
    - [x] Các loại vòng lặp: `for`, `for-each`, `while`.

- [x] **Mảng (Array):** Cách khai báo, khởi tạo và truy xuất.

---

## 2. Lập trình hướng đối tượng - OOP (🔥 QUAN TRỌNG NHẤT)
> 💡 **Tầm quan trọng:** Spring Boot vận hành hoàn toàn dựa trên các nguyên lý này (DI/IoC).

- [x] **Class & Object:**
    - **Class:** Bản vẽ thiết kế (Trừu tượng).
    - **Object:** Vật thể cụ thể tạo từ bản vẽ (Instance).

- [x] **4 Tính chất OOP**
    
    ### A. Đóng gói (Encapsulation)
    - [x] Hiểu `private`, `public`, `protected`.
    - [x] **Getter/Setter:** Dùng để map JSON hoặc Entity. *Tip: Dùng Lombok để đỡ gõ tay.*
    <details>
    <summary>🛡️ <em>Kinh nghiệm về Access Modifiers</em></summary>
    
    * **Private:** Mặc định luôn dùng cái này.
    * **Protected:** Dùng khi viết thư viện hoặc cần class con kế thừa.
    * **Public:** Chỉ dùng cho API, Hằng số (Constant).
    </details>

    ### B. Kế thừa (Inheritance)
    - [x] Từ khóa `extends`. Quan hệ **Is-A**.
    - [x] `super`, `@Override`.
    <details>
    <summary>⚠️ <em>Lưu ý quan trọng: Composition over Inheritance</em></summary>
    
    Hạn chế `extends` nếu không cần thiết vì gây **Tight Coupling** (dính chặt). Hãy ưu tiên ghép nối (Composition - **Has-A**).
    
    ```java
    // Composition: Window CÓ MỘT Rectangle
    class Window { 
        private Rectangle rect = new Rectangle(); 
        public void draw() {
            rect.draw(); // Mượn Rectangle để vẽ 
        } 
    }
    ```
    </details>

    ### C. Đa hình (Polymorphism)
    - [x] **Overloading (Nạp chồng):** Cùng tên hàm, khác tham số (Compile-time).
    - [x] **Overriding (Ghi đè):** Class con viết lại hàm của class cha (Run-time).
    <details>
    <summary>🧩 <em>Ví dụ Đa hình động (Upcasting)</em></summary>
    
    ```java
    Animal a = new Dog(); // Khai báo Cha, khởi tạo Con
    a.speak(); // Chạy hàm của Dog (Go Go)
    ```
    </details>

    ### D. Trừu tượng (Abstraction) & Interface
    - [x] Phân biệt `Abstract Class` vs `Interface`.

    | Đặc điểm | Abstract Class | Interface |
    | :--- | :--- | :--- |
    | **Bản chất** | Bản thiết kế dở dang | Bản hợp đồng (Contract) / Khả năng (Capability) |
    | **Từ khóa** | `extends` | `implements` |
    | **Đa kế thừa** | Không (Chỉ 1 cha) | Có (Nhiều Interface) |
    | **Dữ liệu** | Có thể có state (biến) | Chỉ có hằng số (static final) |
    | **Khi nào dùng** | Các class có quan hệ cha-con chặt chẽ | Quy định hành vi cho các class ko liên quan |

- [x] **Dependency Injection (DI) & Testability**
    > 🎯 **Lời khuyên cho đồ án:** Luôn bắt đầu bằng Interface cho tầng Service (`UserService` -> `UserServiceImpl`).
    <details>
    <summary>🔌 <em>Tại sao phải tách Interface và Impl?</em></summary>
    
    1.  **Linh hoạt:** Đổi từ SQL sang MongoDB chỉ cần viết class Impl mới, không sửa Controller.
    2.  **Testability:** Dễ dàng Mock (giả lập) dữ liệu để test Controller mà không cần DB thật.
    
    ```java
    @RestController
    public class UserController {
        @Autowired
        private UserService userService; // Gọi Interface, KHÔNG gọi Class cụ thể
    }
    ```
    </details>

---

## 3. Java Collections Framework
> 💡 **Tầm quan trọng:** Backend thực chất là xử lý danh sách dữ liệu.

- [ ] **List (ArrayList, LinkedList):**
    - **ArrayList:** Dùng 98% trường hợp (truy xuất nhanh).
- [ ] **Set (HashSet):** Tập hợp không trùng lặp.
- [ ] **Map (HashMap, TreeMap):**
    - Lưu Key-Value. Cực quan trọng cho Config và JSON.
- [ ] **Generics:** Hiểu `<T>`, ví dụ `List<String>`, `Map<String, User>`.

---

## 4. Java Modern (Java 8+)
> 💡 **Tầm quan trọng:** Code Spring Boot hiện đại yêu cầu sự ngắn gọn.

- [ ] **Lambda Expressions:** `() -> {}`.
- [ ] **Stream API:** Tư duy dòng chảy (`filter`, `map`, `sorted`).
- [ ] **Optional:** Xử lý `NullPointerException` thanh lịch.

---

## 5. Xử lý lỗi (Exception Handling)

- [ ] **Try - Catch - Finally**
- [ ] **Throw vs Throws**
- [ ] **Custom Exception:** Ví dụ `UserNotFoundException`.

---

## 6. Các khái niệm bổ trợ (Spring Essentials)

- [ ] **Annotation:** Các ký hiệu `@` (ví dụ `@Override`, `@Component`, `@Service`).
- [ ] **Maven/Gradle:** Quản lý thư viện (`pom.xml` hoặc `build.gradle`).