package ru.haise.bootmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.haise.bootmvc.entities.Product;
import ru.haise.bootmvc.repositories.ProductRepository;
import ru.haise.bootmvc.repositories.specifications.ProductSpecification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Transactional
    public Product getById(Long id){
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElseGet(Product::new);
    }
    @Transactional
    public void remove(Long id){
        productRepository.deleteById(id);
    }
    @Transactional
    public void addOrUpdate(Product product)
    {
        productRepository.save(product);
    }

    @Transactional
    public List<Product> getByParams(Optional<String> nameFilter,
                                     Optional<BigDecimal> min,
                                     Optional<BigDecimal> max)
    {
//        String newNameFilter = "";
//        if (!nameFilter.contains("%")){
//             newNameFilter = String.join("", "%", nameFilter, "%");
//        }
//        return productRepository.findProductByTitleLike(newNameFilter);

        Specification<Product> specification = Specification.where(null);
        if(nameFilter.isPresent()){
            specification = specification.and(ProductSpecification.titleLike(nameFilter.get()));
        }
        if(min.isPresent()){
            specification = specification.and(ProductSpecification.greaterOrEquals(min.get()));
        }
        if(max.isPresent()){
            specification = specification.and(ProductSpecification.lessOrEquals(max.get()));
        }
        return productRepository.findAll(specification);
    }

}
