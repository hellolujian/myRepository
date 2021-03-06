<html>
<head>
    <meta charset="utf-8">
    <title>订单详情</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">
</head>
<body>
    <div id="wrapper" class="toggled">
        <#include "../common/nav.ftl">
        <div id="page-content-wrapper">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>订单总金额</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>${orderDTO.getOrderId()}</td>
                                <td>${orderDTO.getOrderAmount()}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>商品名称</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>总额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTO.getOrderDetailList() as orderDetail>
                            <tr>
                                <td>${orderDetail.getProductId()}</td>
                                <td>${orderDetail.getProductName()}</td>
                                <td>${orderDetail.getProductPrice()}</td>
                                <td>${orderDetail.getProductQuantity()}</td>
                                <td>${orderDetail.getProductQuantity()*orderDetail.getProductPrice()}</td>
                            </tr>
                            </#list>

                            </tbody>
                        </table>
                    </div>
                <#if orderDTO.getOrderStatusEnum().getMessage()=="新订单">
                    <div class="col-md-12 column">
                        <a href="/sell/seller/order/finish?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-primary">完结订单</a>
                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-danger">取消订单</a>
                    </div>
                </#if>


                </div>
            </div>
        </div>
    </div>

</body>