\# 🚀 Java Core Checklist: Hành Trang Vào Spring Boot



Tài liệu này tổng hợp các kiến thức nền tảng Java bắt buộc phải nắm vững trước khi đi sâu vào Spring Boot. Mục tiêu là lấp lỗ hổng kiến thức và chuẩn bị tư duy tốt nhất cho Backend Development.



---



\### 1. Cú pháp \& Tư duy cơ bản (Level: PRO192)

> 💡 \*\*Tầm quan trọng:\*\* Đây là nền móng. Nếu quên phần này, bạn sẽ không thể viết logic code cơ bản.



\- \[x] \*\*Biến \& Kiểu dữ liệu:\*\*

&nbsp;   - Phân biệt rõ `int` (primitive) và `Integer` (wrapper class).

&nbsp;	    - `int` (primitive) là một trong những kiểu dữ liệu nguyên thủy lưu giá trị thực tế, không dùng được trong Collection.

&nbsp;	    - `Integer` (wapper class) là một đối tượng trỏ tới vùng nhớ chứa giá trị, và vì là một đối tượng nên nó có nhiều hàm hỗ trợ, và dùng được trong Collection.Trong Java, \*\*Collection Framework\*\* là một kiến trúc thống nhất nằm trong gói `java.util`, cung cấp các \*\*Interface\*\* (giao diện) và \*\*Class\*\* (lớp) để lưu trữ và thao tác với một nhóm các đối tượng. Collection chia làm 3 nhóm chính (Interface con của `Collection`, List Set, Queue) và 1 nhóm đặc biệt (`Map`)

&nbsp;   - \*Lý do:\* Trong Database Mapping và Generic của Spring, bắt buộc phải dùng Wrapper Class.

\- \[x] \*\*String vs StringBuilder:\*\*

&nbsp;   - Hiểu cơ chế Immutable của String.

&nbsp;	    - \*\*"Immutable"\*\* nghĩa là \*\*"Không thể thay đổi"\*\*. Trong Java, một khi đối tượng `String` đã được tạo ra trong bộ nhớ (Heap), nội dung của nó \*\*vĩnh viễn không bao giờ thay đổi\*\*. Có vẻ khó hiểu nhưng ví dụ ở dòng code dưới

&nbsp;		``` java

&nbsp;		String s = "Hello";

&nbsp;		s = s + " World";

&nbsp;		// Có vẻ biến s đã thay đổi từ "Hello" sang "Hello World", nhưng thực ra là JAVA ko sửa chữ "Hello" mà nó tạo mội chuỗi mới "Hello World" và chuyển con trỏ của biến s sang "Hello World"

&nbsp;		```

&nbsp;	- \*Lưu ý:\* Tránh dùng cộng chuỗi (`+`) trong vòng lặp, hãy dùng `StringBuilder` để tối ưu hiệu năng.

&nbsp;		- StringBuilder(\*\*Mutable\*\*): Nó như cái bảng trắng, khi bạn muốn thêm chữ, thì chỉ cần viết tiếp vào, không cần thay bảng mới. Bên trong StringBuilder là 1 mảng kí tự char\[], khi append(), nó sẽ điền tiếp vào mảng. 

\- \[x] \*\*Control Flow (Luồng điều khiển):\*\*

&nbsp;   - Thành thạo `if-else`, `switch-case`.

&nbsp;   - Các loại vòng lặp: `for`, `for-each`, `while`.

\- \[x] \*\*Mảng (Array):\*\* Cách khai báo, khởi tạo và truy xuất phần tử cơ bản.



\### 2. Lập trình hướng đối tượng - OOP (🔥 QUAN TRỌNG NHẤT)

> 💡 \*\*Tầm quan trọng:\*\* Spring Boot vận hành hoàn toàn dựa trên các nguyên lý này (DI/IoC). Nếu hổng chỗ này, bạn sẽ chỉ biết copy code mà không hiểu bản chất.



\- \[x] \*\*Class \& Object:\*\* Tư duy về Lớp và Đối tượng (Instance).

&nbsp;	- \*\*Class\*\* là bản vẽ thiết kế, là 1 khải niệm trừu tượng, nằm trên giấy tờ

