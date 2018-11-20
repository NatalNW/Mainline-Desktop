package software.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class arquivoLog {
    
    String caminhoDoArquivo = "C:\\Logs\\Mainline-master\\";
    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    public void escreverlog(String erros) throws IOException {
 
        //objeto que insere a data no nome do arquivo txt, isso irá mudar o arquivo
        //de acordo com o dia
        String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
         
        //cria o arquivo, escreve e grava.
        BufferedWriter writer = new BufferedWriter(new FileWriter( caminhoDoArquivo + "log-" + data +".txt", true));
        writer.write(erros);
        writer.close();

        
    }
    
}
