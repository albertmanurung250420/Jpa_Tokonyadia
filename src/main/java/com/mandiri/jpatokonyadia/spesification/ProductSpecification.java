package com.mandiri.jpatokonyadia.spesification;

import com.mandiri.jpatokonyadia.dto.ProductSearchCriteria;
import com.mandiri.jpatokonyadia.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification {
    public static Specification<Product> getSpecification(ProductSearchCriteria productSearchCriteria){
        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(productSearchCriteria.getName()!=null){
                    Predicate predicate = criteriaBuilder.like(root.get("name"),"%"+productSearchCriteria.getName()+"%");
                    predicates.add(predicate);
                }
                if(productSearchCriteria.getPrice()!=null){
                    Predicate predicate = criteriaBuilder.equal(root.get("price"),productSearchCriteria.getPrice());
                    predicates.add(predicate);
                }
                if(productSearchCriteria.getDescription()!=null){
                    Predicate predicate = criteriaBuilder.like(root.get("description"),"%"+productSearchCriteria.getDescription()+"%");
                    predicates.add(predicate);
                }
                if(productSearchCriteria.getStock()!=null){
                    Predicate predicate = criteriaBuilder.equal(root.get("stock"),productSearchCriteria.getStock());
                    predicates.add(predicate);
                }
                /*if (productSearchCriteria.getCreatedDate()!=null){
                    Predicate predicate = criteriaBuilder.like(root.get("createdDate"),"%"+productSearchCriteria.getCreatedDate()+"%");
                    predicates.add(predicate);
                }*/
                if(productSearchCriteria.getStartDate()!=null){
                    Predicate predicateStart = criteriaBuilder.greaterThan(root.get("createdDate"),productSearchCriteria.getStartDate());
                    predicates.add(predicateStart);
                }
                if(productSearchCriteria.getEndDate()!=null){
                    Predicate predicateEnd = criteriaBuilder.lessThan(root.get("createdDate"),productSearchCriteria.getEndDate());
                    predicates.add(predicateEnd);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
        return specification;
    }

}
