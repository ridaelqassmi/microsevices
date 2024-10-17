package com.elqassmi.controller;

import com.elqassmi.dto.request.RecommandationRequest;
import com.elqassmi.dto.response.RecommandationResponse;
import com.elqassmi.services.RecommandationServices;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/recommendations")

public class RecommendationController {
    @Autowired
    RecommandationServices RecommendationService;
    Logger logger = LoggerFactory.getLogger(RecommendationController.class);

    @PostMapping
    public ResponseEntity<Void> addRecommendation(@Valid @RequestBody RecommandationRequest recommandationRequest) {
        logger.info("*****************Location {}", recommandationRequest.toString());
        long id = RecommendationService.addRecommendation(recommandationRequest);
        //logger.info("*************Location : after persistence");
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri ).build();

    }

    @PutMapping("/{RecommendationId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocation(@Valid @RequestBody RecommandationRequest recommandationRequest,
                               @PathVariable("RecommendationId") long RecommendationId) {
        RecommendationService.updateLocation(RecommendationId, recommandationRequest);

    }

    @DeleteMapping("/{RecommendationId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecommendation(@PathVariable("RecommendationId") long RecommendationId) {
        RecommendationService.deleteRecommendation(RecommendationId);
    }

    @GetMapping
    public List<RecommandationResponse> getAllRecommandations() {
        List<RecommandationResponse> allRecommendation = new ArrayList<>();
        allRecommendation= RecommendationService.getAllRecommandation();
        return allRecommendation;

    }

    @GetMapping("/{RecommendationId}")
    public ResponseEntity<RecommandationResponse> getRecommandationById(@PathVariable("RecommendationId") long RecommendationId) {

        RecommandationResponse product = RecommendationService.getRecommendationById(RecommendationId);
        return ResponseEntity.ok().body(product);
    }






}