&nbsp;	- \*\*Object\*\* là vật cụ thể đc tạo từ bản vẽ (\*\*class\*\*)

\- \[x] \*\*4 Tính chất OOP:\*\*

&nbsp;   - \[x] \*\*Đóng gói (Encapsulation):\*\* Hiểu về `private`, `public`, `protected`. Sử dụng Getter/Setter (Spring dùng cái này để map JSON vào Object).

&nbsp;	    - Đóng gói chính là việc che giấu dữ liệu bên trong, chỉ lộ ra những cái cần thiết (method) ra bên ngoài 

&nbsp;	    - 4 cấp độ bảo mật(Access Modifiers):

&nbsp;		    - \*\*Private\*\*: Chỉ nội bộ class mới thấy, \*\*Kinh nghiệm\*\* là mặc định luôn để private cho tất cả các thuộc tính, chỉ mở rộng khi thực sự cần thiết

&nbsp;		    - \*\*Protected\*\*: Cùng package, lớp con mới thấy. \*\*Kinh nghiệm\*\* là dùng khi thiết kế thư viện hoặc Framework để cho phép class con override

&nbsp;		    - \*\*Public\*\*: Toàn bộ dự án có thể dùng. \*\*Kinh nghiệm\*\* chỉ dùng cho các hàm API, các hằng số, hoặc class chính

&nbsp;		- Getter/Setter: Dùng để kiểm soát dữ liệu, Read-only hoặc Write-only, và đặc biệt tương thích với Framework. \*\*Kinh nghiệm\*\* thay vì ngồi gõ một đống Getter/Setter cho 10 class entity thì có thể dùng \*\*Lombok\*\*

&nbsp;   - \[x] \*\*Kế thừa (Inheritance):\*\* Sử dụng từ khóa `extends`.

&nbsp;	    - Kế thừa hay chính là quan hệ Is-A, ví dụ `Dog` \*\*is an\*\* `Animal` $\\rightarrow$ Hợp lý.

&nbsp;		    ```java

&nbsp;	      // Lớp Cha (Super Class / Parent Class)

&nbsp;			class Animal {

&nbsp;			    protected String name; // protected để con cháu dùng được

&nbsp;			    public void eat() {

&nbsp;				    System.out.println("Đang ăn...");

&nbsp;			    }

&nbsp;			}

&nbsp;			// Lớp Con (Sub Class / Child Class)

&nbsp;			class Dog extends Animal { // Dog kế thừa TẤT CẢ từ Animal

&nbsp;			    public void bark() {

&nbsp;			        System.out.println("Gâu gâu!");

&nbsp;			    }

&nbsp;			}

&nbsp;			public class Main {

&nbsp;			    public static void main(String\[] args) {

&nbsp;		        Dog dog = new Dog();

&nbsp;		        dog.name = "Milu"; // Dùng tài sản của cha

&nbsp;		        dog.eat();         // Dùng hành động của cha

&nbsp;		        dog.bark();        // Hành động riêng của con

&nbsp;			    }

&nbsp;			}

&nbsp;		    ```

&nbsp;		- Các từ khóa quan trọng

&nbsp;			- super: Đại diện cho lớp cha, dùng để gọi hàm của cha khi lỡ bị con ghi đè

&nbsp;			- @Override: Khi lớp con ko thích cách triển khai của lớp cha, muốn làm khác đi.

&nbsp;				- ``` java

&nbsp;				  class Bird extend Animal{

&nbsp;					  @Override

&nbsp;					  public void move(){

&nbsp;						  System.out.println("Đang bay...");

&nbsp;					  }

&nbsp;				  }

&nbsp;				  ```

&nbsp;		- Trong Java không cho phép đa kế thừa class, 

&nbsp;			- Vì dễ dẫn đến "tẩu hỏa nhập ma", do trường hợp 2 class cha đều có chung 1 method thì khi thằng con dùng không biết đang dùng của thằng nào.

&nbsp;			- Tuy ko thể đa kế thừa class, nhưng Java lại cho phép đa kế thừa interface

&nbsp;		- Góc nhìn kinh nghiệm, Composition over Inheritance

&nbsp;			- Tức là ưu tiên ghép nối hơn là kế thừa

