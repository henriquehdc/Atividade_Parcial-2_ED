import javax.swing.JOptionPane;

public class Estoque {
 
    No inicio,fim;

    public void Inserir(Produto produto){
        No aux = new No(produto);

        if(inicio == null){
            inicio = aux;
            fim = aux;
        }else if(aux.produto.getValidade().compareToIgnoreCase(inicio.produto.getValidade()) <= 0) {
            aux.prox = inicio;
            inicio.ant = aux;
            inicio = aux;
        }else if(aux.produto.getValidade().compareToIgnoreCase(fim.produto.getValidade()) >= 0 ){
            aux.ant = fim;
            fim.prox = aux;
            fim = aux;
        }else{
            No aux2 = aux;
            No aux3 = inicio;
            while (aux3 != null){
                if (aux.produto.getValidade().compareToIgnoreCase(aux3.produto.getValidade())<=0){
                    aux2.prox = aux;
                    aux.ant = aux2;
                    aux.prox = aux3;
                    aux3.ant = aux;
                    break;    
                }else{
                    aux2 =aux3;
                    aux3 = aux3.prox;
                }
            }

        }
    }

    public void Listar(){
        No aux = inicio;

        while(aux != null){
            JOptionPane.showMessageDialog(null,aux.produto);
            aux = aux.prox;
        }
    }

    public void Vender(){
       String nome =  JOptionPane.showInputDialog("Qual produto deseja realizar a venda?");
       int  quantidade =  Integer.parseInt(JOptionPane.showInputDialog("Quantos produtos estão sendo vendidos?"));
    }

}
