package org.erpmicroservices.work_effort.endpoints.rest.models;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity(name = "time_sheet_role")
public class TimeSheetRole extends AbstractPersistable<UUID> {

 @ManyToOne
 @JoinColumn(name = "time_sheet_role_type_id")
 private TimeSheetRoleType type;

 private UUID partyId;
}
