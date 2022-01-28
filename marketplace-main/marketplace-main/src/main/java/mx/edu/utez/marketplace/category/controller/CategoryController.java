package mx.edu.utez.marketplace.category.controller;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = {"*"})
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("*/all")
    public ResponseEntity<Message>getAll(){
        return categoryService.findAll();
    }

    @GetMapping("*/{id}")
    public ResponseEntity<Message>getById(@PathVariable("id") long id){
        return categoryService.findById(id);
    }

    @PostMapping("*/save")
    public ResponseEntity<Message> saveCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(new Category(categoryDTO.getDescription()));
    }

    @PutMapping("*/update")
    public ResponseEntity<Message> updateCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.update(new Category(categoryDTO.getId(),categoryDTO.getDescription()));

    }


}
