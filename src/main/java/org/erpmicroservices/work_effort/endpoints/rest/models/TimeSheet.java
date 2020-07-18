package org.erpmicroservices.work_effort.endpoints.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "time_sheet")
public class TimeSheet extends AbstractPersistable<UUID> {
 @Column(name = "from_date", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate fromDateTime;

 @Column(name = "thru_date", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate thruDateTime;

 private String comment;

 @OneToMany
 @JoinColumn(name = "time_sheet_id")
 private List<TimeEntry> timeEntries = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "time_sheet_id")
 private List<TimeSheetRole> roles;

 private UUID partyRoleId;
}
