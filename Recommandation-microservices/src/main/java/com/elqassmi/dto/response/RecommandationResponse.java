package com.elqassmi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommandationResponse {

    private long recommendationId;

    private long productId;
    private String author;
    private String role;
    private String content;
}
