package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("workerDao1")
public class WorkerDao {
	//建議寫在屬性上，注意建構子
	@Autowired @Qualifier("work2")
    private Worker worker;
	
	public WorkerDao() {		
	}
    
	public WorkerDao(Worker worker) {
		this.worker = worker;
	}
//	@Autowired 
//    public WorkerDao(@Qualifier("work2") Worker worker) {
//    	this.worker = worker;
//    }

	
	public void printDetails() {
		System.out.println("id: "+worker.getId());
		System.out.println("name: "+worker.getName());
		System.out.println("title: "+worker.getTitle());
	}
}
