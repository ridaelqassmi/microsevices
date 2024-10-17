package com.elqassmi.controller;

import com.elqassmi.dto.response.RecommandationResponse;
import com.elqassmi.services.RecommandationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class RecommendationProductController {

    @Autowired
    private RecommandationServices recommendationServices;
    @GetMapping("/{id}/recommendations")
    public List<RecommandationResponse> getRecommendation(@PathVariable long id) {
        return recommendationServices.getRecommendationByProductID(id);

    }


}
