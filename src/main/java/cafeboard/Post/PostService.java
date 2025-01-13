package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.Board.BoardResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public Board findBoardById(Long boardId){
        BoardResponse.findById(request.boardId(Board));
    }


    public void save(PostRequest request) {

        // BoardId로  board를먼저 찾는다.

        postRepository.save();//물론 잘못된코드겠지


    }

    public PostResponse findById(Long postId) {
        //**postid 에 해당하는 포스트 조회
//        Post post = postRepository . findById(postId).orElse(null);
//        //
//        if(post == null) {
//            return Optional.empty();
//        }
//            return new PostResponse(post.getId(), post.getName());
//        }
        return null;
    }
}



