package de.evoila.cf.broker.service.custom;

import de.evoila.cf.broker.model.Plan;
import de.evoila.cf.broker.model.ServiceInstance;
import de.evoila.cf.cpi.custom.props.DomainBasedCustomPropertyHandler;

import java.util.Map;

public class ExampleCustomPropertyHandler implements DomainBasedCustomPropertyHandler {
    @Override
    public Map<String, String> addDomainBasedCustomProperties (Plan plan, Map<String, String> customProperties, ServiceInstance serviceInstance) {
        return customProperties;
    }
}
