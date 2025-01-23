package cafeboard.Post;

import com.sun.jdi.InterfaceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
