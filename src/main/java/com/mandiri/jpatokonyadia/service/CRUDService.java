package com.mandiri.jpatokonyadia.service;

import com.mandiri.jpatokonyadia.dto.ProductSearchCriteria;
import com.mandiri.jpatokonyadia.entity.Customer;
import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.template.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface CRUDService<T,ID>  extends Paginated<T>, GetResourceById<T>, CreateResource<T>, UpdateResource<T>, DeleteResource<ID> {
    Page<Product> findAll(Pageable pageable, ProductSearchCriteria productSearchCriteria);
}
