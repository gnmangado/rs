package net.dmslabs.re.domain.common;

/**
 * Interface intended to be implemented by all entities mapped to Integer id. It
 * makes it possible to implement an abstract JPA DAO implementation for all the
 * entities implementing this interface.
 * 
 * @author gmangado
 * 
 */
public interface BaseIntegerIdentificableEntity {

    /**
     * Main method used by the abstract DAO.
     * 
     * @return The Integer id of the entity.
     */
    public Integer getId();
}
