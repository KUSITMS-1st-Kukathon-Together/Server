package com.kusitms.together.api.controller.addr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class NaverGeoApi {

    String clientId = "yza6l09ms5 ";  //clientId
    String clientSecret = "O4adfQLtt58vCPGwgHkPZqXlHe8Iyzewk3g2mFuZ ";  //clientSecret

    public String getAddr (String lat, String lng) throws Exception {

            try {

                String apiURL = "https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords=+" + lng+","+lat +
                        "&sourcecrs=" + "epsg:4326" +
                        "&orders=" + "addr" +
                        "&output=" + "json";

                URL url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
                con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
                int responseCode = con.getResponseCode();
                BufferedReader br;
                if (responseCode == 200) {
                    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                } else {
                    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                }
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();

                String s = response.toString();

                ObjectMapper objectMapper = new ObjectMapper();
                AddressDTO addressDTO = objectMapper.readValue(s, AddressDTO.class);
                System.out.println("please");

                AddressDTO.Result result = addressDTO.getResults().get(0);
                String name1 = result.getRegion().getArea1().getName();
                String name2 = result.getRegion().getArea2().getName();
                String name3 = result.getRegion().getArea3().getName();

                return name1 + " " + name2 + " " + name3;


            } catch (Exception e) {
                System.out.println(e);
            }

            return "올바르지 않은 정보입니다.";

        }

}