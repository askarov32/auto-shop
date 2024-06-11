package spring.boot.auto_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.News;
import spring.boot.auto_shop.repository.BlogRepository;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<News> getAllNews() {
        return blogRepository.findAll();
    }

    public News getBlogById(int id) {
        return blogRepository.findById(id).orElseThrow();
    }
}