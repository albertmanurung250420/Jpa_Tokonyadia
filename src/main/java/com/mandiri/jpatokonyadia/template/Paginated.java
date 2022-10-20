package com.mandiri.jpatokonyadia.template;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Paginated<T> {
    Page<T> findAll(Pageable pageable);
}
