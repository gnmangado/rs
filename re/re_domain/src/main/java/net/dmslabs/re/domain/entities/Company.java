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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gmangado
 */
@Entity
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "about_us")
    private String aboutUs;
    @Lob
    @Column(name = "our_services")
    private String ourServices;
    @Lob
    @Column(name = "usefull_information")
    private String usefullInformation;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "email")
    private String email;
    @Column(name = "website")
    private String website;
    @ManyToMany(mappedBy = "companyList", fetch = FetchType.LAZY)
    private List<BackendUser> backendUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId", fetch = FetchType.LAZY)
    private List<Property> propertyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId", fetch = FetchType.LAZY)
    private List<Project> projectList;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
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

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getOurServices() {
        return ourServices;
    }

    public void setOurServices(String ourServices) {
        this.ourServices = ourServices;
    }

    public String getUsefullInformation() {
        return usefullInformation;
    }

    public void setUsefullInformation(String usefullInformation) {
        this.usefullInformation = usefullInformation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<BackendUser> getBackendUserList() {
        return backendUserList;
    }

    public void setBackendUserList(List<BackendUser> backendUserList) {
        this.backendUserList = backendUserList;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.Company[ id=" + id + " ]";
    }
    
}
