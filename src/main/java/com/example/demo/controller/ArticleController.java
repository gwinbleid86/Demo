package com.example.demo.controller;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.dto.CreateArticleDTO;
import com.example.demo.services.ArticleService;
import com.example.demo.services.CategoryService;
import com.example.demo.util.Constants;
import com.example.demo.util.FileAction;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@AllArgsConstructor
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

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
        var article = articleService.getArticleById(id).get();
        model.addAttribute("article", article);
        model.addAttribute("category", categoryService.findById(article.getCategoryId()).get());
        if (article.getImageName() != null) model.addAttribute("imgAsBase64", FileAction.viewFile(articleService.getArticleById(id).get().getImageName()));
        model.addAttribute("noImage", Constants.IMAGE_URL + "img_not_available.png");
        return "article";
    }


    @GetMapping("/create")
    public String createNewArticle(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "createArticle";
    }

    @PostMapping("/create")
    public String addNewArticle(CreateArticleDTO dto) {
//        if (!dto.getImage().isEmpty()) {
            articleService.saveArticle(dto);
//        }
        return "redirect:/articles/create";
    }

    @GetMapping("/{id}/edit")
    public String editArticle(Model model, @PathVariable("id") int id) {
        model.addAttribute("article", articleService.getArticleById(id).get());
        model.addAttribute("noImage", Constants.IMAGE_URL + "img_not_available.png");
        model.addAttribute("categories", categoryService.getAll());
        return "editArticle";
    }

    @PostMapping("/{id}/edit")
    public String editArticle(CreateArticleDTO dto, @PathVariable("id") int id) {
        articleService.updateArticle(dto, id);
        return "redirect:/articles/main";
    }
}
