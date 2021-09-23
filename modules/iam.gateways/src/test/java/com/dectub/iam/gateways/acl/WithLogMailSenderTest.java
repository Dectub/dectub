package com.dectub.iam.gateways.acl;

import org.junit.jupiter.api.Test;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class WithLogMailSenderTest {
    @Test
    void should_log_failures_when_failed_to_send_emails() throws AddressException {
        JavaMailSender mailSender = mock(JavaMailSender.class);
        MimeMessage message = mock(MimeMessage.class);
        Address[] invalid = {new InternetAddress("a@b.com"), new InternetAddress("b@c.com")};
        MailSendException underlyingException = new MailSendException(Map.of("test", new SendFailedException("fail", null, new Address[0], new Address[0], invalid)));
        doThrow(underlyingException).when(mailSender).send(message);
        Logger logger = mock(Logger.class);
        Throwable throwable = catchThrowable(() -> new WithLogMailSender(mailSender, logger).send(message));
        assertThat(throwable).isEqualTo(underlyingException);
        then(logger).should().warning("Invalid mail addresses: a@b.com, b@c.com");
    }
}
