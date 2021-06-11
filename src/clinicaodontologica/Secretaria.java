
package clinicaodontologica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Secretaria {
    private String nome;
    private int registro;
   
    public void incluir(){
         try {
            File arquivo = new File("./registro.txt");
            if (! arquivo.exists()) {
                    arquivo.createNewFile();
            }
            
             try (FileWriter fw = new FileWriter(arquivo, true)) {
                 BufferedWriter bw = new BufferedWriter(fw);
                 bw.write(this.nome+","+this.registro);
                 bw.newLine();
                 
                 bw.close();
             }
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void excluir(){
    
    }
    public void alterar(){
    }
    
    
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String x){
        this.nome=x;
    }
    public int getRegistro(){
        return this.registro;
    }
    public void setRegistro (int i){
        this.registro = i;
    }

    
}
