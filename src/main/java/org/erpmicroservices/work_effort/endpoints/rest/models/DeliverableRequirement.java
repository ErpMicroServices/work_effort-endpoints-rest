package org.erpmicroservices.work_effort.endpoints.rest.models;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class DeliverableRequirement extends AbstractPersistable<UUID> {

 @NotNull
 private UUID requirement_id;

 public UUID getRequirement_id() {
	return requirement_id;
 }

 public void setRequirement_id(UUID requirement_id) {
	this.requirement_id = requirement_id;
 }
}
