package com.elqassmi.controller;

import com.elqassmi.dao.ReviewRepository;
import com.elqassmi.dto.response.ReviewResponse;
import com.elqassmi.services.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ReviewProductController {

    @Autowired
    private ReviewServices reviewServices;

    @GetMapping("/{id}/reviews")
    public List<ReviewResponse> getAllReviewByProductId(@PathVariable long id){
        return reviewServices.getAllReviewByProductId(id);

    }
}
