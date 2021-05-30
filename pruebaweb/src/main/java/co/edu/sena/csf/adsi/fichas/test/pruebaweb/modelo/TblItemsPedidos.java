/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ismael
 */
@Entity
@Table(name = "tbl_items_pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblItemsPedidos.findAll", query = "SELECT t FROM TblItemsPedidos t"),
    @NamedQuery(name = "TblItemsPedidos.findById", query = "SELECT t FROM TblItemsPedidos t WHERE t.id = :id"),
    @NamedQuery(name = "TblItemsPedidos.findByCantidad", query = "SELECT t FROM TblItemsPedidos t WHERE t.cantidad = :cantidad"),
    @NamedQuery(name = "TblItemsPedidos.findByPrecioVenta", query = "SELECT t FROM TblItemsPedidos t WHERE t.precioVenta = :precioVenta"),
    @NamedQuery(name = "TblItemsPedidos.findByEliminado", query = "SELECT t FROM TblItemsPedidos t WHERE t.eliminado = :eliminado")})
public class TblItemsPedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;
    @Column(name = "eliminado")
    private Short eliminado;
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblPedidos pedidoId;
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblProductos productoId;

    public TblItemsPedidos() {
    }

    public TblItemsPedidos(Integer id) {
        this.id = id;
    }

    public TblItemsPedidos(Integer id, int cantidad, double precioVenta) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Short getEliminado() {
        return eliminado;
    }

    public void setEliminado(Short eliminado) {
        this.eliminado = eliminado;
    }

    public TblPedidos getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(TblPedidos pedidoId) {
        this.pedidoId = pedidoId;
    }

    public TblProductos getProductoId() {
        return productoId;
    }

    public void setProductoId(TblProductos productoId) {
        this.productoId = productoId;
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
        if (!(object instanceof TblItemsPedidos)) {
            return false;
        }
        TblItemsPedidos other = (TblItemsPedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo.TblItemsPedidos[ id=" + id + " ]";
    }
    
}
