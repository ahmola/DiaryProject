package com.example.demo.Controller;

import com.example.demo.DTO.ResponseBoardIdDTO;
import com.example.demo.DTO.ResponseUsernameDTO;
import com.example.demo.model.RoleType;
import com.example.demo.model.Summary;
import com.example.demo.model.board;
import com.example.demo.model.user;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.boardService;
import com.example.demo.service.userService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @Autowired
    private userService UserService;

    @Autowired
    private boardService BoardService;

    @PostMapping("/login")
    public int login(@RequestBody user login_user){
        System.out.println("login 요청 호출 : " + login_user);

        // db에서 회원정보가 있는지 확인한다.
        if(!UserService.findByUsername(login_user.getUsername()).isEmpty()){
            return HttpStatus.OK.value();
        }

        return HttpStatus.FORBIDDEN.value();
    }

    @PostMapping("/join/joinUs")
    public int join(@RequestBody @NotNull user join_user){
        System.out.println("join 요청 호출 : " + join_user);

        // db에서 중복검사 후 저장
        join_user.setRole(RoleType.User);
        int result = UserService.save(join_user);
        if(result == 1)
            return HttpStatus.OK.value();

        return HttpStatus.FORBIDDEN.value();
    }

    @PostMapping("/board/welcome")
    public ResponseUsernameDTO welcomeTitle(@RequestBody @NotNull String User){
        System.out.println("login 접속 완료 : " + User);

        // 유저 정보 반환
        user welcome_user = UserService.findByUsername(User).get(0);

        return new ResponseUsernameDTO(HttpStatus.OK.value(), welcome_user.getUsername());
    }

    @PostMapping("/posting/submit")
    public int submitPost(@RequestBody @NotNull Summary summary){
        System.out.println("Posting 요청 : " + summary.getTitle() + " " + summary.getWriter());

        int result = -1;
        user User = UserService.findByUsername(summary.getWriter()).get(0);
        if(User != null) {
            board Board = board.builder()
                    .writer(User)
                    .title(summary.getTitle())
                    .summary(summary.getSummary())
                    .build();
            result = BoardService.save(Board);
        }
        if(result == 1)
            return HttpStatus.OK.value();
        return HttpStatus.FORBIDDEN.value();
    }

    @PostMapping("/userPost/findBoard")
    public ResponseBoardIdDTO findBoard(@RequestBody @NotNull String boardId){
        System.out.println("findBoard 요청 : " + boardId);

        int id = Integer.parseInt(boardId);

        board userBoard = BoardService.findById(id).get(0);

        if(userBoard != null){
            return new ResponseBoardIdDTO(HttpStatus.OK.value(), userBoard.getTitle(), userBoard.getSummary());
        }

        return new ResponseBoardIdDTO(HttpStatus.FORBIDDEN.value(), userBoard.getTitle(), userBoard.getSummary());
    }
}
