
import java.rmi.Naming;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class WorkerRun {
    
    static JobManager manager;
    static WorkerImp worker;
    
    public static void main(String[] args) {
        try {            
            manager = (JobManager) Naming.lookup("rmi://localhost:8088/manager");
            worker = new WorkerImp();
            worker.setName( JOptionPane.showInputDialog("Nome do worker") );
            manager.registerWorker(worker);
            
            while(true){
                Job job = manager.requestJob(worker);
                job = worker.doJob(job);
                if(job!=null){
                    manager.deliverJob(job, worker);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
