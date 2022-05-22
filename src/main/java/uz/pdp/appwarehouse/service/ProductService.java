package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Attachment;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.AttachmentRepository;
import uz.pdp.appwarehouse.repository.CategoryRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;
import uz.pdp.appwarehouse.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addProduct(ProductDto productDto){

        //check name
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if(existsByNameAndCategoryId) {
            return new Result("There such product", false);
        }
        //chech kategory
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent())
            return new Result("There such category", false);

        //check photo
        Optional<Attachment> attachmentRepositoryByIdPhoto = attachmentRepository.findById(productDto.getPhotoId());
        if (!attachmentRepositoryByIdPhoto.isPresent())
            return new Result("There such photo", false);

        Optional<Measurement> measurementRepositoryById = measurementRepository.findById(productDto.getMeasurementId());
        if(!measurementRepositoryById.isPresent())
            return new Result("there no such measurement" , false);

        //saving
        Product product = new Product();
        product.setName(product.getName());
        product.setCode("1");
        product.setPhoto(attachmentRepositoryByIdPhoto.get());
        product.setCategory(optionalCategory.get());
        product.setMeasurement(measurementRepositoryById.get());
        productRepository.save(product);
        return new Result("Saved sucessfully", true);

    }

}
