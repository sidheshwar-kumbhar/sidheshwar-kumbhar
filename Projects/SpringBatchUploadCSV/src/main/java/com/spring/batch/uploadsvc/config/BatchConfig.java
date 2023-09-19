package com.spring.batch.uploadsvc.config;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.spring.batch.uploadsvc.entity.User;
import com.spring.batch.uploadsvc.entity.repositry.UserRepositry;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public FlatFileItemReader<User> reader() {
		FlatFileItemReader<User> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/user.csv"));
		itemReader.setName("userReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(this.userLineMapper());

		return itemReader;
	}

	private LineMapper<User> userLineMapper() {
		DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setStrict(false);
		delimitedLineTokenizer.setNames("name", "age", "city", "contry", "state");

		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(User.class);

		lineMapper.setLineTokenizer(delimitedLineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;

	}

	@Bean
	UserProcessor processor() {
		return new UserProcessor();
	}

	@Bean
	RepositoryItemWriter<User> writer() {
		RepositoryItemWriter<User> writer = new RepositoryItemWriter<>();
		writer.setRepository(userRepositry);
		writer.setMethodName("save");
		return writer;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step")
				.<User, User>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				//.taskExecutor(taskExecutor())
				.build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("db-to-csv-step")
				.<User, User>chunk(1)
				.reader(userReader())
				.writer(userWriter())
				//.taskExecutor(taskExecutor())
				.build();

	}

	@Bean
	public FlatFileItemWriter<User> userWriter() {
		FlatFileItemWriter<User> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("C://data/batch/data.csv"));
		//DelimitedLineAggregator<User> aggregator = new DelimitedLineAggregator<>();
		writer.setLineAggregator(getDelimitedLineAggregator());
		return writer;
	}

	private DelimitedLineAggregator<User> getDelimitedLineAggregator() {
		BeanWrapperFieldExtractor<User> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<User>();
		beanWrapperFieldExtractor.setNames(new String[] { "id", "name", "age", "city", "contry", "state" });
		DelimitedLineAggregator<User> aggregator = new DelimitedLineAggregator<User>();
		aggregator.setDelimiter(",");
		aggregator.setFieldExtractor(beanWrapperFieldExtractor);
		return aggregator;
	}

	@Bean
	public JdbcCursorItemReader<User> userReader() {
		JdbcCursorItemReader<User> reader = new JdbcCursorItemReader<>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT id, name, age, city, contry, state FROM user");
		reader.setRowMapper(new UserResultRowMapper());
		return reader;
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importCustomers").incrementer(new RunIdIncrementer())
				.flow(step2())
				//.next(step2())
				.end()
				.build();

	}

	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		asyncTaskExecutor.setConcurrencyLimit(10);
		return asyncTaskExecutor;
	}
}
