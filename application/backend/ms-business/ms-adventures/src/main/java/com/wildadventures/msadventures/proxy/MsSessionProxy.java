package com.wildadventures.msadventures.proxy;

import com.wildadventures.msadventures.bean.SessionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-sessions", url = "localhost:9002")
public interface MsSessionProxy {

    @GetMapping(value = "/api/sessions")
    List<SessionBean> getSessions();

    @GetMapping(value = "/api/sessions/{id}")
    Optional<SessionBean> getSession(@PathVariable("id") Integer id);
}
