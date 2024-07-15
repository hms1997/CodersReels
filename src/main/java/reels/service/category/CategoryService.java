package reels.service.category;

import reels.entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
    void deleteCategory(Long categoryId);
    List<Category> getUserCategories(Long userId);
    void addUserCategory(Long userId, Long categoryId);
    void removeUserCategory(Long userId, Long categoryId);
}
