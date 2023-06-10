package com.ttt.capstone.naverblog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NaverBlogData {
    @JsonProperty("title")
    private String title;

    @JsonProperty("link")
    private String link;

    @JsonProperty("description")
    private String description;

    @JsonProperty("bloggername")
    private String bloggerName;

    @JsonProperty("bloggerlink")
    private String bloggerLink;

    @JsonProperty("postdate")
    private String postDate;
}
