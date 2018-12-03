package com.zc.eurekaclient.primaryDomain;

import javax.persistence.*;


@Entity
@Table(name = "V_VIDEO")
public class V_Video {
    private Integer id;
    private String videoName;
    private String videoIp;
    private String videoPort;
    private String userName;
    private String password;
    private String videoSN;
    private String videoKey;
   // private String stationCode;
   // private String orgsCode;
    private Integer videoBrand;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mseq")
    @SequenceGenerator(name="mseq",sequenceName="V_VIDEO_ID_SEQ",allocationSize=1)
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "VIDEONAME")
    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    @Column(name = "VIDEOIP")
    public String getVideoIp() {
        return videoIp;
    }

    public void setVideoIp(String videoIp) {
        this.videoIp = videoIp;
    }

    @Column(name = "VIDEOPORT")
    public String getVideoPort() {
        return videoPort;
    }

    public void setVideoPort(String videoPort) {
        this.videoPort = videoPort;
    }

    @Column(name = "USERNAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "VIDEOSN")
    public String getVideoSN() {
        return videoSN;
    }

    public void setVideoSN(String videoSN) {
        this.videoSN = videoSN;
    }

    @Column(name = "VIDEOKEY")
    public String getVideoKey() {
        return videoKey;
    }

    public void setVideoKey(String videoKey) {
        this.videoKey = videoKey;
    }

 /*   @JoinColumn(name = "STATIONCODE")
    public String getStation() {
        return stationCode;
    }

    public void setStation(String station) {
        this.stationCode = station;
    }
*/

 /*   @JoinColumn(name = "ORGCODE")
    public String getOrgs() {
        return orgsCode;
    }

    public void setOrgs(String orgs) {
        this.orgsCode = orgs;
    }*/

    @Column(name = "VIDEOBRAND")
    public Integer getVideoBrand() {
        return videoBrand;
    }

    public void setVideoBrand(Integer videoBrand) {
        this.videoBrand = videoBrand;
    }


}

