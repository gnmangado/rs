package net.dmslabs.re.domain.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author gmangado
 */
@Entity
@Table(name = "currency")
@NamedQueries({ @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c") })
public class Currency implements Serializable {
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
    @Column(name = "symbol")
    private String symbol;

    @Basic(optional = false)
    @Column(name = "enabled")
    private String enabled;

    public Currency() {
        super();
    }

    public Currency(Integer id) {
        this.id = id;
    }

    public Currency(Integer id, String name, String symbol, String enabled) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.enabled = enabled;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        } else if (this.id == null && other.id == null) {
            return this == other;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.Currency[ id=" + id + " ]";
    }

}
