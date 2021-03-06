package Repository;

/**
 * CRUD operations repository interface
 *
 */
public interface ICrudRepository<T> {
    /**
     * finds the entity with the give id from the repository list
     *
     * @param id -the id of the entity to be returned id must not be null
     * @return the entity with the specified id or null - if there is no entity with the given id
     */
    T findOne(Long id) ;

    /**
     * @return all entities
     */
    Iterable<T> findAll();

    /**
     * adds an entity in the repo list
     *
     * @param obj entity must be not null
     * @return null- if the given entity is saved otherwise returns the entity (id already exists)
     */
    T save(T obj);

    /**
     * updates an entity from the repo list
     *
     * @param obj entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    T update(T obj);

    /**
     * removes the entity with the specified id from the repo list
     *
     * @param id id must be not null
     * @return the removed entity or null if there is no entity with the given id*/
    T delete(Long id);
}


