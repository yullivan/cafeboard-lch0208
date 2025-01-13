package cafeboard.Board;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {


    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public  void save(BoardRequest request) {

        boardRepository.save(new Board(request.name()));

    }

    public List<BoardResponse> findAll(){
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> new BoardResponse(
                        board.getId(),
                        board.getName()
                ))
                .toList();
    }

    @Transactional
    public void update(Long id, BoardRequest request) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.update(request.name());
    }
}
