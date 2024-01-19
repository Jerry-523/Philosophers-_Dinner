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

    public class Filosofo extends Thread {

        String nome;
        Garfos garfo;
        int lugarNaMesa;

        public Filosofo(String nome, Garfos garfo, int lugarNaMesa) {
            this.nome = nome;
            this.garfo = garfo;
            this.lugarNaMesa = lugarNaMesa;

            System.out.println("O filosofo " + nome + " sentou a mesa.");
        }

        public  void Pensar() throws InterruptedException {
            System.out.println("O filosofo " + nome + " esta pensando.");
            Thread.sleep(1000);
        }

        @Override
        public void run() {
            while(true){
                if(garfo.garfoDireita == 5) {
                    System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoDireita);
                    if(garfo.garfoEsquerda == 1){
                        System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo " + nome + " esta comendo.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da direita.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da esquerda.");
                    } else {
                        System.out.println("O Filosofo " + nome + " largou o garfo " + garfo.garfoDireita);
                    }

                }else {
                    try {
                        pensar();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                if(garfo.garfoDireita ==1){
                    System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoDireita);
                    if (garfo.garfoEsquerda == 2) {
                        System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo " + nome + " esta comendo.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da direita.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da esquerda.");
                    } else {
                        System.out.println("O Filosofo " + nome + " Largou o garfo " + garfo.garfoDireita);
                    }
                } else {
                    try {
                        pensar();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }

                if(garfo.garfoDireita == 2){
                    System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                    if(garfo.garfoEsquerda == 3) {
                        System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo " + nome + " esta comendo.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da direita.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da esquerda.");
                    } else {
                        System.out.println("O Filosofo " + nome + " Largou o garfo " + garfo.garfoDireita);
                    }
                } else {
                    try {
                        pensar();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                if(garfo.garfoDireita == 3){
                    System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                    if(garfo.garfoEsquerda == 4) {
                        System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo " + nome + " esta comendo.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da direita.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da esquerda.");
                    } else {
                        System.out.println("O Filosofo " + nome + " Largou o garfo " + garfo.garfoDireita);
                    }
                } else {
                    try {
                        pensar();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
                if(garfo.garfoDireita == 4){
                    System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                    if(garfo.garfoEsquerda == 5) {
                        System.out.println("O Filosofo " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println("O Filosofo " + nome + " esta comendo.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da direita.");
                        System.out.println("O Filosofo " + nome + " largou o garfo da esquerda.");
                    } else {
                        System.out.println("O Filosofo " + nome + " Largou o garfo " + garfo.garfoDireita);
                    }
                } else {
                    try {
                        pensar();
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
    }

    public void test(){

        Garfos g1 = new Garfos(1, 5);
        Garfos g2 = new Garfos(2, 1);
        Garfos g3 = new Garfos(3, 3);
        Garfos g4 = new Garfos(4, 3);
        Garfos g5 = new Garfos(5, 4);

        Filosofo filosofo1 = new Filosofo("Platao ", g1, 1);
        Filosofo filosofo2 = new Filosofo("Aristoteles ", g2, 2);
        Filosofo filosofo3 = new Filosofo("Socrates ", g3, 3);
        Filosofo filosofo4 = new Filosofo("Descartes ", g4, 4);
        Filosofo filosofo5 = new Filosofo("Euclides ", g5, 5);

        new Thread(filosofo1).start();
        new Thread(filosofo2).start();
        new Thread(filosofo3).start();
        new Thread(filosofo4).start();
        new Thread(filosofo5).start();
    }
}
