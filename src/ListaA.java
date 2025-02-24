import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListaA {
   private String lista[] = new String[10];
   private int no;

   public ListaA(String[] lista, int no) {
      this.lista = lista;
      this.no = no;
   }

   public ListaA() {
      this.no = 0;
   }

   public String[] getLista() {
      return lista;
   }

   public void setLista(String[] lista) {
      this.lista = lista;
   }

   public void setList(int i, String str) {
      this.lista[i] = str;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public void readFile(String fileName) {
      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
         String linha;

         linha = br.readLine();
         linha = linha.replace(",", "");
         this.no = linha.length();

         int i = 0;
         while ((linha = br.readLine()) != null) {
            lista[i] = "";
            linha = linha.replace(",", "");

            for (int j = 0; j < linha.length(); j++) {
               if (linha.charAt(j) != '0') {
                  lista[i] = lista[i] + (char) (j + 65);
               }
            }

            i++;
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public boolean verificaSimples() {
      //Nao pode apontar pra ele mesmo
      for (int i = 0; i < no; i++) {
         if (lista[i].contains("" + (char) (i + 65)))
            return false;
      }

      return true;
   }

   public boolean verificaDigrafo() {
      for(int i=0; i<no; i++) {
         for(int j=0; j<lista[i].length(); j++) {
            int pos = lista[i].charAt(j) - 65;
            if(!lista[pos].contains(""+(char)(i + 65)))
               return true;
         }
      }

      return false;
   }

   public boolean verificaCompleto() {
      //Verificar quantidade de ligações
      for (int i = 0; i < no; i++) {
         if (lista[i].length() < no - 1)
            return false;
      }

      return true;
   }

   public boolean verificaRegular() {
      for (int i = 1; i < no; i++) {
         if (lista[i].length() != lista[0].length())
            return false;
      }

      return true;
   }

   public void verificar() {
      System.out.println();
      for(int i=0; i<no; i++) {
         System.out.print((char)(i+65));
         for(int j=0; j<lista[i].length(); j++) {
            System.out.print(" -> " + lista[i].charAt(j));
         }
         System.out.println();
      }

      System.out.println();
      System.out.println("Número de vertices: " + no);
      System.out.println();

      if (!verificaSimples())
         System.out.print("Não é ");

      System.out.println("Simples");

      if(!verificaDigrafo())
         System.out.print("Não é ");

      System.out.println("Digrafo");

      if (!verificaRegular())
         System.out.print("Não é ");

      System.out.println("Regular por Emissão");


      if (!verificaCompleto())
         System.out.print("Não é ");

      System.out.println("Completo");
   }

   public void converter(MatrizA matriz) {

      for(int i=0; i<no; i++) {
         String aux = "";
         for(int j=0; j<no; j++) {
            if(lista[i].contains(""+(char)(j+65)))
               aux = aux + "1";
            else
               aux = aux + "0";
         }

         matriz.setMat(i, aux);
      }

      matriz.setNo(no);
   }
}
