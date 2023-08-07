

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/dropdown.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet">
        

  </head>
  <body>
	  
<!------ Include the above in your HEAD tag ---------->

<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                Walmart Inventory Management System</a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
                </a>
            </li>            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.uName}<b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">

                    <li><a href="logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
                        <ul class="nav navbar-nav side-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-user-plus"></i>Administration  <b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">

                            <li><a class = "dropdown-item" href="adduser"><i class="fa fa-fw fa-user-plus"></i>Add User</a>
                            </li>
                            <li><a class = "dropdown-item" href="deleteuser"><i class="fa fa-fw fa-user-plus"></i>Delete User</a>
                            </li>
                            <li><a class = "dropdown-item" href="listuser"><i class="fa fa-fw fa-user-plus"></i>User's List</a></li>
                        </ul>
                </li>
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-user-plus"></i>Customers<b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">
                            <li><a class = "dropdown-item" href="addcustomer"><i class="fa fa-fw fa-user-plus"></i>Add Customer</a></li>
                            <li><a class = "dropdown-item" href="deletecustomer"><i class="fa fa-fw fa-user-plus"></i>Delete Customer</a></li>
                            <li><a class = "dropdown-item" href="listcustomer"><i class="fa fa-fw fa-user-plus"></i>Customer List</a></li>
                        </ul>
                </li>
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-user-plus"></i>Products<b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">
                            <li><a class = "dropdown-item" href="addproduct"><i class="fa fa-fw fa-user-plus"></i>Add Product</a></li>
                            <li><a class = "dropdown-item" href="listproduct"><i class="fa fa-fw fa-user-plus"></i>Product List</a></li>
                            <li><a class = "dropdown-item" href="transferitem"><i class="fa fa-fw fa-user-plus"></i>Transfer Product</a></li>
                            <li><a class = "dropdown-item" href="revokeproduct"><i class="fa fa-fw fa fa-question-circle"></i>Product Revoke</a></li>
                        </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-user-plus"></i>Transactions<b class="fa fa-angle-down"></b></a>
                        <ul class="dropdown-menu">
                            <li><a class = "dropdown-item" href="purchase"><i class="fa fa-fw fa-user-plus"></i>Purchase/Order Product</a></li>
                            <li><a class = "dropdown-item" href="sales"><i class="fa fa-fw fa-user-plus"></i>Sales</a></li>
                        </ul>
                </li>
                <li>
                    <a href="payment"><i class="fa fa-fw fa fa-question-circle"></i> Payment Process</a>
                </li>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content">
                        <div id="formContent">
                    <!-- Tabs Titles -->

                    <!-- Icon -->
                        <div id="formHeader">
                           
                            Enter the product details
                            
                            
                        </div>
                            

                        <form:form id="regForm" modelAttribute="product" action="processProduct" method="POST">
                            <form:input path="productId" class="fadeIn second" placeholder="Product Id" name="productId"/>
                            <form:input path="productName" class="fadeIn second" placeholder="Product Name" name="productName"/>
                            <form:input path="quantity" class="fadeIn second" placeholder="Quantity" name="quantity"/>
                            <form:input path="sellingPrice" class="fadeIn second" placeholder="Selling Price" name="sellingPrice"/>
                            <form:input path="costPrice" class="fadeIn second" placeholder="Cost Price" name="costPrice"/><br>
                            <form:button id="register" class="fadeIn fourth" name="register">Add product</form:button>
                        </form:form>
                        <div id="formFooter">
                            ${message}
                        </div>
                        
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->
  </body>
</html>
    
                
