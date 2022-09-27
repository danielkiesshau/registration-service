package com.br.healthCare.registrationService.infra.helpers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IterableHelper<T> {
    public List<T> toList(Iterable<T> iterable) {
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
