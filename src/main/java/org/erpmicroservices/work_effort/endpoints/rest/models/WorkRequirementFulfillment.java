package org.erpmicroservices.work_effort.endpoints.rest.models;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Entity(name = "work_requirement_fulfillment")
public class WorkRequirementFulfillment extends AbstractPersistable<UUID> {

 private UUID requirementId;
}
