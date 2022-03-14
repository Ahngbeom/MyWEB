package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.mapper.UtilMapper;

@Service
public class UtilServiceImpl implements UtilService {

    private final UtilMapper mapper;

    public UtilServiceImpl(UtilMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String getTime() {
        return mapper.getTime();
    }
}
