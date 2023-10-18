package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] entries = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(String entry : entries) {
            contactCandidate(entry);
        }
    }

    static void contactCandidate(String entry) {
        int attempts = 1;
        boolean continueAttempting = true;
        boolean pickedUp = false;
        do {
            pickedUp = pickUp();
            continueAttempting = !pickedUp;
            if(continueAttempting) attempts++;
            else System.out.println("Contato realizado com sucesso.");
        } while (continueAttempting && attempts<3);

        if(pickedUp) System.out.println("Contato realizado com candidato " + entry + " na " + attempts + "° tentativa.");
        else System.out.println("Contato com candidato " + entry + " nao realizado.");
    }
    
    static boolean pickUp() {
        return new Random().nextInt(3)==1;
    }

    static void printSelected() {
        String[] entries = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Lista de candidatos por índice:");
        int i = 0;
        for (String element : entries) {
            System.out.println(i + " - " + element);
            i++;
        }

    }

    static void selectEntry() {
        String[] entries = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int entriesSelected = 0;
        int currentEntry = 0;
        double baseWage = 2000.0;
        while(entriesSelected < 5 && currentEntry < entries.length) {
            String entry = entries[currentEntry];
            double expectedWage = expectedValue();

            System.out.println("Candidato " + entry + " espera $" + expectedWage + " como salário.");
            if(baseWage >= expectedWage) {
                System.out.println("Candidato " + entry + " foi selecionado para a vaga.");
                entriesSelected++;
            }
            currentEntry++;
        }
    }

    static double expectedValue() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analyzeEntry(double expectedWage) {
        double baseWage = 2000.0;
        if(baseWage > expectedWage) System.out.println("Ligar para o candidato");
        else if(baseWage == expectedWage) System.out.println("Ligar para o candidato com contra-proposta");
        else System.out.println("Aguardando demais candidatos");
    }
}
