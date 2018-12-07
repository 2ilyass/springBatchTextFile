package com.ensa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringBatchApplication {

	public static void main(String[] args) throws Exception {
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/ensa/conf/spring-conf.xml");
//		PersonneDao dao = (PersonneDao) context.getBean("personneDaoImpl");
//		Personne personne = new Personne(1215, "ghassane", "lem", "Marocain");
//		dao.ajoutPersonne(personne);
//		
		

		Job job = (Job) ctx.getBean("importPersonnes");
        JobParametersBuilder jobBuilder= new JobParametersBuilder();
        jobBuilder.addString("Addpersonne","Personne ajout�");
        jobBuilder.addLong("Current Time", System.currentTimeMillis());
        JobParameters jobParameters = jobBuilder.toJobParameters();
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher"); 
		JobExecution execution = jobLauncher.run(job, jobParameters);
		System.out.println("Completion Status : " + execution.getStatus());
		ctx.close();
		
	}
}
