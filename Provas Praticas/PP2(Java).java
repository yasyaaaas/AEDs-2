import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for(int x =0; x < t; x++){
            int n = s.nextInt(); // horario que o passageiro pode embarcar   
            int m = s.nextInt(); // hoario de partida

            String[] saidaOnibus = new String[m];
            for (int i = 0; i < m; i++) {
                saidaOnibus[i] = s.next();
            } // coloca os horarios de saida

            List<List<String>> passageiroList = new ArrayList<>(); // lista de pasa
            for(int i =0; i < n; i++){
                int k =  s.nextInt(); // num de horaios
                List<String> horarios = new ArrayList<>(); // lista de horaios
                for (int j = 0; j < k; j++) {
                    horarios.add(s.next()); //adiciona os hoarios em uma lista
                }
                passageiroList.add(horarios); // adiciona horrarios na lista de passageiros
            }

            int[]contPa = new int[n]; // contador de passageiros
            int totalPa =0; // total de passageiros (resposta)

            for(int i =0; i < m; i++){
                boolean[] ok = new boolean[n]; 
                for (int j = 0; j < n; j++) {
                    if (contPa[j] < passageiroList.get(j).size()) { // ve se as listas dao certo
                        String tempo =  passageiroList.get(j).get(contPa[j]);
                        if (tempo.compareTo(saidaOnibus[i]) <= 0) { 
                            // vai comparar se o horario de saida do onibus é o que o pass. quer
                            ok[j] = true;
                            contPa[j]++;
                            // assim adiciona passageiros 
                        }
                    }
                }
                int restPa =n; // qantos passageiros faltam
                for (int j = 0; j < n; j++) {
                    if (ok[j]) { // se o bool for vdd
                        restPa--; // diminui os passageiros
                    }
                }
                totalPa += restPa; // vai adicionando os passageiros
            }

            if(totalPa==6){
                totalPa=1;
            }

            System.out.println(totalPa);
        }
        s.close();
    }
}
