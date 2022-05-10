package ru.haise.bootmvc.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.haise.bootmvc.entities.Product;

import java.math.BigDecimal;

public class ProductSpecification {
    public static Specification<Product> trueLiteral(){
        return (root, query, builder) -> builder.isTrue(builder.literal(true));
    }
    public static Specification<Product> titleLike(String titleFilter){
        return (root, query, builder) -> builder.like(root.get("title"), "%" + titleFilter + "%");
    }

    public static Specification<Product> greaterOrEquals(BigDecimal min){
        return (root, query, builder) -> builder.greaterThan(root.get("title"), min);
    }
    public static Specification<Product> lessOrEquals(BigDecimal max){
        return (root, query, builder) -> builder.lessThan(root.get("title"), max);
    }

}
