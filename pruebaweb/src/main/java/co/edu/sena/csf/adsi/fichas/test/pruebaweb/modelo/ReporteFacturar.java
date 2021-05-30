/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ismael
 */
@Entity
@Table(name = "reporte_facturar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteFacturar.findAll", query = "SELECT r FROM ReporteFacturar r"),
    @NamedQuery(name = "ReporteFacturar.findById", query = "SELECT r FROM ReporteFacturar r WHERE r.id = :id"),
    @NamedQuery(name = "ReporteFacturar.findByFecha", query = "SELECT r FROM ReporteFacturar r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "ReporteFacturar.findByUTipoDoc", query = "SELECT r FROM ReporteFacturar r WHERE r.uTipoDoc = :uTipoDoc"),
    @NamedQuery(name = "ReporteFacturar.findByUNumDoc", query = "SELECT r FROM ReporteFacturar r WHERE r.uNumDoc = :uNumDoc"),
    @NamedQuery(name = "ReporteFacturar.findByUNombres", query = "SELECT r FROM ReporteFacturar r WHERE r.uNombres = :uNombres"),
    @NamedQuery(name = "ReporteFacturar.findByUApellidos", query = "SELECT r FROM ReporteFacturar r WHERE r.uApellidos = :uApellidos"),
    @NamedQuery(name = "ReporteFacturar.findByNomProd", query = "SELECT r FROM ReporteFacturar r WHERE r.nomProd = :nomProd"),
    @NamedQuery(name = "ReporteFacturar.findByCantSolicitada", query = "SELECT r FROM ReporteFacturar r WHERE r.cantSolicitada = :cantSolicitada"),
    @NamedQuery(name = "ReporteFacturar.findByPrecioUnitario", query = "SELECT r FROM ReporteFacturar r WHERE r.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "ReporteFacturar.findBySubTotal", query = "SELECT r FROM ReporteFacturar r WHERE r.subTotal = :subTotal")})
public class ReporteFacturar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "u_tipo_doc")
    private String uTipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "u_num_doc")
    private String uNumDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "u_nombres")
    private String uNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "u_apellidos")
    private String uApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_prod")
    private String nomProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_solicitada")
    private int cantSolicitada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_unitario")
    private double precioUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_total")
    private double subTotal;

    public ReporteFacturar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUTipoDoc() {
        return uTipoDoc;
    }

    public void setUTipoDoc(String uTipoDoc) {
        this.uTipoDoc = uTipoDoc;
    }

    public String getUNumDoc() {
        return uNumDoc;
    }

    public void setUNumDoc(String uNumDoc) {
        this.uNumDoc = uNumDoc;
    }

    public String getUNombres() {
        return uNombres;
    }

    public void setUNombres(String uNombres) {
        this.uNombres = uNombres;
    }

    public String getUApellidos() {
        return uApellidos;
    }

    public void setUApellidos(String uApellidos) {
        this.uApellidos = uApellidos;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public int getCantSolicitada() {
        return cantSolicitada;
    }

    public void setCantSolicitada(int cantSolicitada) {
        this.cantSolicitada = cantSolicitada;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
}
