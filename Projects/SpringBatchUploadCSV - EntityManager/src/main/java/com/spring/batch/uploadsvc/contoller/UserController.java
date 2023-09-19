package com.spring.batch.uploadsvc.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.batch.uploadsvc.entity.User;
import com.spring.batch.uploadsvc.service.IUserService;


@RestController
public class UserController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	@Autowired
	private IUserService userService;

	@GetMapping(value = "/executejob", produces = MediaType.APPLICATION_JSON_VALUE)
	public void executejob(HttpServletRequest request) {
		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("startAt", System.currentTimeMillis())
				.toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}

	}
	
	@GetMapping(value = "/user/custom/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getCustomUser(HttpServletRequest request, @PathVariable("id") int id) {
		return userService.customFindMethod(id);
	}
}
