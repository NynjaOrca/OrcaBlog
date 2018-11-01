package com.nynjaorca.orcablog.orcablog.repositories;

import com.nynjaorca.orcablog.orcablog.entities.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepo extends CrudRepository<Animal, Long>{

    List<Animal> findByCommonName(String commonName);
}
