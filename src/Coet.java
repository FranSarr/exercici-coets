import java.util.ArrayList;
import java.util.List;

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
}

