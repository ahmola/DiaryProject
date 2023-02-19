let userPost = {
    init:function(){
        let data = JSON.parse(localStorage.getItem("data"));
        let clicked = JSON.parse(localStorage.getItem("clickedBoard"));

        if(clicked != 0){
            $.ajax({
                type:"POST",
                url:"/userPost/findBoard",
                data:String(clicked),
                contentType:"application/json; charset=utf-8",
                dataType:"json"
            }).done((resp)=>{
                this.showBoard(resp);
            }).fail((error)=>{
                alert("해당 내용이 존재하지않습니다.");
                window.close();
            })
        }
        else{
            alert("clickedBoard Error!");
        }
    },

    showBoard:function(resp){
        console.log("Create Board");

        const title = document.getElementById("postTitle");
        //const img = getElementById("postImg");
        const summary = document.getElementById("postSummary");

        title.innerHTML = resp.title;

        summary.innerHTML = resp.summary;
    }
}

userPost.init();