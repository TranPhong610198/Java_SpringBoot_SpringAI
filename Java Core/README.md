\# 🚀 Java Core Checklist: Hành Trang Vào Spring Boot



Tài liệu này tổng hợp các kiến thức nền tảng Java bắt buộc phải nắm vững trước khi đi sâu vào Spring Boot. Mục tiêu là lấp lỗ hổng kiến thức và chuẩn bị tư duy tốt nhất cho Backend Development.



---



\### 1. Cú pháp \& Tư duy cơ bản (Level: PRO192)

> 💡 \*\*Tầm quan trọng:\*\* Đây là nền móng. Nếu quên phần này, bạn sẽ không thể viết logic code cơ bản.



\- \[ ] \*\*Biến \& Kiểu dữ liệu:\*\*

&nbsp;   - Phân biệt rõ `int` (primitive) và `Integer` (wrapper class).

&nbsp;   - \*Lý do:\* Trong Database Mapping và Generic của Spring, bắt buộc phải dùng Wrapper Class.

\- \[ ] \*\*String vs StringBuilder:\*\*

&nbsp;   - Hiểu cơ chế Immutable của String.

&nbsp;   - \*Lưu ý:\* Tránh dùng cộng chuỗi (`+`) trong vòng lặp, hãy dùng `StringBuilder` để tối ưu hiệu năng.

\- \[ ] \*\*Control Flow (Luồng điều khiển):\*\*

&nbsp;   - Thành thạo `if-else`, `switch-case`.

&nbsp;   - Các loại vòng lặp: `for`, `for-each`, `while`.

\- \[ ] \*\*Mảng (Array):\*\* Cách khai báo, khởi tạo và truy xuất phần tử cơ bản.



\### 2. Lập trình hướng đối tượng - OOP (🔥 QUAN TRỌNG NHẤT)

> 💡 \*\*Tầm quan trọng:\*\* Spring Boot vận hành hoàn toàn dựa trên các nguyên lý này (DI/IoC). Nếu hổng chỗ này, bạn sẽ chỉ biết copy code mà không hiểu bản chất.



\- \[ ] \*\*Class \& Object:\*\* Tư duy về Lớp và Đối tượng (Instance).

\- \[ ] \*\*4 Tính chất OOP:\*\*

&nbsp;   - \[ ] \*\*Đóng gói (Encapsulation):\*\* Hiểu về `private`, `public`, `protected`. Sử dụng Getter/Setter (Spring dùng cái này để map JSON vào Object).

&nbsp;   - \[ ] \*\*Kế thừa (Inheritance):\*\* Sử dụng từ khóa `extends`.

&nbsp;   - \[ ] \*\*Đa hình (Polymorphism):\*\* Phân biệt Override (ghi đè) và Overload (nạp chồng).

&nbsp;   - \[ ] \*\*Trừu tượng (Abstraction):\*\* Phân biệt `Abstract Class` vs `Interface`.

\- \[ ] \*\*Interface (Cực kỳ quan trọng):\*\*

&nbsp;   - Hiểu bản chất Interface là bản thiết kế hành vi.

&nbsp;   - \*Ứng dụng:\* Trong Spring, Service và Repository giao tiếp qua Interface để đảm bảo Loose Coupling (Lỏng lẻo sự phụ thuộc).

\- \[ ] \*\*Constructor:\*\* Default constructor vs Parameterized constructor.

\- \[ ] \*\*Static \& Final:\*\* Khi nào dùng biến tĩnh (`static`), hằng số (`final`).



\### 3. Java Collections Framework

> 💡 \*\*Tầm quan trọng:\*\* Làm Backend thực chất là xử lý danh sách dữ liệu. Bạn không thể sống thiếu phần này.



\- \[ ] \*\*List (ArrayList, LinkedList):\*\* Các thao tác thêm, sửa, xóa, duyệt danh sách.

\- \[ ] \*\*Set (HashSet):\*\* Xử lý tập hợp không chứa phần tử trùng lặp.

\- \[ ] \*\*Map (HashMap, TreeMap):\*\*

&nbsp;   - Lưu trữ dạng Key-Value.

&nbsp;   - \*Ứng dụng:\* Rất quan trọng khi xử lý cấu hình (Config) hoặc dữ liệu JSON động.

\- \[ ] \*\*Generics:\*\*

&nbsp;   - Hiểu ý nghĩa dấu ngoặc nhọn `<T>`.

&nbsp;   - Ví dụ: `List<String>`, `Map<String, User>`. Spring Data JPA dùng cái này dày đặc.



\### 4. Java Modern (Java 8+)

> 💡 \*\*Tầm quan trọng:\*\* Code Spring Boot hiện đại yêu cầu sự ngắn gọn. Không ai viết code theo kiểu Java 5 cũ kỹ nữa.



\- \[ ] \*\*Lambda Expressions:\*\* Viết hàm ẩn danh ngắn gọn `() -> {}`.

\- \[ ] \*\*Stream API:\*\*

&nbsp;   - Tư duy xử lý dữ liệu dạng dòng chảy.

&nbsp;   - Các hàm phổ biến: `filter`, `map`, `sorted` (thay thế cho vòng lặp for truyền thống).

\- \[ ] \*\*Optional:\*\* Cách xử lý lỗi `NullPointerException` một cách thanh lịch, tránh crash ứng dụng.



\### 5. Xử lý lỗi (Exception Handling)

\- \[ ] \*\*Try - Catch - Finally:\*\* Cấu trúc bắt lỗi cơ bản.

\- \[ ] \*\*Throw vs Throws:\*\* Phân biệt ném lỗi chủ động và khai báo lỗi.

\- \[ ] \*\*Custom Exception:\*\* Tự tạo Exception riêng (ví dụ: `UserNotFoundException`).



\### 6. Các khái niệm bổ trợ (Spring Essentials)

\- \[ ] \*\*Annotation:\*\*

&nbsp;   - Hiểu các ký hiệu bắt đầu bằng `@` (ví dụ `@Override`).

&nbsp;   - \*Chuẩn bị:\* Spring Boot là thiên đường của Annotation (`@Component`, `@Service`, `@Controller`).

\- \[ ] \*\*Maven/Gradle:\*\* Hiểu file `pom.xml` dùng để quản lý thư viện (Dependency Management).

