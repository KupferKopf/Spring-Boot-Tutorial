package com.KupferKopf.Springboot.tutorial.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap<>();

    public FeatureEndpoint(){
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return  featureMap;
    }


    @ReadOperation
    public Feature feature(@Selector String featurName){
        return featureMap.get(featurName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class Feature {
        private boolean isEnabled;

    }
}
