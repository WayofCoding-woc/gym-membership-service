package com.woc.gms.service;

import com.woc.gms.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void sendMailToUser(UserDTO userDTO) {
        logger.info("TODO: need to compose mail to user with credentials and a website link using the data = {}", userDTO);
    }
}
