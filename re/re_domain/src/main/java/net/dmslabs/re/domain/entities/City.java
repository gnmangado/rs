package net.dmslabs.re.domain.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import net.dmslabs.re.domain.common.BaseIntegerIdentificableEntity;

/**
 * 
 * @author gmangado
 */
@Entity
@Table(name = "city")
@NamedQueries({ @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c") })
public class City implements Serializable, BaseIntegerIdentificableEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;

    @JoinColumn(name = "state_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private State stateId;

    public City() {
        enabled = true;
    }

    public City(Integer id) {
        this.id = id;
        enabled = true;
    }

    public City(Integer id, String name, boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
        enabled = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        } else if (this.id == null && other.id == null) {
            return this == other;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.City[ id=" + id + " ]";
    }

}
