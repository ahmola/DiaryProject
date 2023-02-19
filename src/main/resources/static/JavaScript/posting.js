let posting = {
    init:function(){
        $("#post_button").on("click", ()=>{
              this.submit();
        })
    },

    submit:function(){
        let content = {
            writer:String(JSON.parse(localStorage.getItem("data")).username),
            title:$("#title").val(),
            summary:$("#summary").val(),
        };

        $.ajax({
            type:"POST",
            url:"/posting/submit",
            dataType:"json",
            contentType:"application/json; charset=utf-8",
            data:JSON.stringify(content)
        }).done((resp)=>{
            alert("저장됐어요.");
            location.href = "/board";
        }).fail((error)=>{
            alert(error);
        })
    }
}

posting.init();