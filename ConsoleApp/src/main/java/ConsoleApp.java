import com.dashkevich.systemcontrol.systemmonitor.App;

public class ConsoleApp {

    public static void main (String [] args) {
        System.out.println("console app start");
        Thread systemMonitoring = new Thread(new App());
        systemMonitoring.start();
        try{
            systemMonitoring.join();
        } catch (InterruptedException e){}
    }
}
