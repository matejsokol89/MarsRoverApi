package com.codecampus.service;

import com.codecampus.dto.HomeDto;
import com.codecampus.repository.PreferencesRepository;
import com.codecampus.response.MarsPhoto;
import com.codecampus.response.MarsRoverApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


@Service
public class MarsRoverApiService {
    private static final String API_KEY = "fjAoeEym4RzGpucEWUpmBohgNs6GeD2DflXhw0kX";
    private Map<String, List<String>> validCameras = new HashMap<>();
    @Autowired
    private PreferencesRepository preferencesRepository;

    public MarsRoverApiService() {
        validCameras.put("Opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
        validCameras.put("Curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
        validCameras.put("Spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
    }

    public MarsRoverApiResponse getRoverData(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        RestTemplate rt = new RestTemplate();

        List<String> apiUrlEndpoints = getApiUrlEndpoints(homeDto);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsRoverApiResponse response = new MarsRoverApiResponse();

        apiUrlEndpoints.stream()
                .forEach(url -> {
                    MarsRoverApiResponse apiResponse = rt.getForObject(url, MarsRoverApiResponse.class);
                    photos.addAll(apiResponse.getPhotos());
                });

        response.setPhotos(photos);

        return response;
    }

    public List<String> getApiUrlEndpoints(HomeDto homeDto) throws InvocationTargetException, IllegalAccessException {
        List<String> urls = new ArrayList<>();

        Method[] methods = homeDto.getClass().getMethods();
// getting all selected cameras methods
        for (Method method : methods) {
            if (method.getName().indexOf("getCamera") > -1 && Boolean.TRUE.equals(method.invoke(homeDto))) {
                String cameraName = method.getName().split("getCamera")[1].toUpperCase();
                System.out.println(cameraName);
                System.out.println(validCameras.get(homeDto.getMarsApiRoverData()));
                if (validCameras.get(homeDto.getMarsApiRoverData()).contains(cameraName)) {
                    urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + homeDto.getMarsApiRoverData() + "/photos?sol=" + homeDto.getMarsSol() + "&api_key=" + API_KEY + "&camera="+cameraName);

                }
            }
        }
        return urls;
    }
    public Map<String, List<String>> getValidCameras() {
        return validCameras;
    }

    public HomeDto save(HomeDto homeDto) {
        return preferencesRepository.save(homeDto);

    }

    public HomeDto findByUserid(Long userId) {
        return preferencesRepository.findByUserId(userId);
    }
}