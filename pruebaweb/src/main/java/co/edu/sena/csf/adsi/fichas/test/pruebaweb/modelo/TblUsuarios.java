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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuarios.findAll", query = "SELECT t FROM TblUsuarios t"),
    @NamedQuery(name = "TblUsuarios.findById", query = "SELECT t FROM TblUsuarios t WHERE t.id = :id"),
    @NamedQuery(name = "TblUsuarios.findByNumeroDocumento", query = "SELECT t FROM TblUsuarios t WHERE t.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "TblUsuarios.findByNombres", query = "SELECT t FROM TblUsuarios t WHERE t.nombres = :nombres"),
    @NamedQuery(name = "TblUsuarios.findByApellidos", query = "SELECT t FROM TblUsuarios t WHERE t.apellidos = :apellidos"),
    @NamedQuery(name = "TblUsuarios.findByCorreo", query = "SELECT t FROM TblUsuarios t WHERE t.correo = :correo"),
    @NamedQuery(name = "TblUsuarios.findByClave", query = "SELECT t FROM TblUsuarios t WHERE t.clave = :clave"),
    @NamedQuery(name = "TblUsuarios.findByEliminado", query = "SELECT t FROM TblUsuarios t WHERE t.eliminado = :eliminado")})
public class TblUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clave")
    private String clave;
    @Column(name = "eliminado")
    private Short eliminado;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblTiposDocumentos tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<TblPedidos> tblPedidosList;

    public TblUsuarios() {
    }

    public TblUsuarios(Integer id) {
        this.id = id;
    }

    public TblUsuarios(Integer id, String numeroDocumento, String nombres, String apellidos, String correo, String clave) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Short getEliminado() {
        return eliminado;
    }

    public void setEliminado(Short eliminado) {
        this.eliminado = eliminado;
    }

    public TblTiposDocumentos getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TblTiposDocumentos tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        if (!(object instanceof TblUsuarios)) {
            return false;
        }
        TblUsuarios other = (TblUsuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo.TblUsuarios[ id=" + id + " ]";
    }
    
}
