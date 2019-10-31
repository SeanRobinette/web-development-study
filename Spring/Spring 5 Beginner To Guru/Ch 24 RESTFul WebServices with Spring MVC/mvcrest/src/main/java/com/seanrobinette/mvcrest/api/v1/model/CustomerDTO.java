package com.seanrobinette.mvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
    @ApiModelProperty(value = "The customer's first name", required = true)
    private String firstName;
    @ApiModelProperty(required = true)
    private String lastName;

    @JsonProperty("customer_url")
    private String customerUrl;
}
