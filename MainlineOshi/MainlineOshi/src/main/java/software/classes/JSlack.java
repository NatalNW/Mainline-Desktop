package software.classes;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSlack {
    
    public void usuarioLogado(String nomeUser){
        String url = "https://hooks.slack.com/services/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";

        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text("Usuário "+nomeUser+" logou!")
                .build();

        Slack slack = Slack.getInstance();
        try {
            System.out.println("Foi!");
            WebhookResponse response = slack.send(url, payload);
        } catch (IOException ex) {
            System.out.println("Não foi");
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void alertaComponente(String componente){
        String url = "https://hooks.slack.com/services/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";

        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text(componente+" está a cima do limite")
                .build();

        Slack slack = Slack.getInstance();
        try {
            System.out.println("Foi!");
            WebhookResponse response = slack.send(url, payload);
        } catch (IOException ex) {
            System.out.println("Não foi");
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
