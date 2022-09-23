package com.woc.gms.service;

import com.woc.gms.dto.CustomerPlanDataForAlertDTO;
import com.woc.gms.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMailToUser(UserDTO userDTO, String plainPassword, String customerName) {
       logger.info("about to compose mail to user with credentials and a website link using the data = {}, customerName={}", userDTO, customerName);

        String subject = "WOC GYM Portal Credentials";
        String content = String.format("""
                <pre>
                    Hi %s,
                       Please use the below credentials to login to our portal-
                       website: https://woc-gym.com
                       username: %s
                       password: %s
                       
                       Thanks!
                       WOC GYM Team
                </pre>
                """, customerName, userDTO.getUsername(), plainPassword);

        sendMail(userDTO.getUsername(), subject, content);
    }

    public void sendMail(String toMail, String subject, String mailBodyContent){
        /*try{
            logger.info("send mail request came, toMailId:{}, subject:{}, content:{}", toMail, subject, mailBodyContent);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(toMail);
            mimeMessageHelper.setSubject(subject);
            mimeMessage.setContent(mailBodyContent, "text/html; charset=utf-8");

            javaMailSender.send(mimeMessage);

            logger.info("Mail has been sent toMailId:{}, subject:{}, content:{}", toMail, subject, mailBodyContent);
        }catch (Exception e){
            logger.error("Could not send mail to:{}, subject:{}, content:{}", toMail, subject, mailBodyContent, e);
        }*/
    }

    public void sendPlanExpiryMail(CustomerPlanDataForAlertDTO customerPlanDataForAlertDTO) {
        logger.info("about to compose sendPlanExpiryMail for data={}", customerPlanDataForAlertDTO);

        String subject = "WOC GYM Plan is about to expire";
        String content = String.format("""
                <pre>
                    Hi %s,
                       This is to inform that your plan- %s is expiring on - %s
                       Please recharge any plan to continue over service.
                       
                       website: https://woc-gym.com
                       
                       Thanks!
                       WOC GYM Team
                </pre>
                """, customerPlanDataForAlertDTO.getCustomerName(),
                customerPlanDataForAlertDTO.getPlanName(),
                customerPlanDataForAlertDTO.getPlanExpireOn());

        sendMail(customerPlanDataForAlertDTO.getEmail(), subject, content);
    }
}
