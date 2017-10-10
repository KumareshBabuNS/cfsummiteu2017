package de.evoila.cf.broker.service.custom;

import de.evoila.cf.broker.exception.*;
import de.evoila.cf.broker.model.ServiceInstanceBinding;
import de.evoila.cf.broker.model.ServiceInstanceBindingResponse;
import de.evoila.cf.broker.repository.BindingRepository;
import de.evoila.cf.broker.repository.ServiceInstanceRepository;
import de.evoila.cf.broker.service.BindingService;
import de.evoila.cf.broker.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SaaSBindingService implements BindingService{
    @Autowired
    CatalogService catalogService;
    @Autowired
    ServiceInstanceRepository repository;
    @Autowired
    BindingRepository bindingRepository;


    @Override
    public ServiceInstanceBindingResponse createServiceInstanceBinding (String bindingId, String instanceId, String serviceId, String planId, boolean generateServiceKey, String route) throws ServiceInstanceBindingExistsException, ServiceBrokerException, ServiceInstanceDoesNotExistException, ServiceDefinitionDoesNotExistException {
        String serviceDefinitionId = repository.getServiceInstance(instanceId).getServiceDefinitionId();
        Map<String, Object> credentials = catalogService.getServiceDefinition(serviceDefinitionId).getMetadata();
        ServiceInstanceBinding serviceBinding = new ServiceInstanceBinding(bindingId,instanceId,credentials,null);
        bindingRepository.addInternalBinding(serviceBinding);
        return new ServiceInstanceBindingResponse(serviceBinding);
    }

    @Override
    public ServiceInstanceBinding getServiceInstanceBinding (String id) {
        ServiceInstanceBinding binding = bindingRepository.findOne(id);
        return binding;
    }

    @Override
    public void deleteServiceInstanceBinding (String id) throws ServiceBrokerException, ServerviceInstanceBindingDoesNotExistsException {
        bindingRepository.deleteBinding(id);
    }
}
