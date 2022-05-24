import javax.swing.JOptionPane;


public class Main {
    
    public static void main(String[] args) {
       String comando;
       Estoque estoque = new Estoque();
       
        do{
        comando = JOptionPane.showInputDialog(opcoes());
        try{   
            if("".equals(comando)){               
            }else if ("1".equals(comando)){
                String nome,validade;
                int quantidade;
                
                nome = JOptionPane.showInputDialog("Nome do produto para cadastro: ").trim();
                validade = JOptionPane.showInputDialog("Data de validade do produto (ANO/MES/DIA):");
                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade em estoque do produto: "));
                      
                estoque.Inserir(new Produto(nome,validade,quantidade));
            }else if ("2".equals(comando)){
                estoque.Listar();
            }else if ("3".equals(comando)){
                estoque.Vender();
            }else if ("4".equals(comando)){
                break;
            }else {
                JOptionPane.showMessageDialog(null,"Comando inválido! \nDigite um numero entre 1 e 4");
                throw new UnsupportedOperationException();
            }       
            }  catch (UnsupportedOperationException e) {
                    e.printStackTrace();
            }
    }while (comando != "4");
    }
 
    public static String opcoes(){
        String aux="Escolha uma opção:";
            aux+="\n1.Cadastrar produto";
            aux+="\n2.Listar produtos";
            aux+="\n3.Vender produto";
            aux+="\n4.Encerrar aplicação";
    return aux;    
    }

}