package org.erpmicroservices.work_effort.endpoints.rest.models;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "work_effort_type")
public class WorkEffortType extends AbstractPersistable<UUID> {
 @NotBlank
 @NotNull
 private String description;

 @ManyToOne
 private WorkEffortType parent;

 @OneToMany
 @JoinColumn(name = "from_work_effort_type_id")
 private List<WorkEffortTypeAssociation> fromAssociation;

 @OneToMany
 @JoinColumn(name = "to_work_effort_type_id")
 private List<WorkEffortTypeAssociation> toAssociation;

 @OneToMany
 @JoinColumn(name = "work_effort_type_id")
 private List<SkillStandard> skillStandards = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_type_id")
 private List<GoodStandard> goodStandards = new ArrayList<>();

 @OneToMany
 @JoinColumn(name = "work_effort_type_id")
 private List<FixedAssetStandard> fixedAssetStandards = new ArrayList<>();

 @ManyToOne
 @JoinColumn(name = "fixed_asset_type_id")
 private FixedAssetType usedToRepair;

 @ManyToOne
 @JoinColumn(name = "deliverable_type_id")
 private DeliverableType produces;


 private UUID producesGoodId;
}
