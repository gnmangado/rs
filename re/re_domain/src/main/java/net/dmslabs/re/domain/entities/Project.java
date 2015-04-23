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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")})
public class Project implements Serializable {
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
    @Lob
    @Column(name = "property_types")
    private String propertyTypes;
    @Basic(optional = false)
    @Column(name = "ocupation_moment")
    private String ocupationMoment;
    @Basic(optional = false)
    @Lob
    @Column(name = "intro")
    private String intro;
    @Basic(optional = false)
    @Column(name = "main_image")
    private String mainImage;
    @Basic(optional = false)
    @Lob
    @Column(name = "main_description")
    private String mainDescription;
    @Basic(optional = false)
    @Column(name = "geo_location_x")
    private String geoLocationX;
    @Basic(optional = false)
    @Column(name = "geo_location_y")
    private String geoLocationY;
    @Basic(optional = false)
    @Lob
    @Column(name = "services")
    private String services;
    @Basic(optional = false)
    @Lob
    @Column(name = "financiation")
    private String financiation;
    @Column(name = "address")
    private String address;
    @Column(name = "main_image_thumb")
    private String mainImageThumb;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company companyId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client clientId;
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area areaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId", fetch = FetchType.LAZY)
    private List<ProjectImageSection> projectImageSectionList;

    public Project() {
    }

    public Project(Integer id) {
        this.id = id;
    }

    public Project(Integer id, String title, String propertyTypes, String ocupationMoment, String intro, String mainImage, String mainDescription, String geoLocationX, String geoLocationY, String services, String financiation) {
        this.id = id;
        this.title = title;
        this.propertyTypes = propertyTypes;
        this.ocupationMoment = ocupationMoment;
        this.intro = intro;
        this.mainImage = mainImage;
        this.mainDescription = mainDescription;
        this.geoLocationX = geoLocationX;
        this.geoLocationY = geoLocationY;
        this.services = services;
        this.financiation = financiation;
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

    public String getPropertyTypes() {
        return propertyTypes;
    }

    public void setPropertyTypes(String propertyTypes) {
        this.propertyTypes = propertyTypes;
    }

    public String getOcupationMoment() {
        return ocupationMoment;
    }

    public void setOcupationMoment(String ocupationMoment) {
        this.ocupationMoment = ocupationMoment;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    public String getGeoLocationX() {
        return geoLocationX;
    }

    public void setGeoLocationX(String geoLocationX) {
        this.geoLocationX = geoLocationX;
    }

    public String getGeoLocationY() {
        return geoLocationY;
    }

    public void setGeoLocationY(String geoLocationY) {
        this.geoLocationY = geoLocationY;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getFinanciation() {
        return financiation;
    }

    public void setFinanciation(String financiation) {
        this.financiation = financiation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMainImageThumb() {
        return mainImageThumb;
    }

    public void setMainImageThumb(String mainImageThumb) {
        this.mainImageThumb = mainImageThumb;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Area getAreaId() {
        return areaId;
    }

    public void setAreaId(Area areaId) {
        this.areaId = areaId;
    }

    public List<ProjectImageSection> getProjectImageSectionList() {
        return projectImageSectionList;
    }

    public void setProjectImageSectionList(List<ProjectImageSection> projectImageSectionList) {
        this.projectImageSectionList = projectImageSectionList;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.Project[ id=" + id + " ]";
    }
    
}
