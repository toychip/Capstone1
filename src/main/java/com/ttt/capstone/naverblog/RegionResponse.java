package com.ttt.capstone.naverblog;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegionResponse<T> {
    private T regionData;
    private List<NaverBlogData> naverBlogDataList;

    public RegionResponse(T regionData, List<NaverBlogData> naverBlogDataList) {
        this.regionData = regionData;
        this.naverBlogDataList = naverBlogDataList;
    }
}