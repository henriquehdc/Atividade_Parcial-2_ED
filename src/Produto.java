public class Produto {
    
   private String nome,validade;
   private int quantidade;
    
   
    public Produto(String nome, String validade, int quantidade) {
    this.nome = nome;
    this.validade = validade;
    this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", quantidade=" + quantidade + ", validade=" + validade + "]";
    }

    
   
}
