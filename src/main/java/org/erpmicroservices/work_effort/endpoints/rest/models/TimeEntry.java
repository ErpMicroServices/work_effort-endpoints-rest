package org.erpmicroservices.work_effort.endpoints.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity(name = "time_entry")
@TypeDef(
  typeClass = PostgreSQLIntervalType.class,
  defaultForType = Duration.class
)
public class TimeEntry extends AbstractPersistable<UUID> {

 @Column(name = "from_date_time", columnDefinition = "TIMESTAMP")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
 private LocalDate fromDateTime;

 @Column(name = "thru_date_time", columnDefinition = "TIMESTAMP")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
 private LocalDate thruDateTime;

 private Duration hours;

 private String comment;
}
