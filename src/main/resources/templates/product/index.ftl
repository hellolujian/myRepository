<html>
<head>
    <meta charset="utf-8">
    <title>卖家首页</title>
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
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="productName" type="text" class="form-control" value="${(productInfo.getProductName())!""}" />
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" type="text" class="form-control" value="${(productInfo.getProductPrice())!""}" />
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" type="number" class="form-control" value="${(productInfo.getProductStock())!""}" />
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" type="text" class="form-control" value="${(productInfo.getProductDescription())!""}" />
                        </div>
                        <div class="form-group">
                            <img height="100" width="100" src="${(productInfo.getProductIcon())!""}" alt="">
                            <label>图片</label>
                            <input name="productIcon" type="text" class="form-control" value="${(productInfo.getProductIcon())!""}" />
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.getCategoryType()}"
                                            <#if (productInfo.getCategoryType())??&&productInfo.getCategoryType()==category.getCategoryType()>
                                                selected
                                            </#if>
                                    >
                                        ${category.getCategoryName()}
                                    </option>
                                </#list>
                            </select>
                            </div>
                        <input hidden type="text" name="productId" value="${(productInfo.getProductId())!""}">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>