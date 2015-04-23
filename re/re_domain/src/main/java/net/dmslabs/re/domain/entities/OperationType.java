package net.dmslabs.re.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gmangado
 */
@Entity
@Table(name = "operation_type")
@NamedQueries({
    @NamedQuery(name = "OperationType.findAll", query = "SELECT o FROM OperationType o")})
public class OperationType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operationType", fetch = FetchType.LAZY)
    private List<PropertyHasOperationTypes> propertyHasOperationTypesList;

    public OperationType() {
    }

    public OperationType(Integer id) {
        this.id = id;
    }

    public OperationType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PropertyHasOperationTypes> getPropertyHasOperationTypesList() {
        return propertyHasOperationTypesList;
    }

    public void setPropertyHasOperationTypesList(List<PropertyHasOperationTypes> propertyHasOperationTypesList) {
        this.propertyHasOperationTypesList = propertyHasOperationTypesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperationType)) {
            return false;
        }
        OperationType other = (OperationType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.OperationType[ id=" + id + " ]";
    }
    
}
