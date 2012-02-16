package org.krams.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.krams.dto.StatusResponse;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/batch")
public class BatchJobController {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired @Qualifier("batchJob1")
	private Job job1;
	
	@Autowired @Qualifier("batchJob2")
	private Job job2;
	
	@Autowired @Qualifier("batchJob3")
	private Job job3;
	
	@RequestMapping(value="/job1")
	public @ResponseBody StatusResponse job1() {
		try {
			Map<String,JobParameter> parameters = new HashMap<String,JobParameter>();
			parameters.put("date", new JobParameter(new Date()));
			
			jobLauncher.run(job1, new JobParameters(parameters));
			return new StatusResponse(true);
			
		} catch (JobInstanceAlreadyCompleteException ex) {
			return new StatusResponse(false, "This job has been completed already!");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping(value="/job2")
	public @ResponseBody StatusResponse job2() {
		try {
			jobLauncher.run(job2, new JobParameters());
			return new StatusResponse(true);
			
		} catch (JobInstanceAlreadyCompleteException ex) {
			return new StatusResponse(false, "This job has been completed already!");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping(value="/job3")
	public @ResponseBody StatusResponse job3() {
		try {
			jobLauncher.run(job3, new JobParameters());
			return new StatusResponse(true);
			
		} catch (JobInstanceAlreadyCompleteException ex) {
			return new StatusResponse(false, "This job has been completed already!");
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
