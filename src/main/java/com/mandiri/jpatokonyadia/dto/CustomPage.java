package com.mandiri.jpatokonyadia.dto;

import com.mandiri.jpatokonyadia.entity.Store;
import org.springframework.data.domain.Page;

import java.util.List;

public class CustomPage<T> {

    private List<T> content;
    private Integer page;
    private Integer size;
    private Integer totalPage;
    private Long totalElement;

    public CustomPage(List<T> content, Integer page, Integer size, Integer totalPage, Long totalElement) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
        this.totalElement = totalElement;
    }

    public CustomPage(List<Store> content, int pageNumber, int totalPages, long totalElements) {

    }

    public CustomPage(Page<T> storePage) {
        this.content = storePage.getContent();
        this.page = storePage.getPageable().getPageNumber();
        this.size = storePage.getPageable().getPageSize();
        this.totalPage = storePage.getTotalPages();
        this.totalElement = storePage.getTotalElements();
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(Long totalElement) {
        this.totalElement = totalElement;
    }
}
