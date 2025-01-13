package cafeboard.Post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PostController {
    private PostService postService;

    //**게시글 생성 api
    @PostMapping("/api/posts")
    void create(@RequestBody PostRequest request) {
        postService.save(request);
    }

    //**게시글 상세조회 api
    @GetMapping()
    public PostResponse findById(@PathVariable Long PostId){
        return new PostResponse(
                1L,
                "Happy"

        );

    }

}

