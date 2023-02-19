let board = {
    init:function(){
        let data = JSON.parse(localStorage.getItem("data"));
        // console.log(data);
        $.ajax({
            type:"POST",
            url:"/board/welcome",
            data:String(data.username),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done((resp)=>{
            // 유저 페이지 생성
            this.userPage(resp);

            // 유저의 이미지들을 가져와서 띄움(prototype)
            this.userImage();

        }).fail((error)=>{
            alert("뭔가 이상합니다...");
            this.linkHome();
        })
    },

    linkHome:function(){
        location.href = "/";
    },

    userPage:function(resp){
            const title = document.getElementById("board_title");
            const head = document.getElementById("board_head");
            const svg = document.getElementById("main_svg");

            // 페이지 제목 설정
            title.innerHTML = "Hi! " + resp.username;

            // 제목 생성
            head.innerHTML = resp.username + "'s Photo";

            // 이모티콘 클릭 시 메인 화면으로 이동
            svg.addEventListener("click", ()=>{
                this.linkHome();
            })

            $("#writing_button").on("click", ()=>{
                location.href = "/posting";
            })
    },

    userImage:function(){
        const post = document.getElementById("posts");
        const user = JSON.parse(localStorage.getItem("data")).username;
        for(var i = 0; i < 10; i++){
            var img = document.createElement("img");
            img.setAttribute("class", "post");
            img.setAttribute("id", "post");
            img.setAttribute("src", "https://picsum.photos/200/200");
            img.setAttribute("alt", "Post Image");
            img.setAttribute("onclick", "javascript:window.open('userPost', 'userPost' ,'top=100, left=500, width=500, height=600, status=no, toolbar=no'); localStorage.setItem('clickedBoard', " + (i+1) + ");");
            // localStorage.setItem("board"+(i+1), JSON.stringify(i+1));
            img.setAttribute("style", "cursor:pointer;");
            post.appendChild(img);
        }
    }
}

board.init();