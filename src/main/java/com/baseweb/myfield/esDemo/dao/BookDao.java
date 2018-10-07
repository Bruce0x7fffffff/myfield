package com.baseweb.myfield.esDemo.dao;

import com.baseweb.myfield.esDemo.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookDao extends ElasticsearchRepository<Book,String> {
}
