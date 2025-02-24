import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrizA {
   private String matriz[] = new String[10];
   private int no;

   public MatrizA(String[] matriz, int no) {
      this.matriz = matriz;
      this.no = no;
   }

   public MatrizA() {
      this.no = 0;
   }

   public String[] getMatriz() {
      return matriz;
   }

   public void setMatriz(String[] matriz) {
      this.matriz = matriz;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public void setMat(int i, String str) {
      this.matriz[i] = str;
   }

   public void readFile(String fileName) {
      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
         String linha;

         linha =br.readLine();
         linha = linha.replace(",", "");
         this.no = linha.length();

         int i = 0;
         while ((linha = br.readLine()) != null) {
            linha = linha.replace(",", "");

            this.matriz[i++] = linha;
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public boolean verificaSimples() {
      //Diagonal principal 0
      for (int i = 0; i < no; i++) {
         if (matriz[i].charAt(i) != '0')
            return false;
      }

      return true;
   }

   public boolean verificaDigrafo() {
      //Verificar o espelho
      for (int i = 0; i < no; i++) {
         for (int j = i + 1; j < no; j++) {
            if (matriz[i].charAt(j) != matriz[j].charAt(i)) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean verificaCompleto() {
      //Verificar o espelho = 1
      for (int i = 0; i < no; i++) {
         for (int j = i + 1; j < no; j++) {
            if (matriz[i].charAt(j) == matriz[j].charAt(i)) {
               if (matriz[i].charAt(j) == '0')
                  return false;
            } else return false;
         }
      }

      return true;
   }

   public boolean verificaRegular() {
      int total = 0;
      for (int i = 0; i < no; i++) {
         int soma = 0;
         for (int j = 0; j < no; j++) {
            if (matriz[i].charAt(j) != '0')
               soma++;
         }
         if (i != 0 && total != soma) {
            return false;
         }
         total = soma;
      }

      return true;
   }

   public boolean verificaRegRec() {
      int total = 0;
      for (int i = 0; i < no; i++) {
         int soma = 0;
         for (int j = 0; j < no; j++) {
            if (matriz[j].charAt(i) != '0')
               soma++;
         }
         if (i != 0 && total != soma) {
            return false;
         }
         total = soma;
      }

      return true;
   }

   public void verificar() {
      System.out.println();

      for(int i=-1; i< no; i++) {
         if(i==-1) {
            System.out.print("  ");
            for(int j=0; j<no; j++) {
               System.out.print((char)(j+65));
            }
         } else {
            System.out.print((char)(i+65)+" ");
            System.out.print(matriz[i]);
         }
         System.out.println();
      }

      System.out.println();
      System.out.println("Número de vertices: " + no);
      System.out.println();

      if (!verificaSimples())
         System.out.print("Não é ");

      System.out.println("Simples");

      if (!verificaDigrafo()) {
         System.out.println("Não é Digrafo");

         if (!verificaRegular())
            System.out.print("Não é ");

         System.out.println("Regular");
      } else {
         System.out.println("Digrafo");

         if (!verificaRegular())
            System.out.print("Não é ");

         System.out.println("Regular por Emissão");

         if (!verificaRegRec())
            System.out.print("Não é ");

         System.out.println("Regular por Recepção");
      }

      if (!verificaCompleto())
         System.out.print("Não é ");

      System.out.println("Completo");
   }

   public void converter(ListaA lista) {
      String aux;

      for (int i=0; i< no; i++) {
         aux = "";

         for (int j = 0; j < no; j++) {
            if (matriz[i].charAt(j) != '0') {
               aux = aux + (char) (j + 65);
            }
         }

         lista.setList(i, aux);
      }

      lista.setNo(no);
   }
}
