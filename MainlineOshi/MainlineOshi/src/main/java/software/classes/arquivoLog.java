package software.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class arquivoLog {
    
    File arquivo;
    File arq;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    String workingDir = System.getProperty("user.home");
    String time = new SimpleDateFormat("MM-YYYY").format(Calendar.getInstance().getTime());
    String timeStamp = new SimpleDateFormat("dd-MM-yyyy__HH.mm").format(Calendar.getInstance().getTime());

    public void escreverlog(String erros) throws IOException {

        arquivo = new File(workingDir.concat("\\Desktop\\log"));
        for (int c = 1; c <= 3; c++) {
            if (!arquivo.exists()) {
                arquivo.mkdir();
            } else {

                
                arquivo = new File("C:\\Users\\aluno\\Desktop\\log" + time);
                if (!arquivo.exists()) {
                    arquivo.mkdir();
                } else {

                   

                     arq = new File("C:\\Users\\aluno\\Desktop\\log" + time + "\\" + timeStamp + ".txt");
                     
                     fileWriter = new FileWriter(arq);
                    try {
                        arquivo.createNewFile();
                    } catch (IOException ex) {
                        Logger.getLogger(arquivoLog.class.getName()).log(Level.SEVERE, null, ex);

                    }

                    //objeto que insere a data no nome do arquivo txt, isso irá mudar o arquivo
                    //de acordo com o dia
                    //String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                    //cria o arquivo, escreve e grava.
                    BufferedWriter writer = new BufferedWriter(fileWriter);
                    writer.write(erros);
                    writer.close();
                }

            }
        }
    }
}
