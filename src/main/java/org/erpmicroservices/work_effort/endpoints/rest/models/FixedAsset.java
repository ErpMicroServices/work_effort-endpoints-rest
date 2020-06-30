package org.erpmicroservices.work_effort.endpoints.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "fixed_asset")
public class FixedAsset extends AbstractPersistable<UUID> {
 @NotBlank
 @NotNull
 private String name;

 @Column(name = "date_acquired", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate dateAcquired;

 @Column(name = "date_last_serviced", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate dateLastServiced;

 @Column(name = "date_next_service", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate dateNextService;

 private Long productionCapacity;

 private String description;

 private UUID unitOfMeasure;

 @ManyToOne
 @JoinColumn(name = "type_id")
 private FixedAssetType type;

 @OneToMany
 @JoinColumn(name = "fixed_asset_id")
 private List<FixedAssetRequirement> requirements = new ArrayList<>();

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public LocalDate getDateAcquired() {
	return dateAcquired;
 }

 public void setDateAcquired(LocalDate dateAcquired) {
	this.dateAcquired = dateAcquired;
 }

 public LocalDate getDateLastServiced() {
	return dateLastServiced;
 }

 public void setDateLastServiced(LocalDate dateLastServiced) {
	this.dateLastServiced = dateLastServiced;
 }

 public LocalDate getDateNextService() {
	return dateNextService;
 }

 public void setDateNextService(LocalDate dateNextService) {
	this.dateNextService = dateNextService;
 }

 public Long getProductionCapacity() {
	return productionCapacity;
 }

 public void setProductionCapacity(Long productionCapacity) {
	this.productionCapacity = productionCapacity;
 }

 public String getDescription() {
	return description;
 }

 public void setDescription(String description) {
	this.description = description;
 }

 public UUID getUnitOfMeasure() {
	return unitOfMeasure;
 }

 public void setUnitOfMeasure(UUID unitOfMeasure) {
	this.unitOfMeasure = unitOfMeasure;
 }

 public FixedAssetType getType() {
	return type;
 }

 public void setType(FixedAssetType type) {
	this.type = type;
 }

 public List<FixedAssetRequirement> getRequirements() {
	return requirements;
 }

 public void setRequirements(List<FixedAssetRequirement> requirements) {
	this.requirements = requirements;
 }
}
