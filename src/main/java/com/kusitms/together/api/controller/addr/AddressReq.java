package com.kusitms.together.api.controller.addr;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddressReq {
    private BigDecimal lat;
    private BigDecimal lng;
}
