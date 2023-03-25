package com.kusitms.together.api.controller.addr;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("addr")
public class AddrController {

    private final NaverGeoApi naverGeoApi;

    @ResponseBody
    @PostMapping("/get")
    public ResponseEntity<String> getAddr(@RequestBody AddressReq addressReq) throws Exception {
        return ResponseEntity.ok(naverGeoApi.getAddr(addressReq.getLat().toString(), addressReq.getLng().toString()));
    }

}
