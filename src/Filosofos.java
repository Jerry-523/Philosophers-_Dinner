import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Filosofos {
    public class Garfos {
        private Lock garfoEsquerda;
        private Lock garfoDireita;

        public Garfos() {
            this.garfoEsquerda = new ReentrantLock();
            this.garfoDireita = new ReentrantLock();
        }

        public Lock getGarfoEsquerda() {
            return garfoEsquerda;
        }

        public Lock getGarfoDireita() {
            return garfoDireita;
        }
    }

    public class Filosofo extends Thread {
        String nome;
        Garfos garfos;
        int lugarNaMesa;

        public Filosofo(String nome, Garfos garfos, int lugarNaMesa) {
            this.nome = nome;
            this.garfos = garfos;
            this.lugarNaMesa = lugarNaMesa;

            System.out.println("O filosofo " + nome + " sentou à mesa.");
        }

        public void pensar() throws InterruptedException {
            System.out.println("O filosofo " + nome + " está pensando.");
            Thread.sleep(1000);
        }

        public void comer() throws InterruptedException {
            System.out.println("O filosofo " + nome + " está comendo.");
            Thread.sleep(1000);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    pensar();

                    garfos.getGarfoEsquerda().lock();
                    garfos.getGarfoDireita().lock();

                    System.out.println("O Filosofo " + nome + " pegou os garfos.");

                    comer();

                    System.out.println("O Filosofo " + nome + " largou os garfos.");
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                } finally {
                    garfos.getGarfoDireita().unlock();
                    garfos.getGarfoEsquerda().unlock();
                }
            }
        }
    }

    public void test() {
        Garfos garfos = new Garfos();

        Filosofo filosofo1 = new Filosofo("Platão", garfos, 1);
        Filosofo filosofo2 = new Filosofo("Aristóteles", garfos, 2);
        Filosofo filosofo3 = new Filosofo("Sócrates", garfos, 3);
        Filosofo filosofo4 = new Filosofo("Descartes", garfos, 4);
        Filosofo filosofo5 = new Filosofo("Euclides", garfos, 5);

        new Thread(filosofo1).start();
        new Thread(filosofo2).start();
        new Thread(filosofo3).start();
        new Thread(filosofo4).start();
        new Thread(filosofo5).start();
    }
}
/*
 A principal característica do ReentrantLock é que ele permite que um thread que já possui o bloqueio (lock) o
 adquira novamente, sem ficar bloqueado, desde que o número de aquisições seja igual ao número de liberações.
 Isso é chamado de "lock reentrancy" (reentrância de bloqueio).
 Cada chamada lock precisa ser correspondida por uma chamada subsequente de unlock para liberar o bloqueio.

    Reentrância:
        Um thread pode chamar repetidamente lock em um ReentrantLock sem ficar bloqueado.
        Ele precisa liberar o lock a mesma quantidade de vezes chamando unlock antes que outros threads possam adquiri-lo.

    Métodos Principais:
        lock(): Adquire o bloqueio. Se o bloqueio já estiver sendo mantido por outro thread,
                o thread atual ficará bloqueado até que o bloqueio seja liberado.
        unlock(): Libera o bloqueio. Deve ser chamado para corresponder a cada chamada lock.

    Construtores e Configurações:
        O construtor padrão cria um ReentrantLock com reentrância de bloqueio.
        Existem construtores adicionais que permitem configurar o ReentrantLock para operar como um lock "fair" (justo),
        onde os threads adquirem o bloqueio em ordem de chegada.
 */
