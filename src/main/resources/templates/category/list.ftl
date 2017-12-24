<html>
    <head>
        <meta charset="utf-8">
        <title>卖家商品类目列表</title>
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
                                <th>类目id</th>
                                <th>名字</th>
                                <th>type</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list categoryList as category >
                            <tr>
                                <td>${category.getCategoryId()}</td>
                                <td>${category.getCategoryName()}</td>
                                <td>${category.getCategoryType()}</td>
                                <td>${category.getCreateTime()}</td>
                                <td>${category.getUpdateTime()}</td>

                                <td><a href="/sell/seller/category/index?categoryId=${category.getCategoryId()}">修改</a></td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </body>
</html>