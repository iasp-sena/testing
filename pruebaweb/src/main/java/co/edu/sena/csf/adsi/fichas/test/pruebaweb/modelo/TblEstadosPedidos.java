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
@Table(name = "tbl_estados_pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEstadosPedidos.findAll", query = "SELECT t FROM TblEstadosPedidos t"),
    @NamedQuery(name = "TblEstadosPedidos.findById", query = "SELECT t FROM TblEstadosPedidos t WHERE t.id = :id"),
    @NamedQuery(name = "TblEstadosPedidos.findByNombre", query = "SELECT t FROM TblEstadosPedidos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblEstadosPedidos.findByDescripcion", query = "SELECT t FROM TblEstadosPedidos t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TblEstadosPedidos.findByEliminado", query = "SELECT t FROM TblEstadosPedidos t WHERE t.eliminado = :eliminado")})
public class TblEstadosPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "eliminado")
    private Short eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoPedidoId", fetch = FetchType.LAZY)
    private List<TblPedidos> tblPedidosList;

    public TblEstadosPedidos() {
    }

    public TblEstadosPedidos(Integer id) {
        this.id = id;
    }

    public TblEstadosPedidos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public Short getEliminado() {
        return eliminado;
    }

    public void setEliminado(Short eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public List<TblPedidos> getTblPedidosList() {
        return tblPedidosList;
    }

    public void setTblPedidosList(List<TblPedidos> tblPedidosList) {
        this.tblPedidosList = tblPedidosList;
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
        if (!(object instanceof TblEstadosPedidos)) {
            return false;
        }
        TblEstadosPedidos other = (TblEstadosPedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo.TblEstadosPedidos[ id=" + id + " ]";
    }
    
}
