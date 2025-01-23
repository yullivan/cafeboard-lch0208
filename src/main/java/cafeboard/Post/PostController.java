package cafeboard.Post;

import cafeboard.member.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PostController {
    private PostService postService;
    public Member member;
    private AuthorizationHeader authorizationHeader;


    public PostController(PostService postService, Member member,AuthorizationHeader authorizationHeader) {
        this.postService = postService;
        this. member = member;
        this.authorizationHeader = authorizationHeader;
    }

    //**게시글 생성 api,로그인한 사용자 검증하기
    @PostMapping("/api/posts")
    //Member 오브젝트에 값생성 시키고 주입받은 토큰 검증시켜야됨
    void create(@RequestBody PostRequest request, @RequestHeader(HttpHeaders.AUTHORIZATION)String) {
        String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : authorizationHeader;





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


    private class AuthorizationHeader {
        public boolean startsWith(String bearer) {
            return false;

        }

        public String substring(int i) {

            return null;
        }
    }


    //**게시글삭제
}

