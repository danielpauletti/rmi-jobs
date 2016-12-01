
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class JobsManagerRun {
    
    static JobsManagerService manager;
    
    public static void main(String[] args) {
        startRegistry();
    }
    
    public static void startRegistry(){
        try {
            manager = new JobsManagerService();
            Registry r = LocateRegistry.createRegistry(8088);
            String uri = "rmi://localhost:8088/manager";
            Naming.rebind(uri, manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
