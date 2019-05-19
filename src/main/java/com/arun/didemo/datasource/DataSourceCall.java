package com.arun.didemo.datasource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataSourceCall {

    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    public List<Account> getAccounts() {

        String sqlQuery = "select id, name, capital, currency from country";

        return mysqlJdbcTemplate.query(sqlQuery, (rs, rn) -> {
            Account account = new Account();
            account.setId(rs.getString("id"));
            account.setCapital(rs.getString("capital"));
            account.setCurrency(rs.getString("currency"));
            account.setName(rs.getString("name"));
            return account;
        });
    }
}

@Getter
@Setter
@ToString
class Account {
    private String id;
    private String name;
    private String capital;
    private String currency;
}
