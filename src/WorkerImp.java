
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class WorkerImp extends UnicastRemoteObject implements Worker {
    
    private Boolean working;
    private String name;

    public WorkerImp() throws RemoteException {
        super();
        this.working = false;
    }

    @Override
    public Boolean getWorking() {
        return this.working;
    }

    public Job doJob(Job job) {
        int aux = 0;
	int i = 0;
        int conjuntoLength = job.getNumbers().length;
        
        this.working = true;
        
        for(i=0;i<conjuntoLength;i++){
            for(int j=0;j<conjuntoLength-1;j++){
                if(job.getNumbers()[j] > job.getNumbers()[j+1]){
                    aux = job.getNumbers()[j];
                    job.getNumbers()[j] = job.getNumbers()[j+1];
                    job.getNumbers()[j+1] = aux;
                }
            }
        }
        
        this.working = false;
        
        return job;
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
