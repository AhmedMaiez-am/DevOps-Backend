package com.esprit.examen.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFacture implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetailFacture;
	private Integer qteCommandee;
	private float prixTotalDetail;
	private Integer pourcentageRemise;
	private float montantRemise;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	@JsonIgnore
	Facture facture;
	public Long getIdDetailFacture() {
		return idDetailFacture;
	}
	public void setIdDetailFacture(Long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}
	public Integer getQteCommandee() {
		return qteCommandee;
	}
	public void setQteCommandee(Integer qteCommandee) {
		this.qteCommandee = qteCommandee;
	}
	public float getPrixTotalDetail() {
		return prixTotalDetail;
	}
	public void setPrixTotalDetail(float prixTotalDetail) {
		this.prixTotalDetail = prixTotalDetail;
	}
	public Integer getPourcentageRemise() {
		return pourcentageRemise;
	}
	public void setPourcentageRemise(Integer pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}
	public float getMontantRemise() {
		return montantRemise;
	}
	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "DetailFacture [idDetailFacture=" + idDetailFacture + ", qteCommandee=" + qteCommandee
				+ ", prixTotalDetail=" + prixTotalDetail + ", pourcentageRemise=" + pourcentageRemise
				+ ", montantRemise=" + montantRemise + ", produit=" + produit + ", facture=" + facture + "]";
	}
	public DetailFacture(Long idDetailFacture, Integer qteCommandee, float prixTotalDetail, Integer pourcentageRemise,
			float montantRemise, Produit produit, Facture facture) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qteCommandee = qteCommandee;
		this.prixTotalDetail = prixTotalDetail;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
		this.produit = produit;
		this.facture = facture;
	}
	public DetailFacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
