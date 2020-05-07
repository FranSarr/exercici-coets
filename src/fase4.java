import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class fase4 {

    public static void main(String[] args) {

        Coet rocket1 = new Coet("32WESSDS", 3);
        List<Thruster> thrusters_rocket1 = new ArrayList<Thruster>();
        Thruster rocket1_T1 = new Thruster(10, 0);
        Thruster rocket1_T2 = new Thruster(30, 0);
        Thruster rocket1_T3 = new Thruster(80, 0);
        thrusters_rocket1.add(rocket1_T1);
        thrusters_rocket1.add(rocket1_T2);
        thrusters_rocket1.add(rocket1_T3);

        Coet rocket2 = new Coet("LDSFJA32", 6);
        List<Thruster> thrusters_rocket2 = new ArrayList<Thruster>();
        Thruster rocket2_T1 = new Thruster(30, 0);
        Thruster rocket2_T2 = new Thruster(40, 0);
        Thruster rocket2_T3 = new Thruster(50, 0);
        Thruster rocket2_T4 = new Thruster(50, 0);
        Thruster rocket2_T5 = new Thruster(30, 0);
        Thruster rocket2_T6 = new Thruster(10, 0);
        thrusters_rocket2.add(rocket2_T1);
        thrusters_rocket2.add(rocket2_T2);
        thrusters_rocket2.add(rocket2_T3);
        thrusters_rocket2.add(rocket2_T4);
        thrusters_rocket2.add(rocket2_T5);
        thrusters_rocket2.add(rocket2_T6);

        System.out.print("[1] Rocket with code " + rocket1.getCode() + " has " + rocket1.getNum_thrusters() + " thrusters with max power: \n");
        String MaxPowerThrusR1 = "";
        for (int i = 0; i < thrusters_rocket1.size(); i++) {
            MaxPowerThrusR1 += thrusters_rocket1.get(i).getMax_power() + " ";
        }
        System.out.println(MaxPowerThrusR1);

        System.out.print("[2] Rocket with code " + rocket2.getCode() + " has " + rocket2.getNum_thrusters() + " thrusters with max power:  \n");
        String MaxPowerThrusR2 = "";
        for (int i = 0; i < thrusters_rocket2.size(); i++) {
            MaxPowerThrusR2 += thrusters_rocket2.get(i).getMax_power() + " ";
        }
        System.out.println(MaxPowerThrusR2);

        Scanner user_input = new Scanner(System.in);
        System.out.print("Please, choose rocket 1 or 2 please: ");
        String rocket = user_input.nextLine();

        user_input = new Scanner(System.in);
        System.out.print("Please, enter your current speed: ");
        String V0 = user_input.nextLine();

        user_input = new Scanner(System.in);
        System.out.print("Please, enter your desired speed: ");
        String V = user_input.nextLine();

        double dV = 0.01 * ((Integer.parseInt(V) - Integer.parseInt(V0)));
        int PT = (int) Math.round(Math.pow(dV, 2));
        System.out.print("You need this power to get there: " + PT + "\n");

        if (Integer.parseInt(rocket)==1){
        String[] MaxPowerR1 = MaxPowerThrusR1.split(" ");
        int[] MaxPowerR1i = new int[MaxPowerR1.length];
        for (int i = 0; i < MaxPowerR1.length; i++) {
            MaxPowerR1i[i] = Integer.parseInt(MaxPowerR1[i]);
        }

        int[] ObjetivoR1 = new int[MaxPowerR1.length];

        if (PT > IntStream.of(MaxPowerR1i).sum()) {
            System.out.print("You do not have enough power in your thruster to achieve " + PT + ", you only have " +
                    IntStream.of(MaxPowerR1i).sum() + " available");
            return;
        }

        while (PT > 0) {
            for (int i = 0; i < MaxPowerR1.length; i++) {
                if (ObjetivoR1[i] < MaxPowerR1i[i]) {
                    ObjetivoR1[i]++;
                    PT--;
                }
            }
        }
        for (int i = 0; i < MaxPowerR1.length; i++) {
            System.out.print("Target power for thurster number " + i + " :" + ObjetivoR1[i] + "\n");
        }
        } else {
            String[] MaxPowerR2 = MaxPowerThrusR2.split(" ");
            int[] MaxPowerR2i = new int[MaxPowerR2.length];
            for (int i = 0; i < MaxPowerR2.length; i++) {
                MaxPowerR2i[i] = Integer.parseInt(MaxPowerR2[i]);
            }

            int[] ObjetivoR2 = new int[MaxPowerR2.length];

            if (PT > IntStream.of(MaxPowerR2i).sum()) {
                System.out.print("You do not have enough power in your thruster to achieve " + PT + ", you only have " +
                        IntStream.of(MaxPowerR2i).sum() + " available");
                return;
            }

            while (PT > 0) {
                for (int i = 0; i < MaxPowerR2.length; i++) {
                    if (ObjetivoR2[i] < MaxPowerR2i[i]) {
                        ObjetivoR2[i]++;
                        PT--;
                    }
                }
            }
            for (int i = 0; i < MaxPowerR2.length; i++) {
                System.out.print("Target power for thurster number " + i + " :" + ObjetivoR2[i] + "\n");
            }

        }


    }

}
