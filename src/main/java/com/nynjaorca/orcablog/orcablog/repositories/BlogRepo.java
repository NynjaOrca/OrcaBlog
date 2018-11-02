package com.nynjaorca.orcablog.orcablog.repositories;

import com.nynjaorca.orcablog.orcablog.entities.BlogPost;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepo extends CrudRepository<BlogPost, Long> {

}
