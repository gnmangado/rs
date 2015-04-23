package net.dmslabs.re.domain.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gmangado
 */
@Entity
@Table(name = "project_image_section")
@NamedQueries({
    @NamedQuery(name = "ProjectImageSection.findAll", query = "SELECT p FROM ProjectImageSection p")})
public class ProjectImageSection implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "order_in_project")
    private short orderInProject;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Project projectId;
    @OneToMany(mappedBy = "projectImageSectionId", fetch = FetchType.LAZY)
    private List<ProjectImageSectionImage> projectImageSectionImageList;

    public ProjectImageSection() {
    }

    public ProjectImageSection(Integer id) {
        this.id = id;
    }

    public ProjectImageSection(Integer id, String title, short orderInProject) {
        this.id = id;
        this.title = title;
        this.orderInProject = orderInProject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getOrderInProject() {
        return orderInProject;
    }

    public void setOrderInProject(short orderInProject) {
        this.orderInProject = orderInProject;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public List<ProjectImageSectionImage> getProjectImageSectionImageList() {
        return projectImageSectionImageList;
    }

    public void setProjectImageSectionImageList(List<ProjectImageSectionImage> projectImageSectionImageList) {
        this.projectImageSectionImageList = projectImageSectionImageList;
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
        if (!(object instanceof ProjectImageSection)) {
            return false;
        }
        ProjectImageSection other = (ProjectImageSection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.ProjectImageSection[ id=" + id + " ]";
    }
    
}
