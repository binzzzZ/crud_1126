<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="/static/js/jquery-3.3.1.js" type="text/javascript"></script>
</head>
<script>

    $(function () {

        $.ajax({
            url: "/province",
            type: "get",
            data: "",
            //text
            dataType: "json",
            success: function (data) {
                var html = '<option value="-1">请选择</option>';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $("#province").append(html);
            }

        });

        $("#province").change(function () {
            var id = $("#province option:selected").val();
            if (id == -1) {
                $("#city").empty();
                $("#district").empty();
                return;
            }

            $.ajax({
                url: "/city",
                type: "get",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    $("#city").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#city").append(html);
                }
            });
        });

        $("#city").change(function () {
            var id = $("#city option:selected").val();
            if (id == -1) {
                $("#district").empty();
                return;
            }

            $.ajax({
                url: "/district",
                type: "get",
                data: {id: id},
                dataType: "json",
                success: function (data) {
                    $("#district").empty();
                    var html = '<option value="-1">请选择</option>';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                    }
                    $("#district").append(html);
                }
            });
        });
    });

</script>

<body>

请选择省份：
<select id="province">

</select>
<br>

请选择市：
<select id="city">

</select>
<br>

请选择区：
<select id="district">

</select>
</body>
</html>
