package com.example.demospringbatch.listener;

import com.example.demospringbatch.model.Persona;
import com.example.demospringbatch.processor.PersonaItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.CompositeJobExecutionListener;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
//public class JobListener extends JobExecutionListenerSupport {
public class JobListener extends CompositeJobExecutionListener {
    private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOG.info("Finalizo el Job! verifica los resultados:");

            jdbcTemplate
                    .query("SELECT id, primer_nombre, segundo_nombre, dni FROM persona",
                            (rs, row) -> new Persona(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)))
                    .forEach(persona -> LOG.info("Registro < " + persona + " >"));
        }
    }
}
