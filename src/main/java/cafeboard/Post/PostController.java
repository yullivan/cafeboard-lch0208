package cafeboard.Post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //**게시글 생성 api
    @PostMapping("/api/posts")
    void create(@RequestBody PostRequest request) {
        postService.save(request);
    }

    //**게시글 상세조회 api
    @GetMapping("/api/posts")
    public PostResponse findById(@PathVariable Long PostId){
        return new PostResponse(
                1L,
                "Happy"

        );


    }

    //**게시글 목록조회 api
    @GetMapping("/api/posts/{id}")
    public List<PostResponse>read(){
        return postService.findAll();
    }


}

