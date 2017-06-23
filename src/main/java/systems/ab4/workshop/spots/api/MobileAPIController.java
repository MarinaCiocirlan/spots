package systems.ab4.workshop.spots.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import systems.ab4.workshop.spots.domain.spot.Activity;
import systems.ab4.workshop.spots.domain.spot.Spot;
import systems.ab4.workshop.spots.domain.spot.SpotRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alexandru Artimon
 * @since 21/06/2017.
 */
@Controller
@RequestMapping("/mobile")
public class MobileAPIController {

    private SpotRepository spotRepository;

    @Autowired
    public MobileAPIController(SpotRepository spotRepository){

        this.spotRepository = spotRepository;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public @ResponseBody List<Spot> search
            (
        @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
        @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate,
        @RequestParam(value = "activities", required = false) List<Activity> activities,
        @RequestParam(value = "location", required = false) Long location
            )
    {
        return spotRepository.findByActivitiesInAndStartSeasonBeforeAndEndSeasonAfterAndLocationIdOrderByCost(activities,startDate,endDate,location);
    }


    public @ResponseBody List<Spot> sayHello(@RequestParam(value="name", required=false) String name) {
        List<Spot> list = new ArrayList<>();
        list.add(spotRepository.findOne(1L));
        return list;
    }


}
