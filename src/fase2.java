import java.util.ArrayList;
import java.util.List;

public class fase2 {
    public static void main(String[] args) {

        Coet rocket1 = new Coet("32WESSDS", 3);
        List<Thruster> thrusters_rocket1 = new ArrayList<Thruster>();
        Thruster rocket1_T1 = new Thruster(10,0);
        Thruster rocket1_T2 = new Thruster(30,0);
        Thruster rocket1_T3 = new Thruster(80,0);
        thrusters_rocket1.add(rocket1_T1);
        thrusters_rocket1.add(rocket1_T2);
        thrusters_rocket1.add(rocket1_T3);

        Coet rocket2 = new Coet("LDSFJA32", 6);
        List<Thruster> thrusters_rocket2 = new ArrayList<Thruster>();
        Thruster rocket2_T1 = new Thruster(30,0);
        Thruster rocket2_T2 = new Thruster(40,0);
        Thruster rocket2_T3 = new Thruster(50,0);
        Thruster rocket2_T4 = new Thruster(50,0);
        Thruster rocket2_T5 = new Thruster(30,0);
        Thruster rocket2_T6 = new Thruster(10,0);
        thrusters_rocket2.add(rocket2_T1);
        thrusters_rocket2.add(rocket2_T2);
        thrusters_rocket2.add(rocket2_T3);
        thrusters_rocket2.add(rocket2_T4);
        thrusters_rocket2.add(rocket2_T5);
        thrusters_rocket2.add(rocket2_T6);

        System.out.print("Rocket with code " + rocket1.getCode() + " has " + rocket1.getNum_thrusters() + " thrusters. \n");
        for (int i=0; i<thrusters_rocket1.size(); i++) {
            System.out.println(thrusters_rocket1.get(i).getMax_power());
        }
        System.out.print("Rocket with code " + rocket2.getCode() + " has " + rocket2.getNum_thrusters() + " thrusters. \n");
        for (int i=0; i<thrusters_rocket2.size(); i++) {
            System.out.println(thrusters_rocket2.get(i).getMax_power());
        }

    }
}