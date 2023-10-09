<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/29/2023
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous">
<style>
    * {
        box-sizing: border-box;
    }

    i {
        color: red;
    }

    .flexrow {
        display: flex;
        font-weight: bold;
        padding-left: 10px;
    }

    .flexrow div {
        padding-right: 10px;
    }
</style>
<body class="container">
<div style="text-align: center; font-family: 'Times New Roman'">
    <h4><strong>TỜ KHAI Y TẾ</strong></h4>
    <p><strong>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG
        CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</strong></p>
    <strong style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
        sự</strong>
</div>
<br>
<form:form modelAttribute="medical" action="/medical" method="post">
    <table>
        <tr>
            <div class="form-group">
                <label for="name"><strong>Họ tên(ghi chữ IN HOA) <i>(*)</i></strong></label>
                <form:input path="name" class="form-control" id="name" required="required"/>
            </div>
        </tr>
        <tr>
            <div class="row">
                <div class="form-group col-sm-4">
                    <label for="year"><strong>Năm sinh <i>(*)</i></strong></label>
                    <form:select path="year" id="year" items="${listYear}" class="form-select"
                                 aria-label="Default select example" required="required">
                    </form:select>
                </div>
                <div class="form-group col-sm-4">
                    <label for="gender"><strong>Giới tính <i>(*)</i></strong></label>
                    <form:select path="gender" id="gender" class="form-select"
                                 aria-label="Default select example" required="required">
                        <form:option value="NONE"> -Chọn- </form:option>
                        <form:options items="${listGender}"></form:options>
                    </form:select>
                </div>
                <div class="form-group col-sm-4">
                    <label for="country"><strong>Quốc tịch <i>(*)</i></strong></label>
                    <form:select path="country" id="country" items="${listCountry}" class="form-select"
                                 aria-label="Default select example" required="required">
                    </form:select>
                </div>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="cmnd"><strong>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác
                    <i>(*)</i></strong></label>
                <form:input path="cmnd" class="form-control" id="cmnd" required="required"/>
            </div>
        </tr>
        <tr>
            <label><strong>Thông tin đi lại <i>(*)</i></strong></label><br>
            <div class="flexrow">
                <div class="form-check">
                    <form:radiobutton path="vihacle" value="Tàu bay" label="Tàu bay" class="form-check-input"
                                      required="required"/>
                </div>
                <div class="form-check">
                    <form:radiobutton path="vihacle" value="Tàu thuyền" label="Tàu thuyền" class="form-check-input"
                                      required="required"/>
                </div>
                <div class="form-check">
                    <form:radiobutton path="vihacle" value="Ô tô" label="Ô tô" class="form-check-input"
                                      required="required"/>
                </div>
                <div class="form-check">
                    <form:radiobutton path="vihacle" value="Khác(Ghi rõ)" label="Khác(Ghi rõ)"
                                      class="form-check-input" required="required"/>
                </div>
            </div>
        </tr>
        <tr>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="vihacleNumber"><strong>Số hiệu phương tiện <i>(*)</i></strong></label>
                    <form:input path="vihacleNumber" class="form-control" id="vihacleNumber" placeholder="VD: VN123"
                                required="required"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="chairNumber"><strong>Số ghế <i>(*)</i></strong></label>
                    <form:input path="chairNumber" class="form-control" id="chairNumber" placeholder="1"
                                required="required"/>
                </div>
            </div>
        </tr>
        <tr>
            <div class="row">
                <div class="col-6">
                    <div class="row">
                        <label for="country"><strong>Ngày khởi hành <i>(*)</i></strong></label>
                        <div class="col">
                            <form:select path="startDay" id="country" items="${listCountry}" class="form-select"
                                         aria-label="Default select example" required="required">
                            </form:select>
                        </div>
                        <div class="col">
                            <form:select path="startMonth" id="country" items="${listCountry}" class="form-select"
                                         aria-label="Default select example" required="required">
                            </form:select>
                        </div>
                        <div class="col">
                            <form:select path="startYear" id="country" items="${listCountry}" class="form-select"
                                         aria-label="Default select example" required="required">
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <div class="row">
                        <label for="country"><strong>Ngày kết thúc <i>(*)</i></strong></label>
                        <div class="col">
                            <form:select path="endDay" id="country" items="${listCountry}" class="form-select"
                                         aria-label="Default select example" required="required">
                            </form:select>
                        </div>
                        <div class="col">
                            <form:select path="endMonth" id="country" items="${listCountry}" class="form-select"
                                         aria-label="Default select example" required="required">
                            </form:select>
                        </div>
                        <div class="col">
                            <form:select path="endYear" id="country" items="${listCountry}" class="form-select"
                                         aria-label="Default select example" required="required">
                            </form:select>
                        </div>
                    </div>
                </div>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="describe"><strong>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?
                    <i>(*)</i></strong></label>
                <form:textarea path="describe" class="form-control" id="describe" required="required"/>
            </div>
        </tr>
        <tr>
            <div class="row">
                <div class="form-group col-sm-4">
                    <label for="city"><strong>Tỉnh/thành <i>(*)</i></strong></label>
                    <form:select path="city" id="city" class="form-select"
                                 aria-label="Default select example" required="required">
                        <form:option value="NONE"> -Chọn- </form:option>
                        <form:options items="${listCity}"></form:options>
                    </form:select>
                </div>
                <div class="form-group col-sm-4">
                    <label for="district"><strong>Quận/huyện <i>(*)</i></strong></label>
                    <form:select path="district" id="district" class="form-select"
                                 aria-label="Default select example" required="required">
                        <form:option value="NONE"> -Chọn- </form:option>
                        <form:options items="${listDistrict}"></form:options>
                    </form:select>
                </div>
                <div class="form-group col-sm-4">
                    <label for="ward"><strong>Phường/xã <i>(*)</i></strong></label>
                    <form:select path="ward" id="ward" class="form-select"
                                 aria-label="Default select example" required="required">
                        <form:option value="NONE"> -Chọn- </form:option>
                        <form:options items="${listWard}"></form:options>
                    </form:select>
                </div>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="address"><strong>Địa chỉ nơi ở <i>(*)</i></strong></label>
                <form:input path="address" class="form-control" id="address" required="required"/>
            </div>
        </tr>
        <tr>
            <div class="row">
                <div class="form-group col-sm-6">
                    <label for="phone"><strong>Điện thoại <i>(*)</i></strong></label>
                    <form:input path="phone" class="form-control" id="phone" required="required"/>
                </div>
                <div class="form-group col-sm-6">
                    <label for="email"><strong>Email <i>(*)</i></strong></label>
                    <form:input path="email" type="email" class="form-control" id="email" required="required"/>
                </div>
            </div>
        </tr>
        <tr>
            <strong>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không? <i>(*)</i></strong>
            <table class="table">
                <thead class="thead-light">
                <tr>
                   <th>Triệu chứng</th>
                   <th>Có</th>
                   <th>Không</th>
                   <th>Triệu chứng</th>
                   <th>Có</th>
                   <th>Không</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <strong>Sốt <i>(*)</i></strong>
                    </td>
                    <td>
                        <form:radiobutton path="sot" value="Sốt"></form:radiobutton>
                    </td>
                    <td>
                        <form:radiobutton path="sot" value="Không Sốt"></form:radiobutton>
                    </td>
                    <td>
                        <strong>Nôn/buồn nôn <i>(*)</i></strong>
                    </td>
                    <td>
                        <form:radiobutton path="non" value="Nôn/buồn nôn"></form:radiobutton>
                    </td>
                    <td>
                        <form:radiobutton path="non" value="Không Nôn/buồn nôn"></form:radiobutton>
                    </td>
                </tr>
                </tbody>
            </table>
        </tr>
        <tr>
            <button>save</button>
        </tr>
    </table>
</form:form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
