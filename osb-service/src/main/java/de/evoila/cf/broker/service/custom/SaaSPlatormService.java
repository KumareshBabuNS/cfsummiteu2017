package de.evoila.cf.broker.service.custom;

import de.evoila.cf.broker.exception.PlatformException;
import de.evoila.cf.broker.model.Plan;
import de.evoila.cf.broker.model.Platform;
import de.evoila.cf.broker.model.ServiceDefinition;
import de.evoila.cf.broker.model.ServiceInstance;
import de.evoila.cf.broker.repository.PlatformRepository;
import de.evoila.cf.broker.service.CatalogService;
import de.evoila.cf.broker.service.PlatformService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;

public class SaaSPlatormService implements PlatformService {

    @Autowired
    private CatalogService catalogService;

    @Autowired(required = false)
    private PlatformRepository platformRepository;

    @Override
    public void registerCustomPlatformService () {
        platformRepository.addPlatform(Platform.SAAS, this);
    }

    @Override
    public boolean isSyncPossibleOnCreate (Plan plan) {
        return true;
    }

    @Override
    public boolean isSyncPossibleOnDelete (ServiceInstance instance) {
        return true;
    }

    @Override
    public boolean isSyncPossibleOnUpdate (ServiceInstance instance, Plan plan) {
        return false;
    }

    @Override
    public ServiceInstance postProvisioning (ServiceInstance serviceInstance, Plan plan) throws PlatformException {
        return serviceInstance;
    }

    @Override
    public void preDeprovisionServiceInstance (ServiceInstance serviceInstance) {

    }

    @Override
    public ServiceInstance createInstance (ServiceInstance instance, Plan plan, Map<String, String> customParameters) throws PlatformException {
        final Map<String, Object> metadata = plan.getMetadata();
        final String PROVIDER = "provider";
        final boolean isProviderPlan = metadata.containsKey(PROVIDER);
        if(isProviderPlan && metadata.get(PROVIDER).equals("true") && customParameters.containsKey("url")){
            String appUrl = customParameters.get("url");

            ServiceDefinition serviceDefinition = new ServiceDefinition();
            serviceDefinition.setId(UUID.randomUUID().toString());
            serviceDefinition.setBindable(true);
            serviceDefinition.setDescription("");
            serviceDefinition.setName(appUrl);

            Plan servicePlan = new Plan();
            servicePlan.setId(UUID.randomUUID().toString());
            servicePlan.setName(appUrl);
            servicePlan.setPlatform(Platform.SAAS);
            plan.setMetadata(Maps.newHashMap("url", appUrl));
            serviceDefinition.getPlans().add(servicePlan);

            catalogService.getCatalog().getServices().add(serviceDefinition);
        } else if(!isProviderPlan) {
            return instance;
        }
        throw new PlatformException("Not support because not cool of you.");
    }

    @Override
    public ServiceInstance getCreateInstancePromise (ServiceInstance instance, Plan plan) {
        return instance;
    }

    @Override
    public void deleteServiceInstance (ServiceInstance serviceInstance) throws PlatformException {

    }

    @Override
    public ServiceInstance updateInstance (ServiceInstance instance, Plan plan) {
        return instance;
    }
}
