function getAllStu() {
    $.ajax({
            type:"GET",
            url:"/Admin/student_details",
            success:function success(){
                alert("查询所有学生成功");
            },
            error:function error(){
                alert("查询所有学生失败");
            }
        })
}