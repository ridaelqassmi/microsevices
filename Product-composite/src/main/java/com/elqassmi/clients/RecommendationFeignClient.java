package com.elqassmi.clients;

import com.elqassmi.dto.request.RecommandationRequest;
import com.elqassmi.dto.response.RecommandationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RECOMMANDATION-MICROSERVICES", url = "http://localhost:7003")
public interface RecommendationFeignClient {

    @PostMapping("/api/recommendations")
    public ResponseEntity<Void> addRecommendation(@RequestBody RecommandationRequest recommandationRequest);

    @PutMapping("/api/recommendations/{RecommendationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@RequestBody RecommandationRequest recommandationRequest,
                               @PathVariable("RecommendationId") long RecommendationId);

    @DeleteMapping("/api/recommendations/{RecommendationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecommendation(@PathVariable("RecommendationId") long RecommendationId);

    @GetMapping("/api/recommendations")
    public List<RecommandationResponse> getAllRecommandations();

    @GetMapping("/api/products/{id}/recommendations")
    public List<RecommandationResponse> getRecommendation(@PathVariable long id) ;

}
