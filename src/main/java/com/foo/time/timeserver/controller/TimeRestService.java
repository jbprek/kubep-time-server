package com.foo.time.timeserver.controller;


import com.foo.time.timeserver.conf.TimeServerConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.ZoneId;

@RestController
@RequestMapping("/timeservices")
public class TimeRestService {

    private TimeServerConfiguration configuration;

    private ZoneId defaultZoneId;

    public TimeRestService(TimeServerConfiguration configuration) {
        this.configuration = configuration;
    }

    @PostConstruct
    public void setup(){
        defaultZoneId = ZoneId.of(configuration.getDefaultTimeZone());
    }

    @GetMapping("/now")
    ResponseEntity<TimeInfoDto> now() {
        return ResponseEntity.ok(TimeInfoDto.now(defaultZoneId));
    }

}
