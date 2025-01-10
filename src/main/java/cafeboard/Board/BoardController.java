package cafeboard.Board;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