&nbsp;			- Kế thừa tuy mạnh nhưng lại dẫn đến Tight Coupling, nếu sửa code ở cha, tất cả các thằng con sẽ bị ảnh hưởng

&nbsp;			- \*\*Vì thế\*\* hạn chế extends nếu không thực sự cần thiết. Thay vào đó, hãy dùng Composition (Thành phần). Ví dụ: 

&nbsp;			  ``` java

&nbsp;				// Composition: Window CÓ MỘT (Has-A) Rectangle 

&nbsp;				class Window { 

&nbsp;					private Rectangle rect = new Rectangle(); 

&nbsp;					public void draw() {

&nbsp;						rect.draw(); // Mượn Rectangle để vẽ 

&nbsp;					} 

&nbsp;				}

&nbsp;			  ```

&nbsp;   - \[x] \*\*Đa hình (Polymorphism):\*\* Phân biệt Override (ghi đè) và Overload (nạp chồng).

&nbsp;	    - Đa hình tĩnh (Static) - Method Overloading

&nbsp;		    - Cùng tên hàm, nhưng khác tham số

&nbsp;		    - Tại sao lại cần? để người dùng đỡ phải nhớ nhiều tên hàm.

&nbsp;			- ``` java

&nbsp;		      class Calculator {

&nbsp;			      // Cộng 2 số nguyên

&nbsp;				  int add(int a, int b){

&nbsp;					  return a+b;

&nbsp;				  }

&nbsp;				  // Cộng 3 số nguyên

&nbsp;				  int add(int a, int b, int c){

&nbsp;					  return a+b+c;

&nbsp;				  }

&nbsp;			  }

&nbsp;		      ```

&nbsp;	    - Đa hình động (Dynamic) - Method Overriding - Trùm cuối

&nbsp;			- Kỹ thuật Upcasting( Ép kiểu lên ) khai báo kiểu Cha, nhưng khởi tạo đối tượng kiểu Con

&nbsp;			- ``` java

&nbsp;			  // Cha

&nbsp;			  class Animal {

&nbsp;				  void speak() { System.out.println("..."); }

&nbsp;			  }

&nbsp;			  

&nbsp;			  // Con1

&nbsp;			  class Dog extends Animal {

&nbsp;				  @Override

&nbsp;				  void speak() { System.out.println("Go Go"); }

&nbsp;			  }

&nbsp;			  

&nbsp;			  // Con2

&nbsp;			  class Cat extends Animal {

&nbsp;				  @Override

&nbsp;				  void speak() { System.out.println("Meow meow"); }

&nbsp;			  }

&nbsp;			  

&nbsp;			  public class Main {

&nbsp;				  public static void main(String\[] args){

&nbsp;				  Animal a;

&nbsp;				  

&nbsp;				  a = new Dog();

&nbsp;				  a.speak(); 

&nbsp;				  

&nbsp;				  a = new Cat();

&nbsp;				  a.speak();

&nbsp;				  }

&nbsp;			  }

&nbsp;			  ```

&nbsp;   - \[x] \*\*Trừu tượng (Abstraction):\*\* Phân biệt `Abstract Class` vs `Interface`.

&nbsp;		- \*\*Abstract Class\*\* là một bản thiết kế dở dang, n chứa các hàm trừu tượng (abstract method), chỉ có tên hàm mà ko có ruột

&nbsp;			 - Quy tắc khi dùng Abstract Class:

&nbsp;			    - Class con kế thừa bắt buộc phải viết code cho các hàm trừu tượng đó (trừ khi con cũng là abstract)

&nbsp;			    - Dùng abstract class khi muốn các class con chia sẻ code chung nhưng bắt chúng phải tự định nghĩa một vài hành động riêng

&nbsp;				    - ``` java

&nbsp;					//Abstract Class: NhanVien

&nbsp;					  abstract class Employee {

&nbsp;						  String name;

&nbsp;						  // Hàm thương: ai cũng cần -> Viết sẵn

&nbsp;						  void checkin(){

&nbsp;							  System.out.println("Quẹt thẻ chấm công");

&nbsp;						  }

&nbsp;						  // Hàm trừu tượng

&nbsp;						  abstract double calculateSalary();

&nbsp;					  }

&nbsp;					  class Dev extends Employee{

&nbsp;						  @Override

&nbsp;						  double calculateSalary(){

&nbsp;							  return 2000 \* 1.5; 

&nbsp;						  }

&nbsp;					  }

&nbsp;				      ```

