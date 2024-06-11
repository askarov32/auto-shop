package spring.boot.auto_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.auto_shop.models.News;
import spring.boot.auto_shop.repository.NewsRepository;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
