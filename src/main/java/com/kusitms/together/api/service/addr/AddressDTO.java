package com.kusitms.together.api.service.addr;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class AddressDTO {
    private Status status;
    List<Result> results;


//    private String name;
//    private Code code;
//    private Region region;
//    private Land land;

    // 생성자, getter, setter 메소드

    @Data
    public static class Result {
        private String name;
        private Code code;
        private Region region;
        private Land land;



        // 생성자, getter, setter 메소드
    }
    @Data
    public static class Status{
        private int code;
        private String name;
        private String message;
    }
    @Data
    public static class Code {
        private String id;
        private String type;
        private String mappingId;

        // 생성자, getter, setter 메소드
    }

    @Data
    public static class Region {
        private Area0 area0;
        private Area1 area1;
        private Area2 area2;
        private Area3 area3;
        private Area4 area4;

        // 생성자, getter, setter 메소드
    }

    @Data
    public static class Area0 {
        private String name;
        private Coords coords;

        // 생성자, getter, setter 메소드
    }

    @Data
    public static class Coords {
        private Center center;

        // 생성자, getter, setter 메소드
    }

    @Data
    public static class Center {
        private String crs;
        private Double x;
        private Double y;

        // 생성자, getter, setter 메소드
    }
    @Data
    public static class Area1 {
        // Area0 클래스와 같은 구조
        private String name;
        private Coords coords;
        private String alias;
    }
    @Data
    public static class Area2 {
        // Area0 클래스와 같은 구조
        private String name;
        private Coords coords;
    }
    @Data

    public static class Area3 {
        // Area0 클래스와 같은 구조
        private String name;
        private Coords coords;
    }

    @Data

    public static class Area4 {
        // Area0 클래스와 같은 구조
        private String name;
        private Coords coords;
    }

    @Data
    public static class Land {
        private String type;
        private String number1;
        private String number2;
        private Addition addition0;
        private Addition addition1;
        private Addition addition2;
        private Addition addition3;
        private Addition addition4;
        private Coords coords;

        // 생성자, getter, setter 메소드
    }

    @Data
    public static class Addition {
        private String type;
        private String value;

        // 생성자, getter, setter 메소드
    }
}
