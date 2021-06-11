
package clinicaodontologica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Orcamento {
    private String localArquivo = "./Orçamento.txt";
    private int numeroLinha;
    private String data;
    private String tipo;
    private float valor;
    public String detalhes;
    public String excluir_Orcamento;

    public Orcamento(String data) {
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
                    this.tipo = valores[1];
                    this.valor = Float.valueOf(valores[2]);
                    this.detalhes = valores[3];
                    break;
                }
            }

            meuArquivo.close();
            br.close();
        } catch (Exception e) {
        }
    }
    public Orcamento() {}

    public void incluir() {
        try {
            File arquivo = new File(this.localArquivo);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            try (FileWriter fw = new FileWriter(arquivo, true)) {
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(getAsCSV());
                bw.newLine();

                bw.close();
            }
            System.out.println("CADASTRADO");
        } catch (IOException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir() {
        File arquivo = new File("./Orçamento.txt");
        
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            ArrayList<String> salvar = new ArrayList();

            while (linha != null) {
                String[] valores = linha.split(",");
                if (!valores[0].equals(this.data)) {
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
        System.out.println("Orcamento Excluido");
    }

    public void alterar() {
        File arquivo = new File(this.localArquivo);

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

            System.out.println("Orcamento alterado!");
        } catch (IOException ex) {
            System.out.println("Ocorreu algum erro ao alterar o orçamento");
        }
    }

    public Orcamento consultar() {
        return new Orcamento();
    }

    public void gerarBoleto() {
        System.out.println("O boleto de "+this.valor+" foi gerado.");
    }

    public String getData() {
        return data;
    }

    public void setData(String d) {
        this.data = d;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float v) {
        this.valor = v;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String d) {
        this.detalhes = d;
    }

    public String getExcluir_Orcamento() {
        return excluir_Orcamento;
    }

    public void setExcluir_Orcamento(String excluir_Orcamento) {
        this.excluir_Orcamento = excluir_Orcamento;
    }

    public String getAsCSV() {
        return this.data + "," + this.tipo + "," + this.valor + "," + this.detalhes;
    }
}
