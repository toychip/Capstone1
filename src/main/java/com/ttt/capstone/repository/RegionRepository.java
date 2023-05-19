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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RegionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SmallNameResponse> getSeoul(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.seoul");
    }
    
    public List<SmallNameResponse> getBusan(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.busan");
    }

    public List<SmallNameResponse> getChungcheongbukdo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.chungcheongbukdo");
    }

    public List<SmallNameResponse> getChungcheongnamdo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.chungcheongnamdo");
    }

    public List<SmallNameResponse> getDaegu(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.daegu");
    }

    public List<SmallNameResponse> getDaejeon(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.daejeon");
    }

    public List<SmallNameResponse> getGandwondo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.gandwondo");
    }

    public List<SmallNameResponse> getGwangju(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.gwangju");
    }

    public List<SmallNameResponse> getGyeonggido(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.gyeonggido");
    }

    public List<SmallNameResponse> getGyeongsangnamdo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.gyeongsangnamdo");
    }

    public List<SmallNameResponse> getGyeongsangbukdo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.gyeongsangbukdo");
    }

    public List<SmallNameResponse> getIncheon(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.incheon");
    }

    public List<SmallNameResponse> getJejudo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.jejudo");
    }

    public List<SmallNameResponse> getJeollabukdo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.jeollabukdo");
    }

    public List<SmallNameResponse> getJeollanamdo(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.jeollanamdo");
    }

    public List<SmallNameResponse> getSejong(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.sejong");
    }

    public List<SmallNameResponse> getUlsan(String smallCode, Optional<String> district) {
        return this.getRegionData(smallCode, district, "tttdatabase.ulsan");
    }

    private List<SmallNameResponse> getRegionData(String smallCode, Optional<String> district, String tableName) {
        String baseQueryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM " + tableName + " WHERE smallCode = ?";

        List<Object> params = new ArrayList<>();
        params.add(smallCode);

        // If district is provided, add it to the query
        // district가 null이 아니라면 해당 쿼리 추가
        if (district.isPresent()) {
            baseQueryString += " AND roadName LIKE ?";
            params.add("%" + district.get() + "%");
        }

        return jdbcTemplate.query(baseQueryString, params.toArray(), new SmallNameResponseRowMapper());
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
