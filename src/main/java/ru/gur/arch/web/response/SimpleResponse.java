package ru.gur.arch.web.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleResponse {

    private final String output;
}
