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
@Table(name = "project_image_section_image")
@NamedQueries({
    @NamedQuery(name = "ProjectImageSectionImage.findAll", query = "SELECT p FROM ProjectImageSectionImage p")})
public class ProjectImageSectionImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;
    @JoinColumn(name = "project_image_section_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectImageSection projectImageSectionId;

    public ProjectImageSectionImage() {
    }

    public ProjectImageSectionImage(Integer id) {
        this.id = id;
    }

    public ProjectImageSectionImage(Integer id, String description, String url, String thumbnailUrl) {
        this.id = id;
        this.description = description;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
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

    public ProjectImageSection getProjectImageSectionId() {
        return projectImageSectionId;
    }

    public void setProjectImageSectionId(ProjectImageSection projectImageSectionId) {
        this.projectImageSectionId = projectImageSectionId;
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
        if (!(object instanceof ProjectImageSectionImage)) {
            return false;
        }
        ProjectImageSectionImage other = (ProjectImageSectionImage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.ProjectImageSectionImage[ id=" + id + " ]";
    }
    
}
