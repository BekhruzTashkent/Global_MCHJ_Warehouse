package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CategoryRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.Optional;

@Service
public class CategoryService {   //we need this class to have clear vision, and moreover we can use this piese of code
//everywhere in code
  @Autowired
  CategoryRepository categoryRepository;

  public Result addCategory(CategoryDto categoryDto) {

    Category category = new Category();
    category.setName(categoryDto.getName());
    if(categoryDto.getParentCategoryId() != null){
      Optional<Category> optionaParentlCategory = categoryRepository.findById(categoryDto.getParentCategoryId());

      if(!optionaParentlCategory.isPresent())
        return new Result("there no such kategory", false);
      category.setParentCategory(optionaParentlCategory.get());
    }
    categoryRepository.save(category);
    return new Result("successfully added", true);
  }

}
