package com.wildadventures.mssession.proxy;

import com.wildadventures.mssession.bean.AdventureBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-adventure")
public interface MsAdventureProxy {

    @GetMapping(value = "/api/adventures")
    List<AdventureBean> getAdventures();

    @GetMapping(value = "/api/adventures/adventure/{id}")
    Optional<AdventureBean> getOneAdventure(@PathVariable("id") Integer id);
}