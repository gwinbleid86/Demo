package com.example.demo.controller;

import com.example.demo.services.ArticleService;
import com.example.demo.util.Constants;
import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@AllArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/main")
    public String listOfArticles(
            Model model,
            @PageableDefault(sort = "date", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        model.addAttribute("articles", articleService.getAllArticles(pageable));
        model.addAttribute("url", "/main");

        return "articles";
    }

    @GetMapping("/{id}")
    public String getSingleArticle(Model model, @PathVariable("id") int id) {
        model.addAttribute("article", articleService.getArticleById(id).get());
        System.out.println(Constants.IMAGE_URL + "img_not_available.png");
        model.addAttribute("imageUrl", Constants.IMAGE_URL + articleService.getArticleById(id).get().getImage());
        model.addAttribute("noImage", Constants.IMAGE_URL + "img_not_available.png");
        return "article";
    }

    @GetMapping("/create")
    public String createNewArticle(Model model) {
        return "createArticle";
    }

    @PostMapping("/create")
    public String addNewArticle(Model model) {
        return "createArticle";
    }
}
