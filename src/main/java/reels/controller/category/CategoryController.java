package reels.controller.category;

import reels.entities.Category;
import reels.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Category>> getUserCategories(@PathVariable Long userId) {
        List<Category> categories = categoryService.getUserCategories(userId);
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/user/{userId}/add/{categoryId}")
    public ResponseEntity<Void> addUserCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
        categoryService.addUserCategory(userId, categoryId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{userId}/remove/{categoryId}")
    public ResponseEntity<Void> removeUserCategory(@PathVariable Long userId, @PathVariable Long categoryId) {
        categoryService.removeUserCategory(userId, categoryId);
        return ResponseEntity.noContent().build();
    }
}
