package com.foo.time.timeserver.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.foo.time.timeserver")
@Data
public class TimeServerConfiguration {

    private String defaultTimeZone = "UTC";
}
