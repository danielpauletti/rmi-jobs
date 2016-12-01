
import java.io.IOException;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Job implements Serializable{
    
    private int[] numbers;
    private Boolean done;
    private Boolean inProgress;
    private int id;

    public Job() {
        this.numbers = new int[10000];
        this.done = false;
        this.inProgress = false;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public StringBuilder print() throws IOException{
        
//        String fileName = "c:\\RMIJobs\\"+workerName+".txt";
//        
//        File file = new File(fileName);
//        if(file.exists()){
//            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file));
//        }else{
//            
//        }
//        FileWriter arq = new FileWriter(file);
//        PrintWriter gravarArq = new PrintWriter(file);

//        BufferedWriter gravarArq = new BufferedWriter(new FileWriter(file));        
//        String texto = "Job Nº " + this.id;
//        gravarArq.append(texto);
//        gravarArq.newLine();
//        System.out.println(texto);
//        for(int i=0;i<=numbers.length-1;i++){
//            texto = "N: " + this.numbers[i];
//            gravarArq.append(texto);
//            gravarArq.newLine();
//            System.out.println(texto);
//        }
//        texto = "-----------------------------------";
//        gravarArq.append(texto);
//        gravarArq.newLine();
//        System.out.println(texto);
//        
//        gravarArq.close();

        StringBuilder sb = new StringBuilder();
        String texto = "Job Nº " + this.id + "\n";
        sb.append(texto);
        for(int i=0;i<=this.numbers.length-1;i++){
            texto = "N: " + this.numbers[i] + "\n";
            sb.append(texto);
        }
        texto = "-----------------------------------\n";
        sb.append(texto);
        
        return sb;
    }
    
}