&nbsp;		- \*\*Interface\*\* như một Bản Hợp Đồng(Contract) hoặc Khả Năng (Capability) - Sẽ được nói rõ hơn ở phần dưới

&nbsp;			- Không phải là 1 class, mà là một tập hợp các quy định

&nbsp;			- Tất cả các hàm bên trong đều mặc định là public abstract

&nbsp;			- Một Class có thể implements nhiều Interface cùng lúc

&nbsp;			- Dùng Interface khi muốn quy định hành vi cho các Class không liên quan j đến nhau

&nbsp;				- ``` java

&nbsp;				  interface Flyable { 

&nbsp;					  void fly(); // Hợp đồng: Ai ký cái này thì phải biết bay 

&nbsp;				  } 

&nbsp;				  class Bird extends Animal implements Flyable { 

&nbsp;					  public void fly() { 

&nbsp;						  System.out.println("Vỗ cánh bay"); 

&nbsp;					  } 

&nbsp;				  } 

&nbsp;				  class Airplane implements Flyable { 

&nbsp;					  public void fly() { 

&nbsp;						  System.out.println("Dùng động cơ phản lực"); 

&nbsp;					  } 

&nbsp;				  }

&nbsp;				  ```

\- \[x] \*\*Interface (Cực kỳ quan trọng):\*\*

&nbsp;   - Hiểu bản chất Interface là bản thiết kế hành vi.

&nbsp;   - \*Ứng dụng:\* Trong Spring, Service và Repository giao tiếp qua Interface để đảm bảo Loose Coupling (Lỏng lẻo sự phụ thuộc).

&nbsp;   - Phân Biệt Abstract với Interface !\[\[Pasted image 20260119164159.png]]

\- \[ ] \*\*Dependency Injection\*\* và \*\*Testability\*\*:

&nbsp;	- Trong các dự án thực tế (và đồ án của em sắp tới), em sẽ thấy cấu trúc này suốt ngày:

&nbsp;		1. `UserService` (Interface): Định nghĩa xem service này làm được gì (thêm, sửa, xóa user).

&nbsp;		2. `UserServiceImpl` (Class): Code chi tiết thực hiện các việc đó.

&nbsp;	- \*\*Tại sao phải tách ra làm 2 file cho mệt?\*\* 

&nbsp;		- \*\*Dependency Injection (DI)\*\* và \*\*Testability\*\*. Khi em viết Controller, em chỉ gọi Interface:

&nbsp;			- ``` java

&nbsp;				@RestController

&nbsp;				public class UserController {

&nbsp;				    @Autowired

&nbsp;					    // Gọi Interface, không gọi Impl cụ thể

&nbsp;					    private UserService userService; 

&nbsp;				    // ...

&nbsp;				}		  

&nbsp;			  ```

&nbsp;		- \*\*Linh hoạt:\*\* Hôm nay `userService` chạy code kết nối SQL. Ngày mai sếp bảo chuyển sang MongoDB, em chỉ cần viết một class `UserServiceMongoImpl` mới implement cái Interface cũ. Code ở Controller \*\*không cần sửa một dòng nào\*\*.

&nbsp;		- \*\*Test:\*\* Khi viết Unit Test, em có thể tạo một `FakeUserService` giả lập để test Controller mà không cần kết nối Database thật.

&nbsp;	- Lời khuyên cho đồ án tốt nghiệp:

&nbsp;		- \*\*Với Entity (Dữ liệu):\*\* Dùng Class bình thường (hoặc Abstract Class nếu có phân cấp cha con rõ ràng).

&nbsp;		- \*\*Với Service/Logic:\*\* \*\*Luôn bắt đầu bằng Interface\*\*. Viết Interface trước để định hình xem chức năng đó cần input/output là gì, sau đó mới viết class `Impl` để code chi tiết. Đây gọi là \*\*"Interface-driven development"\*\*.

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



&nbsp;





