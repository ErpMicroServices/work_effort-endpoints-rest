package org.erpmicroservices.work_effort.endpoints.rest.models;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "work_effort_type")
public class WorkEffortType extends AbstractPersistable<UUID> {
 @NotBlank
 @NotNull
 private String description;

 @ManyToOne
 private WorkEffortType parent;

 public String getDescription() {
	return description;
 }

 public void setDescription(String description) {
	this.description = description;
 }

 public WorkEffortType getParent() {
	return parent;
 }

 public void setParent(WorkEffortType parent) {
	this.parent = parent;
 }
}
