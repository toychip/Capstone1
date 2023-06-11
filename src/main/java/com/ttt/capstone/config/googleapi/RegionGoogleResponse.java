package com.ttt.capstone.config.googleapi;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegionGoogleResponse {
    private Integer number;
    private String name;
    private String branchName;
    private String largeCode;
    private String largeName;
    private String mediumCode;
    private String mediumName;
    private String smallCode;
    private String smallName;
    private Long dongNumber;
    private String dongName;
    private String localAddress;
    private String roadName;
    private String roadAddress;
    private Long oldPostalCode;
    private Long newPostalCode;
    private String longitude;
    private String latitude;

    private Double rating;
    private Map<String, Object> openingHours;

    private String formattedPhoneNumber;
    private List<Map<String, Object>> reviews;

}
