let join={
    init:function(){
        $("#btn_join").on('click', ()=>{
            this.save();
        })
    },

    save:function(){
        let data = {
            username:$("#user_name").val(),
            password:$("#user_pwd").val(),
            email:$("#user_email").val()
        };

        $.ajax({
            type:"POST",
            url:"/join/joinUs",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done((resp)=>{
            console.log(resp);
            if(resp == 200){
                alert("회원가입 성공");
                console.log(resp);
                location.href = "/";
            }
            else{
                alert("회원가입 실패! 이미 존재하는 비밀번호 입니다!");
                console.log(resp);
                location.href = "/join";
            }
        }).fail((error)=>{
            alert(JSON.stringify(error));
        });
    }
}

join.init();