package fr.maboite.demo.spring.boot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleDao extends CrudRepository<Example, Long>  {

    List<Example> findByName(String name);
	
}