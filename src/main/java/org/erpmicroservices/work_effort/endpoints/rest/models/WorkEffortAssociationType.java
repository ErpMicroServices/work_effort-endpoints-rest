package org.erpmicroservices.work_effort.endpoints.rest.models;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "work_effort_association_type")
public class WorkEffortAssociationType extends AbstractPersistable<UUID> {
 @NotBlank
 @NotNull
 private String description;

 @ManyToOne
 private WorkEffortAssociationType parent;

 public String getDescription() {
	return description;
 }

 public void setDescription(String description) {
	this.description = description;
 }

 public WorkEffortAssociationType getParent() {
	return parent;
 }

 public void setParent(WorkEffortAssociationType parent) {
	this.parent = parent;
 }
}
