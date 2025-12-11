package com.example.GetawaysNow.location;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IpLocationService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getClientIp() {
        String url = "https://api.ipify.org?format=json";
        IpResponse response = restTemplate.getForObject(url, IpResponse.class);
        return response != null ? response.ip : null;
    }

    public LocationResponse getLocationFromIp(String ip) {
        if (ip == null) return null;

        String url = "https://ipapi.co/" + ip + "/json/";
        return restTemplate.getForObject(url, LocationResponse.class);
    }


    public static class IpResponse {
        public String ip;
    }

    public static class LocationResponse {
        public String city;
        public String region;
        public String country;
        public String country_name;
        public Double latitude;
        public Double longitude;
    }
}
