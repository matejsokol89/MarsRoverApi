package com.codecampus.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsCamera {
    private Long id;
    private String name;
    @JsonProperty("rover_id")
    private Integer roverId;
    @JsonProperty("full_name")
    private String fullName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoverId() {
        return roverId;
    }

    public void setRoverId(Integer roverId) {
        this.roverId = roverId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
