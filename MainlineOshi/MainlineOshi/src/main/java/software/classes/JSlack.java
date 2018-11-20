package software.classes;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSlack {

    private final String url = "https://hooks.slack.com/services/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";

    public void usuarioLogado(String nomeUser) {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text("Usuário " + nomeUser + " logou...")
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alertaComponente(String componente) {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text(componente + " está acima do limite!!")
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void capturaIniciada(String idAtivo) {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text("A captura de dados foi iniciada no ativo referente a este ID: "+idAtivo)
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fimCaptura() {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text("Captura finalizada! Programa foi fechado.")
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
