package cafeboard.Comment;

import cafeboard.Post.Post;
import cafeboard.member.Member;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Post post;
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Comment(String name, Post post) {
        this.name = name;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Post getPost() {
        return post;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
