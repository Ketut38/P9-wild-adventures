package com.wildadventures.msreservations.proxy;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "ms-adventure", url = "localhost:9001")
public interface MsAdventureProxy {
}