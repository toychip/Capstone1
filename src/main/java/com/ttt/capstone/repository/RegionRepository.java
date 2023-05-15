package com.ttt.capstone.repository;

import com.ttt.capstone.service.SmallNameResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SmallNameResponse> getSeoul(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.seoul WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getBusan(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.busan WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getChungcheongbukdo(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.chungcheongbukdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getChungcheongnamdo(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.chungcheongnamdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getDaegu(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.daegu WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getDaejeon(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.daejeon WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGandwondo(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gandwondo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGwangju(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gwangju WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGyeonggido(String request) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gyeonggido WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{request}, new SmallNameResponseRowMapper());
    }

    private static class SmallNameResponseRowMapper implements RowMapper<SmallNameResponse> {
        @Override
        public SmallNameResponse mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Long number = resultSet.getLong("number");
            String name = resultSet.getString("name");
            String localAddress = resultSet.getString("localAddress");
            String roadAddress = resultSet.getString("roadAddress");
            String newPostalCode = resultSet.getString("newPostalCode");
            String smallName = resultSet.getString("smallName");
            int newPostalCodeInt = Integer.parseInt(newPostalCode);

            return new SmallNameResponse(number, name, localAddress, roadAddress, newPostalCodeInt, smallName);
        }
    }

}
