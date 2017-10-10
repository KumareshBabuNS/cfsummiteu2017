package de.evoila.cf.broker.service.custom;

import de.evoila.cf.broker.exception.*;
import de.evoila.cf.broker.model.ServiceInstanceBinding;
import de.evoila.cf.broker.model.ServiceInstanceBindingResponse;
import de.evoila.cf.broker.service.BindingService;

public class SaaSBindingService implements BindingService{
    @Override
    public ServiceInstanceBindingResponse createServiceInstanceBinding (String bindingId, String instanceId, String serviceId, String planId, boolean generateServiceKey, String route) throws ServiceInstanceBindingExistsException, ServiceBrokerException, ServiceInstanceDoesNotExistException, ServiceDefinitionDoesNotExistException {
        return null;
    }

    @Override
    public ServiceInstanceBinding getServiceInstanceBinding (String id) {
        return null;
    }

    @Override
    public void deleteServiceInstanceBinding (String id) throws ServiceBrokerException, ServerviceInstanceBindingDoesNotExistsException {

    }
}
