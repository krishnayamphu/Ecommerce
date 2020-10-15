<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 3 | Create Product</title>
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
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
            </li>
        </ul>
        <h5 class="float-left m-0 text-dark">Create New Product</h5>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="btn btn-sm btn-outline-success" href="http://localhost:8080/ecommerce/admin/products">
                    All Products
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <%@include file="../sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content pt-3">
            <div class="container-fluid">

                <div class="">
                    <div class="card">
                        <div class="card-body register-card-body">
                            <div class="row">
                                <div class="col-md-8">
                                    <form name="myForm" action="create-product" method="post">

                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" name="name"
                                                   placeholder="Product Name">
                                        </div>

                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="mrp_price"
                                                       placeholder="MRP">
                                            </div>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" name="actual_price"
                                                       placeholder="Actual Price">
                                            </div>
                                        </div>

                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" name="color" placeholder="Color">
                                        </div>

                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" name="size" placeholder="Size">
                                        </div>

                                        <div class="input-group mb-3">
                                    <textarea class="form-control" name="short_desc"
                                              placeholder="Short Description"></textarea>
                                        </div>

                                        <div class="input-group mb-3">
                                    <textarea class="form-control" name="long_desc"
                                              placeholder="Long Description"></textarea>
                                        </div>

                                        <div class="row mb-3">
                                            <div class="col-md-6">
                                                <div class="input-group mb-3">
                                                    <label>Product Visibility</label>
                                                    <select class="form-control" name="hide">
                                                        <option value="0">Show</option>
                                                        <option value="1">Hide</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="col-md-6">
                                                <div class="input-group mb-3">
                                                    <label>Product Type</label>
                                                    <select class="form-control" name="product_type_id">
                                                        <c:forEach items="${allProductTypes}" var="pt">
                                                            <option value="${pt.id}">${pt.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="input-group mb-3">
                                            <button type="button" class="btn btn-sm btn-info" data-toggle="modal"
                                                    data-target="#modal-default">Choose Image
                                            </button>
                                            <input class="form-control" type="hidden" name="imageName" id="imageName">
                                        </div>

                                        <div class="input-group mb-3">
                                            <img height="150px" id="thumbImage" src="" alt="">
                                        </div>

                                        <!-- start media modal -->
                                        <div class="modal fade" id="modal-default">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h4 class="modal-title">All Media</h4>
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <c:forEach items="${allMedia}" var="media">
                                                                <div class="col-sm-2">
                                                                    <img class="img-thumbnail"
                                                                         src="http://localhost:8080/ecommerce/uploads/${media}"
                                                                         alt="${media}"
                                                                         onclick="selectImage('${media}')"
                                                                         data-dismiss="modal">
                                                                </div>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /.modal-content -->
                                            </div>
                                            <!-- /.modal-dialog -->
                                        </div>
                                        <!-- end medial modal -->

                                        <div class="row">
                                            <div class="col">
                                                <button type="submit" class="btn btn-primary">Create Product
                                                </button>
                                            </div>
                                            <!-- /.col -->
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /.form-box -->
                    </div><!-- /.card -->
                </div>
                <!-- /.register-box -->

            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <strong>Copyright &copy; 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong>
        All rights reserved.
        <div class="float-right d-none d-sm-inline-block">
            <b>Version</b> 3.0.2-pre
        </div>
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

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
<script>
    function selectImage(imageName) {
        document.forms['myForm'].imageName.value = imageName;
        document.getElementById("thumbImage").src = "http://localhost:8080/ecommerce/uploads/" + imageName;
    }
</script>
</body>
</html>
