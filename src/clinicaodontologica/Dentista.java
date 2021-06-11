
package clinicaodontologica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dentista extends Secretaria {
    private String nome;
    private int CROSP;

    public void incluir(){
        try {
            File arquivo = new File("./paciente.txt");
            if (! arquivo.exists()) {
                    arquivo.createNewFile();
            }
            
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.nome+","+this.CROSP);
            bw.newLine();
            
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(){
    
    }
  
    @Override
    public void alterar(){
    }
    
    public int getCROSP(){
        return this.CROSP;
    }
    public void setCROSP(int x){
        this.CROSP = x;
    }

    @Override
    public String toString() {
        return "Dentista{" + "nome=" + nome + ", CROSP=" + CROSP + '}';
    }
    
}
