package com.mandiri.jpatokonyadia.template;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CRUDService<T,ID> extends Paginated<T>, GetResourceById<T>, CreateResource<T>, UpdateResource<T>, DeleteResource<ID> {
}
