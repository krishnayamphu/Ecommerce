<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 3 | Product Details</title>
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

            <!-- Default box -->
            <div class="card card-solid">
                <div class="card-body">
                    <form action="shopping-cart" method="post">
                        <C:forEach items="${singleProduct}" var="product">
                            <input type="hidden" name="cid" value="1">
                            <input type="hidden" name="pid" value="${product.id}">
                            <div class="row">
                                <div class="col-12 col-sm-6">
                                    <h3 class="d-inline-block d-sm-none">${product.name}</h3>
                                    <div class="col-12">
                                        <img src="http://localhost:8080/ecommerce/uploads/${product.image}"
                                             class="product-image" alt="${product.image}">
                                    </div>
                                </div>
                                <div class="col-12 col-sm-6">
                                    <h3 class="my-3">${product.name}</h3>
                                    <p>${product.shortDescription}</p>

                                    <hr>
                                    <h4>Available Colors</h4>
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-default text-center active">
                                            <input type="radio" name="color_option" id="color_option1" autocomplete="off"
                                                   checked="">
                                                ${product.color}
                                            <br>
                                            <i class="fas fa-circle fa-2x" style="color:${product.color}"></i>
                                        </label>
                                    </div>

                                    <h4 class="mt-3">Size
                                        <small>Please select one</small>
                                    </h4>
                                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                        <label class="btn btn-default text-center">
                                            <input type="radio" name="color_option" id="color_option1" autocomplete="off">
                                            <span class="text-xl">S</span>
                                            <br>
                                            Small
                                        </label>
                                        <label class="btn btn-default text-center">
                                            <input type="radio" name="color_option" id="color_option1" autocomplete="off">
                                            <span class="text-xl">M</span>
                                            <br>
                                            Medium
                                        </label>
                                        <label class="btn btn-default text-center">
                                            <input type="radio" name="color_option" id="color_option1" autocomplete="off">
                                            <span class="text-xl">L</span>
                                            <br>
                                            Large
                                        </label>
                                        <label class="btn btn-default text-center">
                                            <input type="radio" name="color_option" id="color_option1" autocomplete="off">
                                            <span class="text-xl">XL</span>
                                            <br>
                                            Xtra-Large
                                        </label>
                                    </div>

                                    <div class="bg-gray py-2 px-3 mt-4">
                                        <h2 class="mb-0">
                                            $${product.mrpPrice}
                                        </h2>
                                    </div>

                                    <div class="mt-4">
                                        <button type="submit" class="btn btn-primary btn-lg btn-flat">
                                            <i class="fas fa-cart-plus fa-lg mr-2"></i>
                                            Add to Cart
                                        </button>
                                    </div>

                                    <div class="mt-4 product-share">
                                        <a href="#" class="text-gray">
                                            <i class="fab fa-facebook-square fa-2x"></i>
                                        </a>
                                        <a href="#" class="text-gray">
                                            <i class="fab fa-twitter-square fa-2x"></i>
                                        </a>
                                        <a href="#" class="text-gray">
                                            <i class="fas fa-envelope-square fa-2x"></i>
                                        </a>
                                        <a href="#" class="text-gray">
                                            <i class="fas fa-rss-square fa-2x"></i>
                                        </a>
                                    </div>

                                </div>
                            </div>
                            <div class="row mt-4">
                                <nav class="w-100">
                                    <div class="nav nav-tabs" id="product-tab" role="tablist">
                                        <a class="nav-item nav-link active" id="product-desc-tab" data-toggle="tab"
                                           href="#product-desc" role="tab" aria-controls="product-desc"
                                           aria-selected="true">Description</a>
                                        <a class="nav-item nav-link" id="product-comments-tab" data-toggle="tab"
                                           href="#product-comments" role="tab" aria-controls="product-comments"
                                           aria-selected="false">Comments</a>
                                        <a class="nav-item nav-link" id="product-rating-tab" data-toggle="tab"
                                           href="#product-rating" role="tab" aria-controls="product-rating"
                                           aria-selected="false">Rating</a>
                                    </div>
                                </nav>
                                <div class="tab-content p-3" id="nav-tabContent">
                                    <div class="tab-pane fade show active" id="product-desc" role="tabpanel"
                                         aria-labelledby="product-desc-tab">${product.longDescription}</div>
                                    <div class="tab-pane fade" id="product-comments" role="tabpanel"
                                         aria-labelledby="product-comments-tab"> Vivamus rhoncus nisl sed venenatis luctus.
                                        Sed condimentum risus ut tortor feugiat laoreet.
                                    </div>
                                    <div class="tab-pane fade" id="product-rating" role="tabpanel"
                                         aria-labelledby="product-rating-tab"> Cras ut ipsum ornare, aliquam ipsum non,
                                        posuere elit. In hac habitasse platea dictumst.
                                    </div>
                                </div>
                            </div>
                        </C:forEach>
                    </form>
                </div>
                <!-- /.card-body -->
            </div>
            <!-- /.card -->

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
