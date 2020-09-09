package com.iulia.gardener.notification

import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.IOException;
import java.lang.System.*

@Component
class MailSender(
        private val sendGridVerifiedEmail: Email,
        private val sendGrid: SendGrid
) {

    fun sendEmail(mail: Mail) {
        var request = Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            var response = sendGrid.api(request);
            println(response.statusCode);
            println(response.body);
            println(response.headers);
        } catch (ex: IOException) {
            throw ex;
        }
    }

    fun composeSoilMoistureTooLowEmail(userEmail: String, gardenerName: String, specimenName: String): Mail {
        println("Compose email to ${userEmail} from gardener ${gardenerName} for specimen ${specimenName} from ${sendGridVerifiedEmail.email}")
        var to = Email(userEmail)
        var subject = "Soil moisture is too low for $specimenName";
        var content = Content("text/plain", "Soil moisture registered by $gardenerName seems to have been too low for the last " +
                "measurements we did. Most likely the water recipient needs a refill. If that's not the case, please check the pump is still working and " +
                "the hose is attached. If they are fine, take a look at the plant configuration for the soil moisture level. This value should be 100% for plants " +
                "that are grown in water (like an avocado seed) and 50% for plants that are grown in a dry soil, like a cactus.");
        return Mail(sendGridVerifiedEmail, subject, to, content);
    }
}

