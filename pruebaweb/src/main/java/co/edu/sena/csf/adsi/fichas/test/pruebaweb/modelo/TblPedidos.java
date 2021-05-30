/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ismael
 */
@Entity
@Table(name = "tbl_pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPedidos.findAll", query = "SELECT t FROM TblPedidos t"),
    @NamedQuery(name = "TblPedidos.findById", query = "SELECT t FROM TblPedidos t WHERE t.id = :id"),
    @NamedQuery(name = "TblPedidos.findByFecha", query = "SELECT t FROM TblPedidos t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TblPedidos.findByEliminado", query = "SELECT t FROM TblPedidos t WHERE t.eliminado = :eliminado")})
public class TblPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "eliminado")
    private Short eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId", fetch = FetchType.LAZY)
    private List<TblItemsPedidos> tblItemsPedidosList;
    @JoinColumn(name = "estado_pedido_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblEstadosPedidos estadoPedidoId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUsuarios usuarioId;

    public TblPedidos() {
    }

    public TblPedidos(Integer id) {
        this.id = id;
    }

    public TblPedidos(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public TblEstadosPedidos getEstadoPedidoId() {
        return estadoPedidoId;
    }

    public void setEstadoPedidoId(TblEstadosPedidos estadoPedidoId) {
        this.estadoPedidoId = estadoPedidoId;
    }

    public TblUsuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(TblUsuarios usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof TblPedidos)) {
            return false;
        }
        TblPedidos other = (TblPedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo.TblPedidos[ id=" + id + " ]";
    }
    
}
