package org.erpmicroservices.work_effort.endpoints.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "fixed_asset")
public class FixedAsset extends AbstractPersistable<UUID> {
 @NotBlank
 @NotNull
 private String name;

 @Column(name = "date_acquired", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate dateAcquired;

 @Column(name = "date_last_serviced", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate dateLastServiced;

 @Column(name = "date_next_service", columnDefinition = "DATE")
 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
 @JsonFormat(pattern = "yyyy-MM-dd")
 private LocalDate dateNextService;

 private Long productionCapacity;

 private String description;

 private UUID unitOfMeasureId;

 @ManyToOne
 @JoinColumn(name = "type_id")
 private FixedAssetType type;

 @OneToMany
 @JoinColumn(name = "fixed_asset_id")
 private List<FixedAssetRequirement> requirements = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "fixed_asset_id")
 private List<FixedAssetAssignment> assignments = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "fixed_asset_id")
 private List<PartyFixedAssetAssignment> assignedTo = new ArrayList<>();
}
