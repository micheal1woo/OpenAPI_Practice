package com.book.bookprac.jumoon;

import org.springframework.stereotype.Service;

@Service
public class JumoonService {

    private final JumoonRepository jumoonRepository;

    public JumoonService(JumoonRepository jumoonRepository) {
        this.jumoonRepository = jumoonRepository;
    }

}
