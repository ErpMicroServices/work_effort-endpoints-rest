package org.erpmicroservices.work_effort.endpoints.rest.models;

import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

@Data
@Entity(name = "work_effort_fixed_asset_standard")
@TypeDef(
	typeClass = PostgreSQLIntervalType.class,
	defaultForType = Duration.class
)
public class FixedAssetStandard extends AbstractPersistable<UUID> {

 private long estimatedQuantity;

 private Duration estimatedDuration;

 private BigDecimal estimatedCost;

 @ManyToOne
 @JoinColumn(name = "type_id")
 private FixedAssetType type;
}
