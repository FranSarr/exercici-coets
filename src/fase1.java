public class fase1 {
    public static void main(String[] args) {
        Coet rocket1 = new Coet("32WESSDS", 3);
        Coet rocket2 = new Coet("LDSFJA32", 6);

        System.out.print("Rocket with code " + rocket1.getCode() + " has " + rocket1.getNum_thrusters() + " thrusters. \n");
        System.out.print("Rocket with code " + rocket2.getCode() + " has " + rocket2.getNum_thrusters() + " thrusters. \n");


    }
}
