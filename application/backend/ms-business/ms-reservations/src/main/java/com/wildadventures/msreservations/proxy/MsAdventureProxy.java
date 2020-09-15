package com.wildadventures.msreservations.proxy;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "ms-zuul-server")
public interface MsAdventureProxy {
}