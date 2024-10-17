package com.elqassmi.controllers;

import com.elqassmi.clients.RecommendationFeignClient;
import com.elqassmi.dto.request.RecommandationRequest;
import com.elqassmi.dto.response.RecommandationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/composite/recommandations")
public class ProductCompositeRecommendationController {
    @Autowired
    RecommendationFeignClient recommendationFeignClient;

    @PostMapping
    public ResponseEntity<Void> addRecommendation(@RequestBody RecommandationRequest recommandationRequest){
        return recommendationFeignClient.addRecommendation(recommandationRequest);
    }

    @PutMapping("/{RecommendationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@RequestBody RecommandationRequest recommandationRequest,
                               @PathVariable("RecommendationId") long RecommendationId){
        recommendationFeignClient.updateLocation(recommandationRequest, RecommendationId);
    }

    @DeleteMapping("/{RecommendationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecommendation(@PathVariable("RecommendationId") long RecommendationId){
        recommendationFeignClient.deleteRecommendation(RecommendationId);
    }

    @GetMapping
    public List<RecommandationResponse> getAllRecommandations(){
        return recommendationFeignClient.getAllRecommandations();
    }
}
