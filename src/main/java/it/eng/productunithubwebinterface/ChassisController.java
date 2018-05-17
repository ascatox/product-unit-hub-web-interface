package it.eng.productunithubwebinterface;


import it.eng.productunithubledgerclient.base.LedgerClient;
import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.ProcessStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Random;

@RequestMapping("/api")
@RestController
public class ChassisController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Random random = new Random(10000);

    @Autowired
    LedgerClient ledgerClient;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() {
        logger.info("-----------------STARTING TEST at " + System.currentTimeMillis());
        return "start";
    }

    @RequestMapping(value = "/end", method = RequestMethod.GET)
    public String end() {
        logger.info("----------------ENDING TEST at " + System.currentTimeMillis());
        return "end";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Collection<ProcessStep> getProcessStep(@RequestParam(value = "id") String chassisID,
                                                  @RequestParam(value = "component") String component,
                                                  @RequestParam(value = "subComponent") String subComponent) throws ProductUnitHubException {
        return ledgerClient.getProcessStep(chassisID, component, subComponent);

    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ResponseEntity<?> storeProcessStepRouting(@RequestBody String chassisDTOs) throws ProductUnitHubException {
        ledgerClient.storeProcessStepRouting(chassisDTOs);
        return ResponseEntity.ok().build();
    }

    private int getNextRandom() {
        return Math.abs(random.nextInt());
    }

}

