package spring.boot.auto_shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.boot.auto_shop.models.Comment;
import spring.boot.auto_shop.repository.CommentRepository;
import spring.boot.auto_shop.service.BlogService;
import spring.boot.auto_shop.service.CommentService;

@Controller
@AllArgsConstructor
public class CommentController {
    private CommentRepository commentRepository;
    private BlogService blogService;
    private CommentService commentService;

    @Transactional
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/blog-info/{blogId}/add-comment")
    public String addComment(@PathVariable Integer blogId, @ModelAttribute Comment comment, Model model, RedirectAttributes redirectAttributes) {
        try {
            commentService.addComment(comment, blogId);
            redirectAttributes.addFlashAttribute("success", "Comment");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при добавлении комментария: " + e.getMessage());
        }
        System.out.println(blogId);
        return "redirect:/blog-info?id=" + blogId;
    }

}

