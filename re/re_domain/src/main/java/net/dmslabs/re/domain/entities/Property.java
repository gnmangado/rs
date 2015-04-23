package net.dmslabs.re.domain.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gmangado
 */
@Entity
@Table(name = "property")
@NamedQueries({
    @NamedQuery(name = "Property.findAll", query = "SELECT p FROM Property p")})
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "english_title")
    private String englishTitle;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "english_description")
    private String englishDescription;
    @Column(name = "address")
    private String address;
    @Column(name = "geo_location_x")
    private String geoLocationX;
    @Column(name = "geo_location_y")
    private String geoLocationY;
    @Basic(optional = false)
    @Column(name = "featured")
    private boolean featured;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Column(name = "publication_end")
    @Temporal(TemporalType.DATE)
    private Date publicationEnd;
    @Lob
    @Column(name = "intro")
    private String intro;
    @Lob
    @Column(name = "english_intro")
    private String englishIntro;
    @Column(name = "year")
    private String year;
    @Column(name = "building_status")
    private String buildingStatus;
    @Column(name = "meters_builded")
    private Integer metersBuilded;
    @Column(name = "meters_terrain")
    private Integer metersTerrain;
    @Column(name = "floor")
    private String floor;
    @Column(name = "in_front")
    private Boolean inFront;
    @Column(name = "bedrooms")
    private Integer bedrooms;
    @Column(name = "bathrooms")
    private Integer bathrooms;
    @Column(name = "hall")
    private Boolean hall;
    @Column(name = "linvingroom")
    private Boolean linvingroom;
    @Column(name = "linving_dining_room")
    private Boolean linvingDiningRoom;
    @Column(name = "diningroom")
    private Boolean diningroom;
    @Column(name = "office")
    private Boolean office;
    @Column(name = "estar")
    private Boolean estar;
    @Column(name = "lavadero")
    private Boolean lavadero;
    @Column(name = "balcon")
    private Boolean balcon;
    @Column(name = "terraza")
    private Boolean terraza;
    @Column(name = "acceso_azotea")
    private Boolean accesoAzotea;
    @Column(name = "patio")
    private Boolean patio;
    @Column(name = "fondo")
    private Boolean fondo;
    @Column(name = "jardin")
    private Boolean jardin;
    @Column(name = "parrillero")
    private Boolean parrillero;
    @Column(name = "barbacoa")
    private Boolean barbacoa;
    @Column(name = "amueblado")
    private Boolean amueblado;
    @Column(name = "calefaccion")
    private Integer calefaccion;
    @Column(name = "aire_acondicionado")
    private Boolean aireAcondicionado;
    @Column(name = "gas_canieria")
    private Boolean gasCanieria;
    @Column(name = "alarma")
    private Boolean alarma;
    @Column(name = "ascensor")
    private Boolean ascensor;
    @Column(name = "porteria")
    private Boolean porteria;
    @Column(name = "portero_electrico")
    private Boolean porteroElectrico;
    @Column(name = "lavanderia")
    private Boolean lavanderia;
    @Column(name = "vigilancia")
    private Boolean vigilancia;
    @Column(name = "garage")
    private Boolean garage;
    @Column(name = "cochera")
    private Boolean cochera;
    @Column(name = "sauna")
    private Boolean sauna;
    @Column(name = "sala_juegos")
    private Boolean salaJuegos;
    @Column(name = "gimnasio")
    private Boolean gimnasio;
    @Column(name = "canchas_deportivas")
    private Boolean canchasDeportivas;
    @Column(name = "parrillero_comun")
    private Boolean parrilleroComun;
    @Column(name = "barbacoa_comun")
    private Boolean barbacoaComun;
    @Column(name = "solarium")
    private Boolean solarium;
    @Column(name = "salon_comunal")
    private Boolean salonComunal;
    @Column(name = "piscina")
    private Boolean piscina;
    @Column(name = "gastos_comunes")
    private Integer gastosComunes;
    @Column(name = "deuda")
    private String deuda;
    @Column(name = "dormitorios_placard")
    private Integer dormitoriosPlacard;
    @Column(name = "dormitorios_suite")
    private Integer dormitoriosSuite;
    @Column(name = "dormitorio_servicio")
    private Boolean dormitorioServicio;
    @Column(name = "kitchenette")
    private Boolean kitchenette;
    @Column(name = "cocina")
    private Boolean cocina;
    @Column(name = "banio_servicio")
    private Boolean banioServicio;
    @Column(name = "telefono")
    private Boolean telefono;
    @Column(name = "tv_cable")
    private Boolean tvCable;
    @Column(name = "terraza_servicio")
    private Boolean terrazaServicio;
    @Lob
    @Column(name = "financiacion")
    private String financiacion;
    @Column(name = "es_subdestacado")
    private Boolean esSubdestacado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertyId", fetch = FetchType.LAZY)
    private List<Image> imageList;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Company companyId;
    @JoinColumn(name = "property_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PropertyType propertyTypeId;
    @JoinColumn(name = "property_status_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PropertyStatus propertyStatusId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client clientId;
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Area areaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "property", fetch = FetchType.LAZY)
    private List<PropertyHasOperationTypes> propertyHasOperationTypesList;

    public Property() {
    }

    public Property(Integer id) {
        this.id = id;
    }

    public Property(Integer id, String title, String description, boolean featured, Date createdDate, Date updatedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.featured = featured;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(String englishDescription) {
        this.englishDescription = englishDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public boolean getFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getPublicationEnd() {
        return publicationEnd;
    }

    public void setPublicationEnd(Date publicationEnd) {
        this.publicationEnd = publicationEnd;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEnglishIntro() {
        return englishIntro;
    }

    public void setEnglishIntro(String englishIntro) {
        this.englishIntro = englishIntro;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBuildingStatus() {
        return buildingStatus;
    }

    public void setBuildingStatus(String buildingStatus) {
        this.buildingStatus = buildingStatus;
    }

    public Integer getMetersBuilded() {
        return metersBuilded;
    }

    public void setMetersBuilded(Integer metersBuilded) {
        this.metersBuilded = metersBuilded;
    }

    public Integer getMetersTerrain() {
        return metersTerrain;
    }

    public void setMetersTerrain(Integer metersTerrain) {
        this.metersTerrain = metersTerrain;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Boolean getInFront() {
        return inFront;
    }

    public void setInFront(Boolean inFront) {
        this.inFront = inFront;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Boolean getHall() {
        return hall;
    }

    public void setHall(Boolean hall) {
        this.hall = hall;
    }

    public Boolean getLinvingroom() {
        return linvingroom;
    }

    public void setLinvingroom(Boolean linvingroom) {
        this.linvingroom = linvingroom;
    }

    public Boolean getLinvingDiningRoom() {
        return linvingDiningRoom;
    }

    public void setLinvingDiningRoom(Boolean linvingDiningRoom) {
        this.linvingDiningRoom = linvingDiningRoom;
    }

    public Boolean getDiningroom() {
        return diningroom;
    }

    public void setDiningroom(Boolean diningroom) {
        this.diningroom = diningroom;
    }

    public Boolean getOffice() {
        return office;
    }

    public void setOffice(Boolean office) {
        this.office = office;
    }

    public Boolean getEstar() {
        return estar;
    }

    public void setEstar(Boolean estar) {
        this.estar = estar;
    }

    public Boolean getLavadero() {
        return lavadero;
    }

    public void setLavadero(Boolean lavadero) {
        this.lavadero = lavadero;
    }

    public Boolean getBalcon() {
        return balcon;
    }

    public void setBalcon(Boolean balcon) {
        this.balcon = balcon;
    }

    public Boolean getTerraza() {
        return terraza;
    }

    public void setTerraza(Boolean terraza) {
        this.terraza = terraza;
    }

    public Boolean getAccesoAzotea() {
        return accesoAzotea;
    }

    public void setAccesoAzotea(Boolean accesoAzotea) {
        this.accesoAzotea = accesoAzotea;
    }

    public Boolean getPatio() {
        return patio;
    }

    public void setPatio(Boolean patio) {
        this.patio = patio;
    }

    public Boolean getFondo() {
        return fondo;
    }

    public void setFondo(Boolean fondo) {
        this.fondo = fondo;
    }

    public Boolean getJardin() {
        return jardin;
    }

    public void setJardin(Boolean jardin) {
        this.jardin = jardin;
    }

    public Boolean getParrillero() {
        return parrillero;
    }

    public void setParrillero(Boolean parrillero) {
        this.parrillero = parrillero;
    }

    public Boolean getBarbacoa() {
        return barbacoa;
    }

    public void setBarbacoa(Boolean barbacoa) {
        this.barbacoa = barbacoa;
    }

    public Boolean getAmueblado() {
        return amueblado;
    }

    public void setAmueblado(Boolean amueblado) {
        this.amueblado = amueblado;
    }

    public Integer getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(Integer calefaccion) {
        this.calefaccion = calefaccion;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getGasCanieria() {
        return gasCanieria;
    }

    public void setGasCanieria(Boolean gasCanieria) {
        this.gasCanieria = gasCanieria;
    }

    public Boolean getAlarma() {
        return alarma;
    }

    public void setAlarma(Boolean alarma) {
        this.alarma = alarma;
    }

    public Boolean getAscensor() {
        return ascensor;
    }

    public void setAscensor(Boolean ascensor) {
        this.ascensor = ascensor;
    }

    public Boolean getPorteria() {
        return porteria;
    }

    public void setPorteria(Boolean porteria) {
        this.porteria = porteria;
    }

    public Boolean getPorteroElectrico() {
        return porteroElectrico;
    }

    public void setPorteroElectrico(Boolean porteroElectrico) {
        this.porteroElectrico = porteroElectrico;
    }

    public Boolean getLavanderia() {
        return lavanderia;
    }

    public void setLavanderia(Boolean lavanderia) {
        this.lavanderia = lavanderia;
    }

    public Boolean getVigilancia() {
        return vigilancia;
    }

    public void setVigilancia(Boolean vigilancia) {
        this.vigilancia = vigilancia;
    }

    public Boolean getGarage() {
        return garage;
    }

    public void setGarage(Boolean garage) {
        this.garage = garage;
    }

    public Boolean getCochera() {
        return cochera;
    }

    public void setCochera(Boolean cochera) {
        this.cochera = cochera;
    }

    public Boolean getSauna() {
        return sauna;
    }

    public void setSauna(Boolean sauna) {
        this.sauna = sauna;
    }

    public Boolean getSalaJuegos() {
        return salaJuegos;
    }

    public void setSalaJuegos(Boolean salaJuegos) {
        this.salaJuegos = salaJuegos;
    }

    public Boolean getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(Boolean gimnasio) {
        this.gimnasio = gimnasio;
    }

    public Boolean getCanchasDeportivas() {
        return canchasDeportivas;
    }

    public void setCanchasDeportivas(Boolean canchasDeportivas) {
        this.canchasDeportivas = canchasDeportivas;
    }

    public Boolean getParrilleroComun() {
        return parrilleroComun;
    }

    public void setParrilleroComun(Boolean parrilleroComun) {
        this.parrilleroComun = parrilleroComun;
    }

    public Boolean getBarbacoaComun() {
        return barbacoaComun;
    }

    public void setBarbacoaComun(Boolean barbacoaComun) {
        this.barbacoaComun = barbacoaComun;
    }

    public Boolean getSolarium() {
        return solarium;
    }

    public void setSolarium(Boolean solarium) {
        this.solarium = solarium;
    }

    public Boolean getSalonComunal() {
        return salonComunal;
    }

    public void setSalonComunal(Boolean salonComunal) {
        this.salonComunal = salonComunal;
    }

    public Boolean getPiscina() {
        return piscina;
    }

    public void setPiscina(Boolean piscina) {
        this.piscina = piscina;
    }

    public Integer getGastosComunes() {
        return gastosComunes;
    }

    public void setGastosComunes(Integer gastosComunes) {
        this.gastosComunes = gastosComunes;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

    public Integer getDormitoriosPlacard() {
        return dormitoriosPlacard;
    }

    public void setDormitoriosPlacard(Integer dormitoriosPlacard) {
        this.dormitoriosPlacard = dormitoriosPlacard;
    }

    public Integer getDormitoriosSuite() {
        return dormitoriosSuite;
    }

    public void setDormitoriosSuite(Integer dormitoriosSuite) {
        this.dormitoriosSuite = dormitoriosSuite;
    }

    public Boolean getDormitorioServicio() {
        return dormitorioServicio;
    }

    public void setDormitorioServicio(Boolean dormitorioServicio) {
        this.dormitorioServicio = dormitorioServicio;
    }

    public Boolean getKitchenette() {
        return kitchenette;
    }

    public void setKitchenette(Boolean kitchenette) {
        this.kitchenette = kitchenette;
    }

    public Boolean getCocina() {
        return cocina;
    }

    public void setCocina(Boolean cocina) {
        this.cocina = cocina;
    }

    public Boolean getBanioServicio() {
        return banioServicio;
    }

    public void setBanioServicio(Boolean banioServicio) {
        this.banioServicio = banioServicio;
    }

    public Boolean getTelefono() {
        return telefono;
    }

    public void setTelefono(Boolean telefono) {
        this.telefono = telefono;
    }

    public Boolean getTvCable() {
        return tvCable;
    }

    public void setTvCable(Boolean tvCable) {
        this.tvCable = tvCable;
    }

    public Boolean getTerrazaServicio() {
        return terrazaServicio;
    }

    public void setTerrazaServicio(Boolean terrazaServicio) {
        this.terrazaServicio = terrazaServicio;
    }

    public String getFinanciacion() {
        return financiacion;
    }

    public void setFinanciacion(String financiacion) {
        this.financiacion = financiacion;
    }

    public Boolean getEsSubdestacado() {
        return esSubdestacado;
    }

    public void setEsSubdestacado(Boolean esSubdestacado) {
        this.esSubdestacado = esSubdestacado;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public PropertyType getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(PropertyType propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public PropertyStatus getPropertyStatusId() {
        return propertyStatusId;
    }

    public void setPropertyStatusId(PropertyStatus propertyStatusId) {
        this.propertyStatusId = propertyStatusId;
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
        if (!(object instanceof Property)) {
            return false;
        }
        Property other = (Property) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.dmslabs.re.domain.entities.Property[ id=" + id + " ]";
    }
    
}
