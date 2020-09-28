package com.wildadventures.msreservations.proxy;

import com.wildadventures.msreservations.bean.AdventureBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ms-zuul-server")
public interface MsOrderProxy {

    // Test Feign
    @GetMapping(value = "/api/adventures")
    List<AdventureBean> getAllAventures();
}
