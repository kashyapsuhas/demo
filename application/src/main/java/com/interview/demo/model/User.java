package com.interview.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "UserDetails")
@Getter
@Setter
public class User {
    @Id
    private String id;
    @JsonProperty ("user Name")
    private String userName;
    @JsonProperty("Status")
    private Boolean isActive;
    @JsonProperty("Email")
    private String email;
}