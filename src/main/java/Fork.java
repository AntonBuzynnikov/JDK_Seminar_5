public class Fork {

    private int idFork;
    private String state;
    public Fork(int idFork){
        this.idFork = idFork;
        state = "Free";
    }

    public synchronized String getState() {
        return state;
    }

    public synchronized void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Вилки № " + idFork;
    }

}
