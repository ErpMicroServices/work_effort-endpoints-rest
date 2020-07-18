package org.erpmicroservices.work_effort.endpoints.rest.models;

import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.UUID;

@Data
@Entity(name = "work_effort_skill_standard")
@TypeDef(
	typeClass = PostgreSQLIntervalType.class,
	defaultForType = Duration.class
)
public class SkillStandard extends AbstractPersistable<UUID> {

 @Min(value = 1)
 private long estimatedNumberOfPeople;

 private Duration estimatedDuration;

 private BigDecimal estimatedCost;

 @ManyToOne
 @JoinColumn(name = "type_id")
 private SkillType type;

}
