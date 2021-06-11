
package clinicaodontologica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consulta {
    private String localArquivo = "./Consultas.txt";
    private int numeroLinha;
    private String data;
    private String detalhe;
    
    public Consulta(String data) {
        FileReader meuArquivo = null;
        BufferedReader br = null;
        File arquivo = new File(this.localArquivo);
        try {
            meuArquivo = new FileReader(arquivo);
            br = new BufferedReader(meuArquivo);
            this.numeroLinha = 0;
            while (br.ready()) {
                ++this.numeroLinha;
                String linha = br.readLine();
                String[] valores = linha.split(",");
                if (valores[0].equals(data)) {
                    this.data = valores[0];
                    this.detalhe = valores[1];
                    break;
                }
            }

            meuArquivo.close();
            br.close();
        } catch (Exception e) {}
    }

    Consulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void incluir(){
        try {
            File arquivo = new File("./Consultas.txt");
            if (! arquivo.exists()) {
                    arquivo.createNewFile();
            }
            
            FileWriter fw = new FileWriter(arquivo,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(getAsCSV());
            bw.newLine();
            
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public void excluir(){
        File arquivo = new File("./Consultas.txt");
        
        try {
        FileReader fr= new FileReader (arquivo);
        BufferedReader br = new BufferedReader (fr);
        
        String linha = br.readLine();
        ArrayList<String> salvar = new ArrayList();
        
        while(linha != null){
            String[] valores = linha.split(",");
            if(!valores[0].equals(data)){
                salvar.add(linha);
            }

            linha = br.readLine();
        }
        br.close();
        fr.close();
        FileWriter fw2 = new FileWriter(arquivo, true);
        fw2.close();
        
        FileWriter fw = new FileWriter(arquivo);
        BufferedWriter bw = new BufferedWriter (fw);
        
        for (int i =0; i< salvar.size(); i++){
            bw.write(salvar.get(i));
            bw.newLine();
        }
        bw.close();
        fw.close();
        
        } catch (IOException ex){ 
           
        }
        System.out.println("Excluido");
    }
    public void alterar(){
        File arquivo = new File(this.localArquivo);

        try {
            FileReader fr= new FileReader (arquivo);
            BufferedReader br = new BufferedReader (fr);

            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();

            while(linha != null){
                salvar.add(linha);
                linha = br.readLine();
            }

            br.close();
            fr.close();

            FileWriter fw2 = new FileWriter(arquivo, true);
            fw2.close();

            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter (fw);

            for (int i =0; i< salvar.size(); i++){
                if (i + 1 == this.numeroLinha) {
                    bw.write(getAsCSV());
                } else {
                    bw.write(salvar.get(i));
                }
                bw.newLine();
            }
            bw.close();
            fw.close();

            System.out.println("Consulta alterada!");
        } catch (IOException ex){
            System.out.println("Ocorreu algum erro ao alterar a consulta");
        }
    }
    public void consultar(){
        
    }
    
       public String getData() {
        return data;
    }

    public void setData(String n) {
        this.data = n;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String d) {
        this.detalhe = d;
    }

    private String getAsCSV()
    {
        return this.data+","+this.detalhe;
    }
}
