import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofos {
    public class Garfos extends Thread {
        private int garfoEsquerda;
        private int garfoDireita;

        public  Garfos(int garfoEsquerda, int garfoDireita) {
            this.garfoEsquerda = garfoEsquerda;
            this.garfoDireita = garfoDireita;
        }

        @Override
        public void run() {
            while (true){
                try {
                    SorteioDireita();
                    SorteioEsquerda();
                    Thread.sleep(1000);
                } catch (InterruptedException ex){
                    System.out.println(ex);
                }
            }
        }

        public void SorteioDireita() {
            int garfoDireita;
            Random d = new Random();
            garfoDireita = d.nextInt(5);

            System.out.println("O garfo da direita sorteado " + garfoDireita);
        }

        public void SorteioEsquerda() {
            int garfoEsquerda;
            Random e = new Random();
            garfoEsquerda = e.nextInt(5);

            System.out.println("O garfo da esquerda sorteado " + garfoEsquerda);
        }

    }
}
