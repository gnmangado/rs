package net.dmslabs.re.domain.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author gmangado
 */
@Entity
@Table(name = "property_has_operation_types")
@NamedQueries({ @NamedQuery(name = "PropertyHasOperationTypes.findAll", query = "SELECT p FROM PropertyHasOperationTypes p") })
public class PropertyHasOperationTypes implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "operation_value")
	private Double operationValue;
	@Column(name = "es_subdestacado")
	private Boolean esSubdestacado;
	@JoinColumn(name = "property_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Property property;
	@JoinColumn(name = "operation_type_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private OperationType operationType;
	@JoinColumn(name = "currency_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Currency currency;

	public PropertyHasOperationTypes() {
	}

	public PropertyHasOperationTypes(Integer id) {
		this.id = id;
	}

	public PropertyHasOperationTypes(Integer id, Double operationValue) {
		this.id = id;
		this.operationValue = operationValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getOperationValue() {
		return operationValue;
	}

	public void setOperationValue(Double operationValue) {
		this.operationValue = operationValue;
	}

	public Boolean getEsSubdestacado() {
		return esSubdestacado;
	}

	public void setEsSubdestacado(Boolean esSubdestacado) {
		this.esSubdestacado = esSubdestacado;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof PropertyHasOperationTypes)) {
			return false;
		}
		PropertyHasOperationTypes other = (PropertyHasOperationTypes) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication4.PropertyHasOperationTypes[ id=" + id + " ]";
	}

}
