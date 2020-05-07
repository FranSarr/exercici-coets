public class Thruster {
    protected Integer max_power;
    protected Integer current_power;
    private boolean disponible=false;

    public Thruster(Integer max_power, Integer current_power) {
        this.max_power = max_power;
        this.current_power = current_power;
    }

    public Integer getMax_power() {
        return max_power;
    }

    public Integer getCurrent_power() { return current_power; }


    public void setCurrent_power(Integer current_power){
        this.current_power = current_power;
    }


}
