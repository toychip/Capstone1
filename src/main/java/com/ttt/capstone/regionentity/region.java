package com.ttt.capstone.regionentity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class region {

    @Id
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "largeCode", nullable = false)
    private String largeCode;

    @Column(name = "largeName", nullable = false)
    private String largeName;

    @Column(name = "mediumCode", nullable = false)
    private String mediumCode;

    @Column(name = "mediumName", nullable = false)
    private String mediumName;

    @Column(name = "smallCode", nullable = false)
    private String smallCode;

    @Column(name = "smallName", nullable = false)
    private String smallName;

    @Column(name = "dongNumber", nullable = false)
    private Long dongNumber;

    @Column(name = "dongName", nullable = false)
    private String dongName;

    @Column(name = "localAddress", nullable = false)
    private String localAddress;

    @Column(name = "roadName", nullable = false)
    private String roadName;

    @Column(name = "roadAddress", nullable = false)
    private String roadAddress;

    @Column(name = "oldPostalCode", nullable = false)
    private Long oldPostalCode;

    @Column(name = "newPostalCode", nullable = false)
    private Long newPostalCode;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "latitude", nullable = false)
    private String latitude;
}
