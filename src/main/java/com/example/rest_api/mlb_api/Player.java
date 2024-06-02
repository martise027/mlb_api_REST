package com.example.rest_api.mlb_api;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="stats_2024")
public class Player{

    @Id
    private String name;
    private String team;
    private String position;
    private Integer g;
    private Integer AB;
    private Integer r;
    private Integer h;
    private Integer dHits;
    private Integer tHits;
    private Integer homerun;
    private Integer RBI;
    private Integer BB;
    private Integer SO;
    private Integer SB;
    private Integer CS;
    private Float AVG;
    private Float OBP;
    private Float SLG;
    private Float OPS;

    public Player(){}

    public Player(String name, String team, String position, Integer g, Integer AB, Integer r, Integer h, Integer dHits, Integer tHits, Integer homerun, Integer RBI, Integer BB, Integer SO, Integer SB, Integer CS, Float AVG, Float OBP, Float SLG, Float OPS) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.g = g;
        this.AB = AB;
        this.r = r;
        this.h = h;
        this.dHits = dHits;
        this.tHits = tHits;
        this.homerun = homerun;
        this.RBI = RBI;
        this.BB = BB;
        this.SO = SO;
        this.SB = SB;
        this.CS = CS;
        this.AVG = AVG;
        this.OBP = OBP;
        this.SLG = SLG;
        this.OPS = OPS;
    }

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getAB() {
        return AB;
    }

    public void setAB(Integer AB) {
        this.AB = AB;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getdHits() {
        return dHits;
    }

    public void setdHits(Integer dHits) {
        this.dHits = dHits;
    }

    public Integer gettHits() {
        return tHits;
    }

    public void settHits(Integer tHits) {
        this.tHits = tHits;
    }

    public Integer getHomerun() {
        return homerun;
    }

    public void setHomerun(Integer homerun) {
        this.homerun = homerun;
    }

    public Integer getRBI() {
        return RBI;
    }

    public void setRBI(Integer RBI) {
        this.RBI = RBI;
    }

    public Integer getBB() {
        return BB;
    }

    public void setBB(Integer BB) {
        this.BB = BB;
    }

    public Integer getSO() {
        return SO;
    }

    public void setSO(Integer SO) {
        this.SO = SO;
    }

    public Integer getSB() {
        return SB;
    }

    public void setSB(Integer SB) {
        this.SB = SB;
    }

    public Integer getCS() {
        return CS;
    }

    public void setCS(Integer CS) {
        this.CS = CS;
    }

    public Float getAVG() {
        return AVG;
    }

    public void setAVG(Float AVG) {
        this.AVG = AVG;
    }

    public Float getOBP() {
        return OBP;
    }

    public void setOBP(Float OBP) {
        this.OBP = OBP;
    }

    public Float getSLG() {
        return SLG;
    }

    public void setSLG(Float SLG) {
        this.SLG = SLG;
    }

    public Float getOPS() {
        return OPS;
    }

    public void setOPS(Float OPS) {
        this.OPS = OPS;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", position='" + position + '\'' +
                ", g=" + g +
                ", AB=" + AB +
                ", r=" + r +
                ", h=" + h +
                ", dHits=" + dHits +
                ", tHits=" + tHits +
                ", homerun=" + homerun +
                ", RBI=" + RBI +
                ", BB=" + BB +
                ", SO=" + SO +
                ", SB=" + SB +
                ", CS=" + CS +
                ", AVG=" + AVG +
                ", OBP=" + OBP +
                ", SLG=" + SLG +
                ", OPS=" + OPS +
                '}';
    }
}