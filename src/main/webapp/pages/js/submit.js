function xsubmit() {
    var start = document.getElementById("start");
    var end = document.getElementById("end");
    if (start == null) {
        alert("start为空");
    }
    if (end == null) {
        alert("end为空");
    }
    $.ajax({
        type: "POST",
        url: "/input'",
        data: {
            start: start,
            end: end,
        },
        dataType: "json",
        success: function (data) {

        },
        error: function (jqXHR) {
            $("#test").html("发生错误:" + jqXHR.status);
        }
    });
}
