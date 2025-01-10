package cafeboard.Board;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    //** 게시글 생성 api
    @PostMapping
    void create("/api/posts/"){}
}
