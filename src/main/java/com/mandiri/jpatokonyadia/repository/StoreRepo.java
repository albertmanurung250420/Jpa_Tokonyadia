package com.mandiri.jpatokonyadia.repository;

import com.mandiri.jpatokonyadia.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<Store, String> {

    public Page<Store> findAllByNameContainingAndAddressContainingAndPhoneContaining(String name, String address, String phone, Pageable pageable);
}
