
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public interface JobManager extends Remote{
    public String connectionOk() throws RemoteException;
    public void registerWorker(Worker w) throws RemoteException;
    public void unregisterWorker(Worker w) throws RemoteException;
    public Job requestJob(Worker worker) throws RemoteException;
    public void deliverJob(Job job, Worker worker) throws RemoteException;
}
