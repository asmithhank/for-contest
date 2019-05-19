import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import static spark.Spark.*;
import spark.Spark;

import static spark.Spark.get;
import static spark.Spark.post;

public class SMSBackend
{
    public static void main(String[] args) {
        /*TwilioRestClient client = new TwilioRestClient.Builder("ACae57562a461badf8207d0569ec4e77f6", "365fa87062308324853097734d8779fd").build();

        post("/sms", (req, res) -> {
            String body = req.queryParams("Body");
            String to = req.queryParams("To");
            String from = "+12063396950";

            Message message = new MessageCreator(
                    new PhoneNumber(to),
                    new PhoneNumber(from),
                    body).create(client);

            return (message.getSid());
        });*/
        String ACCOUNT_SID = "ACae57562a461badf8207d0569ec4e77f6";
        String AUTH_TOKEN = "365fa87062308324853097734d8779fd";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        post("/sms", (req, res) -> {

            String body = req.queryParams("Body");
            String to = req.queryParams("To");
            String from = "+12063396950";


            Message message = Message
                    .creator(new PhoneNumber(to), // to
                            new PhoneNumber(from), // from
                            body)
                    .create();

            return(message.getSid());

        });
    }
}
