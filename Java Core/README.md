SẴN SÀNG CHO SPRING BOOT

1\. Cú pháp \& Tư duy cơ bản (Level: PRO192) Đây là nền móng. Nếu quên phần này, bạn sẽ không viết được code.

&nbsp;	- Biến \& Kiểu dữ liệu: Phân biệt được int (primitive) và Integer (wrapper class). Tại sao? Vì trong Database và Generic của Spring, chúng ta dùng Wrapper Class.

&nbsp;	- String vs StringBuilder: Hiểu tại sao không nên cộng chuỗi (+) quá nhiều mà nên dùng StringBuilder.

&nbsp;	- Vòng lặp \& Câu điều kiện: if-else, switch-case, for, for-each, while.

&nbsp;	- Mảng (Array): Cách khai báo và truy xuất phần tử cơ bản.

2\. Lập trình hướng đối tượng - OOP (QUAN TRỌNG NHẤT) Spring Boot vận hành hoàn toàn dựa trên các nguyên lý này. Nếu hổng chỗ này, bạn sẽ không hiểu tại sao code lại chạy.

&nbsp;	- Class \& Object: Cách tạo class, tạo object (instance).

&nbsp;	- 4 Tính chất OOP:

&nbsp;		\[ ] Đóng gói (Encapsulation): Hiểu về private, public, protected và Getter/Setter. Spring dùng cái này để map dữ liệu từ JSON vào Object.

&nbsp;		\[ ] Kế thừa (Inheritance): Từ khóa extends.

&nbsp;		\[ ] Đa hình (Polymorphism): Hiểu Override (ghi đè) và Overload (nạp chồng).

&nbsp;		\[ ] Trừu tượng (Abstraction): Abstract Class vs Interface.

&nbsp;		\[ ] Interface: (Cực kỳ quan trọng) Bạn phải hiểu Interface là gì. Vì trong Spring, các Service và Repository đều làm việc qua Interface để lỏng lẻo sự phụ thuộc (Loose Coupling).

&nbsp;		\[ ] Constructor: Default constructor vs Parameterized constructor.

&nbsp;		\[ ] Static \& Final: Khi nào dùng biến tĩnh (static), hằng số (final).

3\. Java Collections Framework (Cấu trúc dữ liệu)Làm Backend là xử lý danh sách dữ liệu. Bạn không thể sống thiếu phần này.

&nbsp;	- List (ArrayList, LinkedList): Biết cách thêm, sửa, xóa, duyệt danh sách.

&nbsp;	- Set (HashSet): Tập hợp không chứa phần tử trùng lặp.

&nbsp;	- Map (HashMap, TreeMap): Lưu trữ dạng Key-Value. Rất quan trọng khi xử lý JSON hoặc cấu hình.

&nbsp;	- Generics: Hiểu cái dấu ngoặc nhọn \\<T\\>. Ví dụ: List\\<String\\>, Map\\<String, User\\>. Spring Data JPA dùng cái này dày đặc.

4\. Java Modern (Java 8+)Code Spring Boot hiện đại không ai viết theo kiểu Java 5 ngày xưa. Bạn cần biết các tính năng mới này để code ngắn gọn.

&nbsp;	- Lambda Expressions: Viết hàm ẩn danh ngắn gọn () -> {}.

&nbsp;	- Stream API: Cách lọc (filter), ánh xạ (map), sắp xếp (sorted) một List mà không cần dùng vòng lặp for truyền thống.

&nbsp;	- Optional: Cách xử lý lỗi NullPointerException một cách thanh lịch.

5\. Xử lý lỗi (Exception Handling)

&nbsp;	- Try - Catch - Finally: Bắt lỗi cơ bản.

&nbsp;	- Throw vs Throws: Cách ném lỗi ra ngoài.

&nbsp;	- Custom Exception: Tự tạo ra lỗi riêng (ví dụ: UserNotFoundException).

6\. Các khái niệm bổ trợ (Cần cho Spring)

&nbsp;	- Annotation: Hiểu các ký hiệu bắt đầu bằng @ (ví dụ @Override). Spring Boot là thiên đường của Annotation (@Component, @Service, @Controller).

&nbsp;	- Maven/Gradle: Biết file pom.xml dùng để làm gì (quản lý thư viện).

