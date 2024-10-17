package com.elqassmi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RecommandationRequest {
    private long recommendationId;

    private long productId;
    private String author;
    private String role;
    private String content;
}
