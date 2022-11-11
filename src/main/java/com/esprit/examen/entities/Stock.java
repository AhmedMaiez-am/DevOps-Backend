package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStock;
	private String libelleStock;
	private Integer qte;
	private Integer qteMin;
	@OneToMany(mappedBy = "stock")
	@JsonIgnore
	private Set<Produit> produits;
	public Stock(String libelleStock, Integer qte, Integer qteMin) {
		super();
		this.libelleStock = libelleStock;
		this.qte = qte;
		this.qteMin = qteMin;
	}
	public Long getIdStock() {
		return idStock;
	}
	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}
	public String getLibelleStock() {
		return libelleStock;
	}
	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}
	public Integer getQte() {
		return qte;
	}
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	public Integer getQteMin() {
		return qteMin;
	}
	public void setQteMin(Integer qteMin) {
		this.qteMin = qteMin;
	}
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", libelleStock=" + libelleStock + ", qte=" + qte + ", qteMin=" + qteMin
				+ ", produits=" + produits + "]";
	}
	public Stock(Long idStock, String libelleStock, Integer qte, Integer qteMin, Set<Produit> produits) {
		super();
		this.idStock = idStock;
		this.libelleStock = libelleStock;
		this.qte = qte;
		this.qteMin = qteMin;
		this.produits = produits;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
