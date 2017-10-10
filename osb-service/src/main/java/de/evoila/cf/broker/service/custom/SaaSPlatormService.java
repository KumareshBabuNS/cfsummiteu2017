package de.evoila.cf.broker.service.custom;

import de.evoila.cf.broker.exception.PlatformException;
import de.evoila.cf.broker.model.Plan;
import de.evoila.cf.broker.model.ServiceInstance;
import de.evoila.cf.broker.service.PlatformService;

import java.util.Map;

public class SaaSPlatormService implements PlatformService {


    @Override
    public void registerCustomPlatformService () {

    }

    @Override
    public boolean isSyncPossibleOnCreate (Plan plan) {
        return false;
    }

    @Override
    public boolean isSyncPossibleOnDelete (ServiceInstance instance) {
        return false;
    }

    @Override
    public boolean isSyncPossibleOnUpdate (ServiceInstance instance, Plan plan) {
        return false;
    }

    @Override
    public ServiceInstance postProvisioning (ServiceInstance serviceInstance, Plan plan) throws PlatformException {
        return null;
    }

    @Override
    public void preDeprovisionServiceInstance (ServiceInstance serviceInstance) {

    }

    @Override
    public ServiceInstance createInstance (ServiceInstance instance, Plan plan, Map<String, String> customParameters) throws PlatformException {
        if(customParameters.containsKey()){

        }
        return null;
    }

    @Override
    public ServiceInstance getCreateInstancePromise (ServiceInstance instance, Plan plan) {
        return null;
    }

    @Override
    public void deleteServiceInstance (ServiceInstance serviceInstance) throws PlatformException {

    }

    @Override
    public ServiceInstance updateInstance (ServiceInstance instance, Plan plan) {
        return null;
    }
}
