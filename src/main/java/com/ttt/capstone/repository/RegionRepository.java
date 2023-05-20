package com.ttt.capstone.repository;

import com.ttt.capstone.service.SmallNameResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<SmallNameResponse> getSeoul(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.seoul", pageable);
    }
    
    public List<SmallNameResponse> getBusan(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.busan", pageable);
    }

    public List<SmallNameResponse> getChungcheongbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.chungcheongbukdo",pageable);
    }

    public List<SmallNameResponse> getChungcheongnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.chungcheongnamdo", pageable);
    }

    public List<SmallNameResponse> getDaegu(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.daegu", pageable);
    }

    public List<SmallNameResponse> getDaejeon(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.daejeon", pageable);
    }

    public List<SmallNameResponse> getGandwondo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.gandwondo", pageable);
    }

    public List<SmallNameResponse> getGwangju(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.gwangju", pageable);
    }

    public List<SmallNameResponse> getGyeonggido(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.gyeonggido", pageable);
    }

    public List<SmallNameResponse> getGyeongsangnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.gyeongsangnamdo", pageable);
    }

    public List<SmallNameResponse> getGyeongsangbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.gyeongsangbukdo", pageable);
    }

    public List<SmallNameResponse> getIncheon(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.incheon", pageable);
    }

    public List<SmallNameResponse> getJejudo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.jejudo", pageable);
    }

    public List<SmallNameResponse> getJeollabukdo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.jeollabukdo", pageable);
    }

    public List<SmallNameResponse> getJeollanamdo(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.jeollanamdo", pageable);
    }

    public List<SmallNameResponse> getSejong(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.sejong", pageable);
    }

    public List<SmallNameResponse> getUlsan(String smallCode, Optional<String> district, Pageable pageable) {
        return this.getRegionData(smallCode, district, "tttdatabase.ulsan", pageable);
    }

//    private List<SmallNameResponse> getRegionData(String smallCode, Optional<String> district, String tableName, Pageable pageable) {
//        List<Object> params = new ArrayList<>();
//        params.add(smallCode);
//
//        String baseQueryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
//                "FROM " + tableName + " WHERE smallCode = ? ";
//
//        // dietrict가 존재한다면
//        if (district.isPresent()) {
//            baseQueryString += "AND roadName LIKE ? ";
//            params.add("%" + district.get() + "%");
//        }
//
//        baseQueryString += "LIMIT ? OFFSET ?";
//
//        params.add(pageable.getPageSize());
//        params.add(pageable.getOffset());
//
//        return jdbcTemplate.query(baseQueryString, params.toArray(), new SmallNameResponseRowMapper());
//    }
//
//
//
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

    //    범위를 벗어난 페이지를 조회할 경우 존재하는 가장 뒷 페이지로 이동하는 로직 추가
    public int getTotalDataCount(String smallCode, Optional<String> district, String tableName) {
        String baseQueryString = "SELECT COUNT(*) FROM " + tableName + " WHERE smallCode = ? ";

        List<Object> params = new ArrayList<>();
        params.add(smallCode);

        if (district.isPresent()) {
            baseQueryString += "AND roadName LIKE ? ";
            params.add("%" + district.get() + "%");
        }

        return jdbcTemplate.queryForObject(baseQueryString, Integer.class, params.toArray());
    }

    private List<SmallNameResponse> getRegionData(String smallCode, Optional<String> district, String tableName, Pageable pageable) {
        List<Object> params = new ArrayList<>();
        params.add(smallCode);

        String baseQueryString = "SELECT number, name, localAddress, roadAddress, newPostalCode, smallName " +
                "FROM " + tableName + " WHERE smallCode = ? ";

        if (district.isPresent()) {
            baseQueryString += "AND roadName LIKE ? ";
            params.add("%" + district.get() + "%");
        }

        int totalDataCount = getTotalDataCount(smallCode, district, tableName);
        int totalPages = totalDataCount / pageable.getPageSize();
        if (totalDataCount % pageable.getPageSize() != 0) {
            totalPages++;
        }

        int pageNumber = pageable.getPageNumber();
        if (pageNumber >= totalPages) {
            pageNumber = Math.max(0, totalPages - 1);
            pageable = PageRequest.of(pageNumber, pageable.getPageSize());
        }

        baseQueryString += "LIMIT ? OFFSET ?";

        params.add(pageable.getPageSize());
        params.add(pageable.getOffset());

        return jdbcTemplate.query(baseQueryString, params.toArray(), new SmallNameResponseRowMapper());
    }


}
