import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Coet {
    protected String code;
    protected Integer num_thrusters;
    protected List<Thruster> thruster_list = new ArrayList<Thruster>();

    public String getCode() {
        return code;
    }

    public Integer getNum_thrusters() {
        return num_thrusters;
    }

    public Coet(String code, Integer num_thrusters) {
        this.code = code;
        this.num_thrusters = num_thrusters;
    }

    public List<Thruster> getThruster_list() {
        return thruster_list;
    }

    public void setThruster_list(List<Thruster> thruster_list) {
        this.thruster_list = thruster_list;
    }

    public static class ThrustControl extends Thread {
        private Thread t;
        private String threadName;
        private Thruster propulsor;
        Integer potencia_obj;

        ThrustControl ( String name, Thruster propul, Integer objetivo) {
            threadName = name;
            propulsor = propul;
            potencia_obj = objetivo;
            System.out.println("Accelerating " +  threadName );
        }
        public void run() {
            System.out.println("Running " +  threadName );
            try {

                if (propulsor.getCurrent_power() <= potencia_obj){
                    for (int i = propulsor.getCurrent_power(); i <= potencia_obj; i++) {
                    if (i == propulsor.getMax_power()) {
                        propulsor.setCurrent_power(i);
                        System.out.print("El propulsor " + threadName + " ha llegado a su máxima potencia de " + propulsor.getCurrent_power() + "\n");
                        break;
                    } else {
                        propulsor.setCurrent_power(i);
                        System.out.print("El propulsor " + threadName + " tiene una potencia actual de " + propulsor.getCurrent_power() + "\n");
                    }
                    Thread.sleep(50);
                    }
                } else {
                    for ( int i = propulsor.getCurrent_power();i >= potencia_obj; i-- ){
                        if ( i == 0 ){
                            propulsor.setCurrent_power(i);
                            System.out.print("El propulsor " + threadName +" se ha parado satisfactoriamente." + "\n");
                            break;
                        } else {
                            propulsor.setCurrent_power(i);
                            System.out.print("El propulsor " + threadName +" tiene una potencia actual de " + propulsor.getCurrent_power() + "\n");
                        }
                        Thread.sleep(50);
                    }
                }


            } catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }
        public void start () {
            System.out.println("Starting " +  threadName );
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }

}

