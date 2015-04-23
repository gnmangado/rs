package net.dmslabs.re.persistence.dao.remote;

import java.util.List;

/**
 * @author gmangado Defines common interface for all DAO objects.
 * @param <T>
 *            This interface is parameterized to use generic type '@T' useful at
 *            compile time to determine the class of objects the instance will
 *            manage. This interface is meant to be used only if the underlying
 *            entity's primary key is mappable to 'Integer'.
 */
public interface CommonDao<T> {

    /**
     * Stores a new entity of class 'T' in the database.
     * @param e
     *            The instance to store.
     * @return Returns the id of the stored entity.
     * @throws DataManipulationUniqueConstraintException
     *             If we try to store an entity with an existing id.
     * @throws DataManipulationGenericException
     *             If any other error is caught.
     */
    public T store(T e);

    /**
     * Updates the corresponding records in the database.
     * @param e
     *            The instance to update.
     * @return Returns the id of the updated entity.
     * @throws DataManipulationGenericException
     *             If any error is caught.
     */
    public T update(T e);

    /**
     * Finds in the database and returns the entity with PK = id.
     * @param id
     *            The id to find.
     * @return The found entity.
     * @throws DataManipulationNoResultException
     *             If no result is found.
     * @throws DataManipulationGenericException
     *             If any other error is caught.
     */
    public T findById(Integer id);

    /**
     * Finds all the records of the given entity.
     * @return A list containing all the records of the given entity.
     */
    public List<T> findAll();
}
