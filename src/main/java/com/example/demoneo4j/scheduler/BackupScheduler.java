package com.example.demoneo4j.scheduler;

import com.example.demoneo4j.service.ExportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class BackupScheduler {

    private final ExportService exportService;

    @Scheduled(cron = "${export.scheduler}")
    public void exportDataBase() {
        log.info("Export data base, date: {}", LocalDate.now());
        exportService.exportDataBase();
    }

}
