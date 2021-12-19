package com.example.book.repository;

import com.example.book.entity.NXB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NXBRepository extends JpaRepository<NXB,Long> {
}
