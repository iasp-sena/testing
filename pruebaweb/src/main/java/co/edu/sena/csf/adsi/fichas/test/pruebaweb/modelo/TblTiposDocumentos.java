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
@Table(name = "tbl_tipos_documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTiposDocumentos.findAll", query = "SELECT t FROM TblTiposDocumentos t"),
    @NamedQuery(name = "TblTiposDocumentos.findById", query = "SELECT t FROM TblTiposDocumentos t WHERE t.id = :id"),
    @NamedQuery(name = "TblTiposDocumentos.findByNombre", query = "SELECT t FROM TblTiposDocumentos t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblTiposDocumentos.findBySigla", query = "SELECT t FROM TblTiposDocumentos t WHERE t.sigla = :sigla"),
    @NamedQuery(name = "TblTiposDocumentos.findByEliminado", query = "SELECT t FROM TblTiposDocumentos t WHERE t.eliminado = :eliminado")})
public class TblTiposDocumentos implements Serializable {

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
    @Size(min = 1, max = 8)
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "eliminado")
    private Short eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento", fetch = FetchType.LAZY)
    private List<TblUsuarios> tblUsuariosList;

    public TblTiposDocumentos() {
    }

    public TblTiposDocumentos(Integer id) {
        this.id = id;
    }

    public TblTiposDocumentos(Integer id, String nombre, String sigla) {
        this.id = id;
        this.nombre = nombre;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Short getEliminado() {
        return eliminado;
    }

    public void setEliminado(Short eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public List<TblUsuarios> getTblUsuariosList() {
        return tblUsuariosList;
    }

    public void setTblUsuariosList(List<TblUsuarios> tblUsuariosList) {
        this.tblUsuariosList = tblUsuariosList;
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
        if (!(object instanceof TblTiposDocumentos)) {
            return false;
        }
        TblTiposDocumentos other = (TblTiposDocumentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.csf.adsi.fichas.test.pruebaweb.modelo.TblTiposDocumentos[ id=" + id + " ]";
    }
    
}
