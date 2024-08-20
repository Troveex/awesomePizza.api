package com.awesomepizza.api.repository;

import com.awesomepizza.api.entity.TB_ORDER;
import com.awesomepizza.api.entity.TB_STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<TB_STATUS, Long> {

    Optional<TB_STATUS> findByCode(String statusCode);
}
