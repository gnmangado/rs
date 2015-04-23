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

/**
 *
 * @author gmangado
 */
@Entity
@Table(name = "image")
@NamedQueries({
    @NamedQuery(name = "Image.findAll", query = "SELECT i FROM Image i")})
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    @Basic(optional = false)
    @Column(name = "is_main")
    private boolean isMain;
    @Basic(optional = false)
    @Column(name = "is_plan")
    private String isPlan;
    @Column(name = "is_featured")
    private Boolean isFeatured;
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Property propertyId;

    public Image() {
    }

    public Image(Integer id) {
        this.id = id;
    }

    public Image(Integer id, String url, String thumbnailUrl, boolean isMain, String isPlan) {
        this.id = id;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.isMain = isMain;
        this.isPlan = isPlan;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public boolean getIsMain() {
        return isMain;
    }

    public void setIsMain(boolean isMain) {
        this.isMain = isMain;
    }

    public String getIsPlan() {
        return isPlan;
    }

    public void setIsPlan(String isPlan) {
        this.isPlan = isPlan;
    }

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
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
        if (!(object instanceof Image)) {
            return false;
        }
        Image other = (Image) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.Image[ id=" + id + " ]";
    }
    
}
