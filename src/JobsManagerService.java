
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class JobsManagerService extends UnicastRemoteObject implements JobManager{
    
    List<Worker> workers = new ArrayList<>();
    List<Job> jobs = new ArrayList<>();
    List<DoneScreen> screens = new ArrayList<>();
    
    private int[] generateNumbers(){
        Random gen = new Random();
        int tamanho = 10000;
        int[] conjunto = new int[tamanho];
        
        for(int i=0;i<tamanho;i++){
            conjunto[i] = gen.nextInt(10001);
        }
        
        return conjunto;        
    }
    
    private void generateLists(int amount){
        for(int i=0;i<amount;i++){
            Job j = new Job();
            j.setId(i+1);
            j.setNumbers(generateNumbers());
            jobs.add(j);
        }
    }

    public JobsManagerService() throws RemoteException {
        super();
        generateLists(10);
    }
    
    private Job getJobToDo(){
        for(Job j:this.jobs){
            if(!j.getDone() && !j.getInProgress()){
                return j;
            }
        }
        
        return null;
    }

    @Override
    public String connectionOk() throws RemoteException {
        return "Worker connected!";
    }

    @Override
    public void registerWorker(Worker w) throws RemoteException {
        workers.add(w);
    }

    @Override
    public void unregisterWorker(Worker w) throws RemoteException {
        workers.remove(w);
    }
    
    private void showScreen(String workerName, StringBuilder numbers){
        for(DoneScreen ds:screens){
            if(ds.getWorkerName().equals(workerName)){
                ds.setNumbers(numbers);
                return;
            }
        }
        
        DoneScreen ds = new DoneScreen();
        ds.setTitle(workerName);
        ds.setWorkerName(workerName);
        ds.setNumbers(numbers);
        this.screens.add(ds);
        ds.setVisible(true);
        return;
    }

    @Override
    public Job requestJob(Worker worker) throws RemoteException {
        Job job = getJobToDo();
        if(job!=null){
            job.setInProgress(true);
        }
        return job;
    }

    @Override
    public void deliverJob(Job job, Worker worker) throws RemoteException {
        //Recebe o job pronto e procura ele na lista para atualizar
        Job jobInList = findById(job.getId());
        jobInList.setDone(true);
        jobInList.setInProgress(false);
        jobInList.setNumbers(job.getNumbers());
        
        try{
            showScreen(worker.getName(), job.print());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private Job findById(int id){
        for(Job j:this.jobs){
            if(j.getId() == id){
                return j;
            }
        }
        
        return null;
    }
    
}
