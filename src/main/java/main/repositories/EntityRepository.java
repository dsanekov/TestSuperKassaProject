package main.repositories;

import main.model.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository<Entity,Integer> {
    Entity findById(int id);
}
