package cafeboard.Board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    BoardServicce boardServicce;

    //** 게시글 생성 api
    @PostMapping(" /api/posts/")
    void create(@RequestBody BoardRequest request){
        BoardServicce.save(request);
    }
}
