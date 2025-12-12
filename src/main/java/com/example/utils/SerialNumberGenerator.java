package com.example.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SerialNumberGenerator {
    public String generateSerialNumber() {
        // 获取当前日期并格式化为 YYYYMMDD
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String datePart = currentDate.format(formatter);

        // 获取当前时间的时间戳（毫秒级）
        long timestamp = System.currentTimeMillis();

        // 组合日期和时间戳
        return datePart + timestamp;
    }

    public String getCurrentTime() {
        // 获取当前日期并格式化为 YYYYMMDD
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = localDateTime.format(formatter);
        // 组合日期和时间戳
        return dateTime;
    }
}
