# Đề tài: QUẢN LÝ BÁN SÁCH 
### Môn: PHÁT TRIỂN PHẦN MỀM HƯỚNG DỊCH VỤ  
### Yêu cầu
Cần có một phần mềm chuyên dụng trong việc quản lí bán sách cho phép:
-	Sử dụng được trên ít nhất 2 nền tảng.
-	Quản lý mọi thông tin về tất cả khách hàng, đơn hàng và sản phẩm.
-	Cho phép người dùng xem thông tin sản phẩm và đặt hàng thông qua việc sử dụng API trong quá trình tương tác và truy vấn dữ liệu.
### Xây dựng API dựa trên mô hình 3 lớp
- **Presentation Layer (Controller):** Giao tiếp với người dùng cuối (client), thu thập dữ liệu và trả về kết quả hiển thị. Nghĩa là mọi dữ liệu gửi lên gửi xuống đều thông qua Controller và ở đây chỉ kiểm tra tính đúng đắn của dữ lệu trước khi gọi tầng Service.
Khi người dùng gửi request yêu cầu -->  Controller tiếp nhận --> Tìm handler tương ứng để thực thi. 1 request sẽ có 1 handler riêng. Request có thể yêu cầu hiện thị trang danh sách sản phẩm, yêu cầu tạo user, đặt hàng, … Chỉ nên xử lý DTO, đồng nghĩa với việc các Controller chỉ nên nhận và trả về dữ liệu là DTO.  
Ứng với mỗi yêu cầu – request sẽ có một cách thức xử lý riêng tùy theo @Serive  
- **Business Logic Layer (Service):** Khi các handler sau khi hận được request sẽ chuyển các yêu cầu xuống cho lớp Business Logic: Nơi kiểm tra các ràng buộc, validation, tính ràng buộc, hợp lệ của thông tin. Tính toán xử lí các yêu cầu và lựa chọn kết quả để trả về cho Controller. Nhận vào DTO (từ controller gửi qua) hoặc Domain model (từ các service nội bộ khác). Dữ liệu được xử lý (có thể tương tác với DB), cuối cùng được Service trả về Web layer dưới dạng DTO.  
Business Logic Layer muốn thực hiện truy vấn vào CSDL phải thông qua @Repository  
- **Data Access Layer (Repository):**
Nơi lưu trữ và trích xuất dữ liệu từ hệ quản trị cơ sở dữ liệu. Nơi thực hiện giao tiếp với CSDL, xử lý truy vấn và trả về kiểu dữ liệu service mong muốn. Chỉ thao tác trên Entity, vì đó là đối tượng thích hợp, có thể mapping vào DB.  
#
