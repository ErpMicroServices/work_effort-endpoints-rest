package org.erpmicroservices.work_effort.endpoints.rest.models;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity(name = "work_effort_deliverable_produced")
public class DeliverableProduced extends AbstractPersistable<UUID> {

 @ManyToOne
 @JoinColumn(name = "deliverable_id")
 private Deliverable deliverable;

}
