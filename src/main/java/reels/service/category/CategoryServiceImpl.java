package reels.service.category;

import reels.entities.Category;
import reels.entities.UserCategory;
import reels.repository.CategoryRepository;
import reels.repository.UserCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserCategoryRepository userCategoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> getUserCategories(Long userId) {
        return userCategoryRepository.findAll().stream()
                .filter(userCategory -> userCategory.getUserId().equals(userId))
                .map(userCategory -> categoryRepository.findById(userCategory.getCategoryId()).orElse(null))
                .collect(Collectors.toList());
    }

    @Override
    public void addUserCategory(Long userId, Long categoryId) {
        UserCategory userCategory = new UserCategory();
        userCategory.setUserId(userId);
        userCategory.setCategoryId(categoryId);
        userCategoryRepository.save(userCategory);
    }

    @Override
    public void removeUserCategory(Long userId, Long categoryId) {
        userCategoryRepository.findAll().stream()
                .filter(uc -> uc.getUserId().equals(userId) && uc.getCategoryId().equals(categoryId))
                .findFirst().ifPresent(userCategory -> userCategoryRepository.delete(userCategory));
    }
}
