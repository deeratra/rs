package com.cts.foodster.bean;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int inventoryId;
	private String inventoryName;
	  @DateTimeFormat(pattern = "yyyy/MM/dd") // This is for bind Date with @ModelAttribute
	private LocalDate creationDate = LocalDate.now();
	  @DateTimeFormat(pattern = "yyyy/MM/dd") // This is for bind Date with @ModelAttribute
	private LocalDate startDate;
	  @DateTimeFormat(pattern = "yyyy/MM/dd") // This is for bind Date with @ModelAttribute
	private LocalDate endDate;
	private int totalStock;
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", inventoryName=" + inventoryName + ", creationDate="
				+ creationDate + ", startDate=" + startDate + ", endDate=" + endDate + ", totalStock=" + totalStock
				+ "]";
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}
}
