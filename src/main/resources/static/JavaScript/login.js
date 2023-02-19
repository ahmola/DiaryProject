let index = {
    init:function(){
        $("#btn_login").on("click", ()=>{
            this.enter();
        })
    },

    enter:function(){
        let data={
            username:$("#user_id").val(),
            password:$("#user_pwd").val(),
        };

        $.ajax({
            type:"POST",
            url:"/login",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done((resp)=>{
            if(resp == 200){
                alert("로그인 성공!");
                // 본인 페이지로 이동
                localStorage.clear();
                localStorage.setItem("data", JSON.stringify(data));
                location.href = "/board";
            }
            else{
                alert("로그인 실패!");
            }
        }).fail((error)=>{
            alert(JSON.stringify(error));
        });
    }
}

index.init();