package org.erpmicroservices.work_effort.endpoints.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "work_effort")
public class WorkEffort extends AbstractPersistable<UUID> {

 @NotBlank
 @NotNull
 private String name;

 private String description;

 @Column(name = "scheduled_start_date", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate scheduledStartDate;

 @Column(name = "scheduled_completion_date", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate scheduledCompletionDate;

 private BigDecimal totalExpenditureAllowed;

 private Long totalHoursAllowed;

 private Long estimatedHours;

 @Column(name = "actual_start", columnDefinition = "timestamp")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
 @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
 private LocalDateTime actualStart;

 private BigDecimal actualHours;

 private String specialTerms;

 private Long quantityToProduce;

 private Long quantityProduced;

 private Long quantityRejected;

 @ManyToOne
 @JoinColumn(name = "type_id")
 private WorkEffortType type;

 @OneToMany
 @JoinColumn(name = "parent_id")
 private List<WorkEffort> workEfforts = new ArrayList<>();

 @ManyToOne
 private WorkEffort parent;

 @ManyToOne
 @JoinColumn(name = "work_effort_purpose_type_id")
 private WorkEffortPurposeType purpose;

 private UUID facilityId;

 @OneToMany
 @JoinColumn(name = "work_effort_id")
 private List<WorkOrderItemFulfilment> orderItemFullfillments = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_id")
 private List<WorkRequirementFulfillment> workRequirementFulfillments = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "associated_from_id")
 private List<WorkEffortAssociation> workEffortAssociationFrom = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "associated_to_id")
 private List<WorkEffortAssociation> workEffortAssociationTo = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "version_of_id")
 private List<WorkEffort> redones = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_id")
 private List<PartyAssignment> partyAssignments = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_id")
 private List<TimeEntry> timeEntries = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_id")
 private List<FixedAssetAssignment> fixedAssetAssignments = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_id")
 private List<InventoryProduced> inventoryProducedList = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_id")
 private List<DeliverableProduced> deliverableProducedListProducedList = new ArrayList<>();
}
