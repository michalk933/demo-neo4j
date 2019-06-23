package com.example.demoneo4j.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Configuration
@ConfigurationProperties("export")
public class ExportProperties {

    @NotBlank
    private String path;

    public String getFullPath(final String fileName){
        return String.format("%1$s/%2$s/%3$s", this.path, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")), fileName);
    }

}
