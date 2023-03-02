let userPost = {
    init:function(){
        let user = JSON.parse(localStorage.getItem("data"));
        let clicked = JSON.parse(localStorage.getItem("clickedBoard"));

        let data = {
            username:user.username,
            boardId:clicked
        }

        if(clicked != 0){
            $.ajax({
                type:"POST",
                url:"/userPost/findBoard",
                data:JSON.stringify(data),
                contentType:"application/json; charset=utf-8",
                dataType:"json"
            }).done((resp)=>{   // 유저가 쓴 글들을 10개의 리스트에 저장하여 2번째 그림 클릭 시에는 2번쩨 개시글이 나오도록 한다.
                if(resp.status == 200)
                    this.showBoard(resp);
                else{
                    alert("존재하는 글이 아닙니다.");
                    window.close();
                }
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

        title.innerHTML = resp.title + "<br><br>";

        for(var i = 0; i <= resp.summary.length/10; i++){
            var line = document.createElement("div");
            line.setAttribute("id", "line"+i);
            line.innerHTML = resp.summary.substr(i, i+10);
            summary.appendChild(line);
        }
    }
}

userPost.init();