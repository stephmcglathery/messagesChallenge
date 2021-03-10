package com.example.demo.dao;

import com.example.demo.model.Message;
import com.example.demo.service.DemoServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class DemoDaoImpl extends JdbcDaoSupport implements DemoDao {

    private final static Logger log = Logger.getLogger(DemoServiceImpl.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize() { setDataSource(dataSource);}

    @Override
    public int insertHashedMessage(Message message) {

        final String query = "INSERT INTO messages (message, hash) VALUES (:message, :hash)";

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("message", message.getMessage());
        mapSqlParameterSource.addValue("hash", message.getHash());

        return jdbcTemplate.update(query, mapSqlParameterSource);
    }

    @Override
    public String getMessageFromHash(String hash) {

        final String query = "SELECT message FROM messages WHERE hash = :hash LIMIT 1 ";

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("hash", hash);

        return jdbcTemplate.queryForObject(query, mapSqlParameterSource, String.class);
    }
}