public class App {
    public static void main(String[] args) throws Exception {
      Editortexto editor = new Editortexto();

      editor.inserirTexto("Olá");
      editor.inserirTexto(" como anda?");
      System.out.println(editor.getTexto());

      editor.desfazer();
      System.out.println(editor.getTexto());

       
      editor.refazer();
      System.out.println(editor.getTexto());

      editor.removerTexto(9);
      System.out.println(editor.getTexto());

      editor.desfazer();
      System.out.println(editor.getTexto());
    }
}
