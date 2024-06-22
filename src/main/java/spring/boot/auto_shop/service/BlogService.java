package spring.boot.auto_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.Blog;
import spring.boot.auto_shop.repository.BlogRepository;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(int id) {
        return blogRepository.findById(id).orElseThrow();
    }

    public List<Blog> findAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        for (Blog blog : blogs) {
            blog.getComments().size();         }
        return blogs;
    }
}
