package org.erpmicroservices.work_effort.endpoints.rest.models;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "work_effort_good_standard")
public class GoodStandard extends AbstractPersistable<UUID> {

 @Min(value = 1)
 private long estimatedQuantity;

 private BigDecimal estimatedCost;

 @NotNull
 private UUID goodId;
}
