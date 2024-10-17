import java.util.Stack;
public class Editortexto {
Stack<Operacao> undoStack;
Stack<Operacao> redoStack;
StringBuilder texto;

public Editortexto(){
    undoStack = new Stack<>();
    redoStack = new Stack<>();
    texto = new StringBuilder();
}

public void inserirTexto(String textoInserido){
    Operacao operacao = new Operacao("inserir", textoInserido);
    undoStack.push(operacao);
    redoStack.clear();
    texto.append(textoInserido);
}

public void removerTexto(int tamanho){
    String textoRemovido = texto.substring(texto.length() - tamanho);
    texto.delete(texto.length() - tamanho, texto.length());
    Operacao operacao = new Operacao("remover", textoRemovido);
    undoStack.push(operacao);
    redoStack.clear();
}

public void desfazer(){
    if(!undoStack.isEmpty()){
        Operacao operacao = undoStack.pop();
        redoStack.push(operacao);

        if(operacao.tipo.equals("inserir")){
            texto.delete(texto.length() - operacao.textoAlterado.length(), texto.length());
        }else if(operacao.tipo.equals("remover")){
            texto.append(operacao.textoAlterado);
    }
}

}

public void refazer(){
    if(!redoStack.isEmpty()){
        Operacao operacao = redoStack.pop();
        undoStack.push(operacao);

        if(operacao.tipo.equals("inserir")){
            texto.append(operacao.textoAlterado);
        }else if (operacao.tipo.equals("remover")){
            texto.delete(texto.length() - operacao.textoAlterado.length(), texto.length());
        }
    }
}

public String getTexto(){
    return texto.toString();
}
}
