package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Board.BoardRepository;
import cafeboard.Board.BoardResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostService(PostRepository postRepository, BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }



    public void save(PostRequest request) {

        // BoardId로  board를먼저 찾는다.
        Board board = boardRepository.findById(request.boardId()).orElseThrow();

        postRepository.save(new Post(request.name(), board));


    }

    public PostResponse findById(Long postId) {
        //**postId 에 해당하는 포스트 조회
        Post post = postRepository . findById(postId).orElseThrow();

            return new PostResponse(post.getId(), post.getName());
     }
     //**리뷰조회 서비스 로직
     public List<PostResponse> findAll() {
        return List.of();

    }
}





