$(function () {
    $("#username").blur(function () {
        var name = $("#username").val();
        console.log(name);
        $.get("/user/findByName",{username: name},function (data) {
            if (data){
                console.log(data);
                $("#err").html("用户名已存在");
                $("#saveBtn").attr('disabled',true);
            }else {
                $("#err").html("用户名可用");
                $("#saveBtn"),attr('disabled',false);
            }
        });
    });
})