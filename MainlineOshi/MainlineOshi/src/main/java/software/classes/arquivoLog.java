package software.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class arquivoLog {
    
    
    String caminhoDoArquivo = "\\Pictures\\Mainline\\";
    File arquivo;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    
   // File arquivo;
    File arq;
    //FileWriter fileWriter;
    //BufferedWriter bufferedWriter;
    String workingDir = System.getProperty("user.home");
    String time = new SimpleDateFormat("MM-YYYY").format(Calendar.getInstance().getTime());
    String timeStamp = new SimpleDateFormat("dd-MM-yyyy__HH.mm").format(Calendar.getInstance().getTime());

    public void escreverlog(String erros) throws IOException {
        
        
//objeto que insere a data no nome do arquivo txt, isso irá mudar o arquivo
        //de acordo com o dia
       String dataArq = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//        arquivo = new File(workingDir.concat("\\Pictures\\log"));
//        try{
//            fileWriter = new FileWriter(arquivo,true);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write("escrevendo");
//            
//            bufferedWriter.close();
//            fileWriter.close();
//            
//            FileReader ler = new FileReader(arquivo);
//            BufferedReader lerarq = new BufferedReader(ler);
//            String linha = lerarq.readLine();
//            
//            while(linha !=null) {
//                System.out.println(linha);
//                linha = lerarq.readLine();
//            }
//            
//        } catch(IOException ex) {
//            
//        }
        
        
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
        
//        arquivo = new File(workingDir.concat("\\Desktop\\log"));
//        for (int c = 1; c <= 3; c++) {
//            if (!arquivo.exists()) {
//                arquivo.mkdir();
//            } else {
//
//                
//                arquivo = new File("C:\\Users\\aluno\\Desktop\\log" + time);
//                if (!arquivo.exists()) {
//                    arquivo.mkdir();
//                } else {
//
//                   
//
//                     arq = new File("C:\\Users\\aluno\\Desktop\\log" + time + "\\" + timeStamp + ".txt");
//                     
//                     fileWriter = new FileWriter(arq);
//                    try {
//                        arquivo.createNewFile();
//                    } catch (IOException ex) {
//                        Logger.getLogger(arquivoLog.class.getName()).log(Level.SEVERE, null, ex);
//
//                    }
//
//                    //objeto que insere a data no nome do arquivo txt, isso irá mudar o arquivo
//                    //de acordo com o dia
//                    //String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//                    //cria o arquivo, escreve e grava.
//                    BufferedWriter writer = new BufferedWriter(fileWriter);
//                    writer.write(erros);
//                    writer.close();
//              }
//
//            }
//        }
    }
}
