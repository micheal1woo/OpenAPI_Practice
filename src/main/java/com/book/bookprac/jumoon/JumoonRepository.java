package com.book.bookprac.jumoon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JumoonRepository extends JpaRepository<Jumoon, Long> {

}
