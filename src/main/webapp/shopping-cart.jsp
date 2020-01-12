<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Ecommerce | Shopping Cart</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://localhost:8080/ecommerce/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bbootstrap 4 -->
    <link rel="stylesheet"
          href="http://localhost:8080/ecommerce/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="http://localhost:8080/ecommerce/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="http://localhost:8080/ecommerce/plugins/jqvmap/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="http://localhost:8080/ecommerce/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet"
          href="http://localhost:8080/ecommerce/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="http://localhost:8080/ecommerce/plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="http://localhost:8080/ecommerce/plugins/summernote/summernote-bs4.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <!-- custom css -->
    <link rel="stylesheet" href="http://localhost:8080/ecommerce/dsit/css/style.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">

<%@include file="header.jsp" %>

<!-- start main -->
<main class="my-5 py-5">
    <div class="container">
        <!-- Main content -->
        <section class="content">
            <h3>All Selected Porducts</h3>
            <form action="/ecommerce/order">
                <table class="table table-bordered">
                <tr>
                    <th>Code</th>
                    <th>Product Details</th>
                    <th>Price</th>
                    <th width="170px">Quantity</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${all_cart_items}" var="cart">
                    <tr>
                        <td>${cart.pid}</td>
                        <td> ${cart.name} </td>
                        <td>${cart.price}</td>
                        <td>
                            <input type="number" value="${cart.quantity}" name="qty">
                        </td>
                        <td>
                            <div class="d-flex p-2">
                                <form action="update-shopping-cart" method="post">
                                    <input type="hidden" name="pid" value="${cart.pid}">
                                    <button class="mr-3">Update</button>
                                </form>
                                <form action="delete-shopping-cart" method="post">
                                    <input type="hidden" name="pid" value="${cart.pid}">
                                    <button>Delete</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>

                <button class="btn btn-primary" type="submit">Order</button>
            </form>


        </section>
        <!-- /.content -->

    </div>
</main>
<!-- end main -->

<!-- jQuery -->
<script src="http://localhost:8080/ecommerce/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="http://localhost:8080/ecommerce/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="http://localhost:8080/ecommerce/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="http://localhost:8080/ecommerce/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="http://localhost:8080/ecommerce/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="http://localhost:8080/ecommerce/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="http://localhost:8080/ecommerce/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="http://localhost:8080/ecommerce/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="http://localhost:8080/ecommerce/plugins/moment/moment.min.js"></script>
<script src="http://localhost:8080/ecommerce/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="http://localhost:8080/ecommerce/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="http://localhost:8080/ecommerce/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="http://localhost:8080/ecommerce/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="http://localhost:8080/ecommerce/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="http://localhost:8080/ecommerce/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="http://localhost:8080/ecommerce/dist/js/demo.js"></script>
</body>
</html>
