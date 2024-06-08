package com.apicurriculo.apicurriculosb.dto;

import java.time.ZonedDateTime;

public record StandardErrorDto(
        Integer status,
        String error,
        String message,
        ZonedDateTime timeStamp,
        String path
) {
}
