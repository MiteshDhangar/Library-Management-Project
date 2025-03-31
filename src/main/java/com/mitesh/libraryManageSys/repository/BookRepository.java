package com.mitesh.libraryManageSys.repository;

import com.mitesh.libraryManageSys.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
