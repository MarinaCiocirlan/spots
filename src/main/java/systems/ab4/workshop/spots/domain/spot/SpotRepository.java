package systems.ab4.workshop.spots.domain.spot;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Alexandru Artimon
 * @since 19/06/2017.
 */
@RepositoryRestResource
public interface SpotRepository extends CrudRepository<Spot, Long> {
    List<Spot> findByActivitiesInAndStartSeasonBeforeAndEndSeasonAfterAndLocationIdOrderByCost ( @Param("activities") List<Activity> activities, @Param("startSeason") Date startSeason ,@Param("endSeason") Date endSeason ,@Param("location") Long location);
}


