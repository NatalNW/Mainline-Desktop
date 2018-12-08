package software.classes;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSlack {

    private final arquivoLog arq = new arquivoLog();
    private final String quebraLinha = System.getProperty("line.separator");
    
    private final String url = "https://hooks.slack.com/services/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";

    public void usuarioLogado(String nomeUser) throws IOException {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text("Usuário " + nomeUser + " logou...")
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " mensagem sobre login do usuário enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " Erro ao tentar enviar mensagem do metodo usuarioLogado no slack!");
        }
    }

    public void alertaComponente(String componente) throws IOException {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text(componente + " está acima do limite!!")
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " mensagem de alerta sobre componente foi enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " Erro ao tentar enviar mensagem do metodo alertaComponente no slack!");
        }
    }
    
    public void capturaIniciada(String idAtivo) throws IOException {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text("A captura de dados foi iniciada no ativo referente a este ID: "+idAtivo)
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " mensagem de alerta sobre captura iniciada foi enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " Erro ao enviar mensagem do metodo capuraIniciada no slack!");
        }
    }

    public void fimCaptura() throws IOException {
        Payload payload = Payload.builder()
                .channel("#random")
                .username("Mainline Bot")
                .text("Captura finalizada! Programa foi fechado.")
                .build();

        Slack slack = Slack.getInstance();
        try {
            WebhookResponse response = slack.send(url, payload);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " mensagem de alerta sobre fim da captura foi enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverLog(quebraLinha + arq.getData() +" "+ arq.getHora() + " Erro ao enviar mensagem do metodo fimCaptura no slack!");
        }
    }

}
