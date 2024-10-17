package com.elqassmi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RecommandationResponse {
    private long recommandationId;
    private long productId;
    private String author;
    private String role;
    private String content;

}
