package spring.boot.auto_shop.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.Blog;
import spring.boot.auto_shop.models.Comment;
import spring.boot.auto_shop.repository.BlogRepository;
import spring.boot.auto_shop.repository.CommentRepository;

@Service
@AllArgsConstructor
public class CommentService {
    private BlogRepository blogRepository;
    private CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Transactional
    public void addComment(Comment comment, Integer blogId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new RuntimeException("Blog not found!"));
        comment.setBlog(blog);
        commentRepository.save(comment);
    }
}
