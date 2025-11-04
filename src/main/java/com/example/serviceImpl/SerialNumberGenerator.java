package com.example.serviceImpl;
import java.time.LocalDate;
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
}
