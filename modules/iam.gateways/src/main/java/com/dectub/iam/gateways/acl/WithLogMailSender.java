package com.dectub.iam.gateways.acl;

import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WithLogMailSender {
    private final JavaMailSender javaMailSender;
    private final Logger log;

    public WithLogMailSender(JavaMailSender javaMailSender, Logger log) {
        this.javaMailSender = javaMailSender;
        this.log = log;
    }

    public void send(MimeMessage message) {
        try {
            javaMailSender.send(message);
        } catch (MailSendException e) {
            log.warning("Invalid mail addresses: " + invalidMailAddresses(e));
            throw e;
        }
    }

    private String invalidMailAddresses(MailSendException e) {
        List<Address> exceptions = new ArrayList<>();
        allSendFailedExceptions(e).forEach(x -> exceptions.addAll(List.of(x.getInvalidAddresses())));
        return exceptions.stream().map(Address::toString).collect(Collectors.joining(", "));
    }

    private Stream<SendFailedException> allSendFailedExceptions(MailSendException e) {
        return e.getFailedMessages().values().stream().filter(SendFailedException.class::isInstance).map(SendFailedException.class::cast);
    }
}
