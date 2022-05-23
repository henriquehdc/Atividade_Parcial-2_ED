import javax.swing.JOptionPane;

public class Estoque {
 
    No inicio,fim;

    public void Inserir(Produto produto){
        No aux = new No(produto);
        No existe =inicio;
        boolean achou  = false;
        
        while(existe!= null){
            if(existe.produto.getNome().equals(aux.produto.getNome())){
                JOptionPane.showMessageDialog(null,"Produto já cadastrado!");
                achou = true;
                break;
            }else{
                existe=existe.prox;
            }      
        }

        if(achou != true){
            if(inicio == null){
                inicio = aux;
                fim = aux;
            }else if(aux.produto.getValidade().compareTo(inicio.produto.getValidade()) <= 0) {
                aux.prox = inicio;
                inicio.ant = aux;
                inicio = aux;
            }else if(aux.produto.getValidade().compareTo(fim.produto.getValidade()) >= 0 ){
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
    }

    public void Listar(){
        No aux = inicio;

        if(inicio==null){
            JOptionPane.showMessageDialog(null,"Nenhum produto cadastrado!");
        }
            while(aux != null){
                JOptionPane.showMessageDialog(null,aux.produto);
                aux = aux.prox;
            }
          
    }

    public void Vender(){
       boolean achou = false;
       No aux = inicio;
       String nome =  JOptionPane.showInputDialog("Qual produto deseja realizar a venda?").trim().toLowerCase();

       while(aux!=null){
            if(aux.produto.getNome().equalsIgnoreCase(nome)){
                int  quantidade =  Integer.parseInt(JOptionPane.showInputDialog(aux.produto +"\nQuantas unidades estão sendo vendidas?"));
                if(aux.produto.getQuantidade()>=quantidade){
                    aux.produto.setQuantidade(aux.produto.getQuantidade()-quantidade); 
                    JOptionPane.showMessageDialog(null,"Estoque alterado, restam " + aux.produto.getQuantidade() + " unidades de " +aux.produto.getNome());
                }else{                     
                    String vender = JOptionPane.showInputDialog(null,"Estoque insuficiente!\nEsse produto possui apenas " +aux.produto.getQuantidade() +" unidades\nVender todas as unidades? ( S / N )");
                    if(vender.equalsIgnoreCase("s")){
                        aux.produto.setQuantidade(0);
                        JOptionPane.showMessageDialog(null,"Estoque alterado, restam " + aux.produto.getQuantidade() + " unidades de " +aux.produto.getNome());
                    }
        
                }
                if(aux.produto.getQuantidade() == 0){

                    if(aux == inicio && aux == fim){
                        inicio = null;
                        fim = null;
                    }
                    else if(inicio == aux){
                        inicio = aux.prox;
                        inicio.ant = null;
                    }else if (fim == aux){
                        fim= aux.ant;
                        fim.prox = null;
                    }else{
                        No aux2 = aux.ant;
                        aux2.prox = aux.prox;
                        aux.prox.ant = aux2;  
                    }
                }
                achou = true;
                break;
            }
            aux = aux.prox;  
        }

        if (achou == false){
        String acha = JOptionPane.showInputDialog(null,"Produto não encontrado! \nBuscar novamente? ( S / N )");
                    if(acha.equalsIgnoreCase("s")){
                        Vender();
                    }
            }
        }
    

}
