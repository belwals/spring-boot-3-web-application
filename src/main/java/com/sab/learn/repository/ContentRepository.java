package com.sab.learn.repository;

import com.sab.learn.entity.Content;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository  extends ListCrudRepository<Content, Integer> {
}
