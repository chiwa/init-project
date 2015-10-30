package com.zengcode.configuration;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

@Configuration
public class ApplicationConfiguration {

	@Bean(name = "connectionString")
	@ConfigurationProperties(prefix = "config.datasource")
	public DataSource name() {
		return new ComboPooledDataSource();
	}

	@Autowired
	private MetricRegistry metricRegistry;

	@Bean
	public GraphiteReporter graphiteReporter() {
		Graphite graphite = new Graphite(new InetSocketAddress("localhost",
				2003));

		GraphiteReporter reporter = GraphiteReporter
				.forRegistry(metricRegistry).prefixedWith("Init-Application")
				.build(graphite);

		reporter.start(1000, TimeUnit.MILLISECONDS);
		return reporter;
	}



}
