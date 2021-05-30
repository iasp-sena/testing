/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ismael
 */
@Entity
@Table(name = "tbl_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProductos.findAll", query = "SELECT t FROM TblProductos t"),
    @NamedQuery(name = "TblProductos.findById", query = "SELECT t FROM TblProductos t WHERE t.id = :id"),
    @NamedQuery(name = "TblProductos.findByNombre", query = "SELECT t FROM TblProductos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblProductos.findByCantidadDisponible", query = "SELECT t FROM TblProductos t WHERE t.cantidadDisponible = :cantidadDisponible"),
    @NamedQuery(name = "TblProductos.findByPrecio", query = "SELECT t FROM TblProductos t WHERE t.precio = :precio"),
    @NamedQuery(name = "TblProductos.findByEliminado", query = "SELECT t FROM TblProductos t WHERE t.eliminado = :eliminado")})
public class TblProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Size(max = 65535)
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "eliminado")
    private Short eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId", fetch = FetchType.LAZY)
    private List<TblItemsPedidos> tblItemsPedidosList;

    public TblProductos() {
    }

    public TblProductos(Integer id) {
        this.id = id;
    }

    public TblProductos(Integer id, String nombre, String descripcion, int cantidadDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Short getEliminado() {
        return eliminado;
    }

    public void setEliminado(Short eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public List<TblItemsPedidos> getTblItemsPedidosList() {
        return tblItemsPedidosList;
    }

    public void setTblItemsPedidosList(List<TblItemsPedidos> tblItemsPedidosList) {
        this.tblItemsPedidosList = tblItemsPedidosList;
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
        if (!(object instanceof TblProductos)) {
            return false;
        }
        TblProductos other = (TblProductos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo.TblProductos[ id=" + id + " ]";
    }
    
}
