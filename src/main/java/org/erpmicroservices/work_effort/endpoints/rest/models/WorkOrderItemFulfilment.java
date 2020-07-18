package org.erpmicroservices.work_effort.endpoints.rest.models;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Entity(name = "work_order_item_fulfilment")
public class WorkOrderItemFulfilment extends AbstractPersistable<UUID> {

 private UUID orderItemId;


}
