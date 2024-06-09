package com.example.gatewayserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController
{
    @RequestMapping(value = "/contactSupport", method = RequestMethod.GET)
  public Mono<String> contactSupport()
  {
      return Mono.just("An error occurred, please try after sometime");
  }

}
