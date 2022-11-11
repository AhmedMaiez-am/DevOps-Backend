package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Reglement implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReglement;
	private float montantPaye;
	private float montantRestant;
	private Boolean payee;
	@Temporal(TemporalType.DATE)
	private Date dateReglement;
	@ManyToOne
	@JsonIgnore
	private Facture facture;
	public Long getIdReglement() {
		return idReglement;
	}
	public void setIdReglement(Long idReglement) {
		this.idReglement = idReglement;
	}
	public float getMontantPaye() {
		return montantPaye;
	}
	public void setMontantPaye(float montantPaye) {
		this.montantPaye = montantPaye;
	}
	public float getMontantRestant() {
		return montantRestant;
	}
	public void setMontantRestant(float montantRestant) {
		this.montantRestant = montantRestant;
	}
	public Boolean getPayee() {
		return payee;
	}
	public void setPayee(Boolean payee) {
		this.payee = payee;
	}
	public Date getDateReglement() {
		return dateReglement;
	}
	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
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
		return "Reglement [idReglement=" + idReglement + ", montantPaye=" + montantPaye + ", montantRestant="
				+ montantRestant + ", payee=" + payee + ", dateReglement=" + dateReglement + ", facture=" + facture
				+ "]";
	}
	public Reglement(Long idReglement, float montantPaye, float montantRestant, Boolean payee, Date dateReglement,
			Facture facture) {
		super();
		this.idReglement = idReglement;
		this.montantPaye = montantPaye;
		this.montantRestant = montantRestant;
		this.payee = payee;
		this.dateReglement = dateReglement;
		this.facture = facture;
	}
	public Reglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
