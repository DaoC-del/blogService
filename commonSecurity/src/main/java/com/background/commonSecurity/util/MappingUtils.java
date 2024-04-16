package com.background.commonSecurity.util;

import org.modelmapper.ModelMapper;

public class MappingUtils {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D, E> E map(D source, Class<E> destinationType) {
        return modelMapper.map(source, destinationType);
    }
}