package com.wildadventures.mscomments.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-comments", url = "localhost:9004")
public interface MsCommentsProxy {
}
