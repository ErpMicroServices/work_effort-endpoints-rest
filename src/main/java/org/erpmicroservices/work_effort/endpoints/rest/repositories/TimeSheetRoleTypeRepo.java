package org.erpmicroservices.work_effort.endpoints.rest.repositories;

import org.erpmicroservices.work_effort.endpoints.rest.models.TimeSheetRoleType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface TimeSheetRoleTypeRepo extends PagingAndSortingRepository<TimeSheetRoleType, UUID> {

}
