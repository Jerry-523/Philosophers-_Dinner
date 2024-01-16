
public class Semafaro {
    private static final String th1 = "\t[*] = [  RED   ]";
    private static final String th2 = "\t[*] = [ YELLOW ]";
    private static final String th3 = "\t[*] = [ GREEN  ]";

    public static void main(String[] arg){
        semafaro();
    }
    public static void semafaro(){
        clearTerminal();
        while(true){
            System.out.println(th1);
            System.out.println("\t[ ] = [ YELLOW ]");
            System.out.println("\t[ ] = [ GREEN  ]");
            delay();
            clearTerminal();
            System.out.println("\t[ ] = [  RED   ]");
            System.out.println(th2);
            System.out.println("\t[ ] = [ GREEN  ]");
            delay();
            clearTerminal();
            System.out.println("\t[ ] = [  RED   ]");
            System.out.println("\t[ ] = [ YELLOW ]");
            System.out.println(th3);
            delay();
            clearTerminal();
        }
    }

    static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
