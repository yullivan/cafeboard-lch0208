package cafeboard.Board;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {


    private final BoardRepository boardRepository;

    public  void save(BoardRequest request) {

        BoardRepository boardRepository;

    }
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
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

}
