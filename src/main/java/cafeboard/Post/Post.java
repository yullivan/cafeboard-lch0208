package cafeboard.Post;

import cafeboard.Board.Board;
import cafeboard.member.Member;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToOne
    private Member member;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Board board;
    private

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Post( String name, Board board) {

        this.name = name;
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public String getName() {return name;
    }

    public Board getBoard() {
        return board;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
