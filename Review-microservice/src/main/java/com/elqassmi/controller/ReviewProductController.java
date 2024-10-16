package com.elqassmi.controller;

import com.elqassmi.dao.ReviewRepository;
import com.elqassmi.dto.response.ReviewResponse;
import com.elqassmi.services.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("api/products/{id}/reviews")
public class ReviewProductController {

    @Autowired
    private ReviewServices reviewServices;


    public List<ReviewResponse> getAllReviewByProductId(@PathVariable long id){
        return reviewServices.getAllReviewByProductId(id);

    }
}
