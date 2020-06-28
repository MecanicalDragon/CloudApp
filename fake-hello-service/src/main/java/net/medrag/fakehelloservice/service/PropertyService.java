package net.medrag.fakehelloservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * {@author} Stanislav Tretyakov
 * 06.02.2020
 */
@RefreshScope   // Determines that properties, declared here can be fetched and refreshed
@Service
public class PropertyService {

    @Value("${hello.app.message:Hello default}")
    private String message;

    @Value("${hello.app.info:Info default}")
    private String info;

    public String getMessage() {
        return message;
    }

    public String getInfo() {
        return info;
    }
}
