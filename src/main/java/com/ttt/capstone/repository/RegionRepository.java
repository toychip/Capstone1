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

    public List<SmallNameResponse> getSeoul(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.seoul WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getBusan(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.busan WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getChungcheongbukdo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.chungcheongbukdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getChungcheongnamdo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.chungcheongnamdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getDaegu(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.daegu WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getDaejeon(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.daejeon WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGandwondo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gandwondo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGwangju(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gwangju WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGyeonggido(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gyeonggido WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGyeongsangnamdo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gyeongsangnamdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getGyeongsangbukdo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.gyeongsangbukdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getIncheon(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.incheon WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getJejudo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.jejudo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getJellabukdo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.jellabukdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getJellanamdo(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.jellanamdo WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getSejong(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.sejong WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
    }

    public List<SmallNameResponse> getUlsan(String smallCode) {
        String queryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM tttdatabase.ulsan WHERE smallCode = ?";

        return jdbcTemplate.query(queryString, new Object[]{smallCode}, new SmallNameResponseRowMapper());
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
