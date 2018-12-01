package software.classes;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSlack {

    public arquivoLog arq = new arquivoLog();
    String quebraLinha = System.getProperty("line.separator");
    Date dataHoraAtual = new Date();
    String data2 = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    String hora2 = new SimpleDateFormat(" HH:mm:ss").format(dataHoraAtual);
    
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
            arq.escreverlog(quebraLinha + data2 + hora2 + " mensagem sobre login do usuário enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data2 + hora2 + " Erro na execução! método: usuarioLogado.");
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
            arq.escreverlog(quebraLinha + data2 + hora2 + " mensagem de alerta sobre componente foi enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data2 + hora2 + " Erro na execução!  método: alertaComponente.");
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
            arq.escreverlog(quebraLinha + data2 + hora2 + " mensagem de alerta sobre captura iniciada foi enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data2 + hora2 + " Erro na execução!  método: capturaIniciada.");
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
            arq.escreverlog(quebraLinha + data2 + hora2 + " mensagem de alerta sobre fim da captura foi enviada no slack!");
        } catch (IOException ex) {
            Logger.getLogger(JSlack.class.getName()).log(Level.SEVERE, null, ex);
            arq.escreverlog(quebraLinha + data2 + hora2 + " Erro na execução!  método: fimCaptura.");
        }
    }

}
