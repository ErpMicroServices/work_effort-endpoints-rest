package org.erpmicroservices.work_effort.endpoints.rest.models;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "deliverable")
public class Deliverable extends AbstractPersistable<UUID> {

 @NotBlank
 @NotNull
 private String name;

 @NotBlank
 @NotNull
 private String description;

 @NotNull
 @ManyToOne
 @JoinColumn(name = "type_id")
 private DeliverableType type;

 @OneToMany
 @JoinColumn(name = "deliverable_id")
 private List<DeliverableRequirement> requirements = new ArrayList<>();

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public String getDescription() {
	return description;
 }

 public void setDescription(String description) {
	this.description = description;
 }

 public DeliverableType getType() {
	return type;
 }

 public void setType(DeliverableType type) {
	this.type = type;
 }

 public List<DeliverableRequirement> getRequirements() {
	return requirements;
 }

 public void setRequirements(List<DeliverableRequirement> requirements) {
	this.requirements = requirements;
 }
}
