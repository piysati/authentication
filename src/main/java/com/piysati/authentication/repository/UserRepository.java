package com.piysati.authentication.repository;

import com.piysati.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Short> {
    /**
     * By default basic CRUD operations
        Saves or updates the given entity : savsave(S entity)
        Saves all entities in the given iterable: saveAll(Iterable<S> entities)
        Retrieves an entity by its primary key (ID): findById(ID id)
        Retrieves all entities: findAll()
        Retrieves all entities with the given IDs: findAllById(Iterable<ID> ids)
        Returns the number of entities in the database: count()
        Checks if an entity exists by its ID: existsById(ID id)
        Deletes the entity with the given ID: deleteById(ID id)
        Deletes the provided entity: delete(T entity)
        Deletes all entities: deleteAll()
        Deletes all entities with the given IDs: deleteAllById(Iterable<? extends ID> ids)
        Retrieves all entities with sorting: findAll(Sort sort)
        Retrieves entities in a paginated format: findAll(Pageable pageable)
**/
// list of custom operation with flexible return types/

    List<User> findByName(String name);

    Optional<User> findByEmail(String email);

    Optional<User> findByNameAndEmail(String name, String email);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmailCustom(String email);

}
