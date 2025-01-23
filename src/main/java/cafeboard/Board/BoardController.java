package cafeboard.Board;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //** 게시글 생성 api
    @PostMapping("/api/boards")
    void create(@RequestBody BoardRequest request){
        boardService.save(request);
    }
    //** 목록조회 api
    @GetMapping("/api/boards")
    List<BoardResponse> read(){
        return boardService.findAll();

    }
    //** 수정 api
    @PostMapping("api/boards/{id}")
    void update(@PathVariable Long id,@RequestBody BoardRequest request ){
        boardService.update(id,request);

    }
}
