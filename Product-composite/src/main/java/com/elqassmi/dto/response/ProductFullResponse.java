package com.elqassmi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFullResponse {
    private Long id;

    private String name;
    private long Weight;
    private List<RecommandationResponse> recommandations;
    private List<ReviewResponse> reviews;
}
