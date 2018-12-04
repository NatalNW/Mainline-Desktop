package software.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class arquivoLog {
    
    
    //private final String caminhoDoArquivo = "\\Desktop\\Mainline\\";
    
   // File arquivo;
    //private File arq;
    //FileWriter fileWriter;
    //BufferedWriter bufferedWriter;
    //private String workingDir = System.getProperty("user.home");
   // private String time = new SimpleDateFormat("MM-YYYY").format(Calendar.getInstance().getTime());
    //private String timeStamp = new SimpleDateFormat("dd-MM-yyyy__HH.mm").format(Calendar.getInstance().getTime());

    public void escreverLog(String erros) throws IOException {
        
        
        //objeto que insere a data no nome do arquivo txt, isso irá mudar o arquivo
        //de acordo com o dia
       String dataArq = new SimpleDateFormat("dd-MM-yyyy").format(new Date());     
//        //cria a pasta
//        File diretorio = new File("Logs");
//        if(!diretorio.exists()){
//        diretorio.mkdir();
//        } 

        //cria o arquivo txt, escreve e grava(close).
        
        BufferedWriter writer = new BufferedWriter(new FileWriter( "log - " + dataArq +".txt", true));
        writer.write(erros);
        writer.close();

      
        
        
//LENDO ARQUIVOS DO DIRETÓRIO
//        File fil = new File("\\Pictures\\Mainline\\");
//        File fi[] = fil.listFiles();
//        
//        for(int i=0;i <fi.length; i++){
//            System.out.println(fi[i]);
//        }
//        
        

    }
}
