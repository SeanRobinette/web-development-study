package com.seanrobinette.mvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VendorDTO {
    @ApiModelProperty(value = "The name of the vendor", required = true)
    private String name;

    @ApiModelProperty(value = "The url to retrieve more information about the vendor")
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
