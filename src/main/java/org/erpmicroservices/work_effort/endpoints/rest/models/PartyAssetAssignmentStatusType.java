package org.erpmicroservices.work_effort.endpoints.rest.models;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity(name = "party_asset_assignment_status_type")
public class PartyAssetAssignmentStatusType extends AbstractPersistable<UUID> {
 @NotBlank
 @NotNull
 private String description;

 @ManyToOne
 private PartyAssetAssignmentStatusType parent;

 public String getDescription() {
	return description;
 }

 public void setDescription(String description) {
	this.description = description;
 }

 public PartyAssetAssignmentStatusType getParent() {
	return parent;
 }

 public void setParent(PartyAssetAssignmentStatusType parent) {
	this.parent = parent;
 }
}
