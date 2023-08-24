package com.codecampus.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsRover {
    private Long id;
    private String name;
    @JsonProperty("landing_date")
    private String landingDate;
    @JsonProperty("launch_date")
    private String launchDate;
    private String status;
    @JsonProperty("max_sol")
    private Long maxSol;
    @JsonProperty("max_date")
    private String maxDate;
    @JsonProperty("total_photos")
    private Long totalPhotos;

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

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMaxSol() {
        return maxSol;
    }

    public void setMaxSol(Long maxSol) {
        this.maxSol = maxSol;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public Long getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Long totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", landingDate='" + landingDate + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", status='" + status + '\'' +
                ", maxSol=" + maxSol +
                ", maxDate='" + maxDate + '\'' +
                ", totalPhotos=" + totalPhotos +
                '}';
    }
}
