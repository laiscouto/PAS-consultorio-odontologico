
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


public class Paciente {
    private int numeroLinha;
    private String nome;
    private String telefone;
    private String endereco;

    public Paciente(String nome) {
        FileReader meuArquivo = null;
        BufferedReader br = null;
        File arquivo = new File("./pacientes.txt");
        try {
            meuArquivo = new FileReader(arquivo);
            br = new BufferedReader(meuArquivo);
            this.numeroLinha = 0;
            while (br.ready()) {
                ++this.numeroLinha;
                String linha = br.readLine();
                String[] valores = linha.split(",");
                if (valores[0].equals(nome)) {
                    this.nome = valores[0];
                    this.endereco = valores[1];
                    this.telefone = valores[2];
                    break;
                }
            }

            meuArquivo.close();
            br.close();
        } catch (Exception e) {
        }
    }

    public Paciente() {
    }

    /**
     * método para salvar um paciente dentro de um arquivo
     */
    public void incluir() {

        try {
            File arquivo = new File("./pacientes.txt");
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            try (FileWriter fw = new FileWriter(arquivo, true)) {
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(getAsCSV());
                bw.newLine();

                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir() {
        File arquivo = new File("./pacientes.txt");

        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();

            while (linha != null) {
                String[] valores = linha.split(",");
                if (!valores[0].equals(nome)) {
                    salvar.add(linha);
                }

                linha = br.readLine();
            }
            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(arquivo, true);
            fw2.close();

            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < salvar.size(); i++) {
                bw.write(salvar.get(i));
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (IOException ex) {

        }
        System.out.println("Excluido");
    }

    public void alterar() {
        File arquivo = new File("./pacientes.txt");

        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();

            while (linha != null) {
                salvar.add(linha);
                linha = br.readLine();
            }

            br.close();
            fr.close();

            FileWriter fw2 = new FileWriter(arquivo, true);
            fw2.close();

            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < salvar.size(); i++) {
                if (i + 1 == this.numeroLinha) {
                    bw.write(getAsCSV());
                } else {
                    bw.write(salvar.get(i));
                }
                bw.newLine();
            }
            bw.close();
            fw.close();

            System.out.println("Paciente alterado!");
        } catch (IOException ex) {
            System.out.println("Ocorreu algum erro ao alterar o paciente");
        }
    }

    private String getAsCSV() {
        return this.nome + "," + this.endereco + "," + this.telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public void setTelefone(String t) {
        this.telefone = t;
    }

    public void setEndereco(String e) {
        this.endereco = e;
    }

}
