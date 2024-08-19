package com.awesomepizza.api.repository;

import com.awesomepizza.api.entity.TB_STATUS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LookupRepository extends JpaRepository<TB_STATUS, Long> {
}
