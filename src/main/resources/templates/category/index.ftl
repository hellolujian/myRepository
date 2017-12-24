<html>
<head>
    <meta charset="utf-8">
    <title>卖家类目页面</title>
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
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <div class="form-group">
                            <label>名字</label>
                            <input name="categoryName" type="text" class="form-control" value="${(productCategory.getCategoryName())!""}" />
                        </div>

                        <div class="form-group">
                            <label>type</label>
                            <input name="categoryType" type="number" class="form-control" value="${(productCategory.getCategoryType())!""}" />
                        </div>

                        <input hidden type="text" name="categoryId" value="${(productCategory.getCategoryId())!""}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>