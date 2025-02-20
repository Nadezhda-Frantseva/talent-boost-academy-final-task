package com.vmware.talentboost.springbootfinaltask.client;

import com.vmware.talentboost.springbootfinaltask.dto.DtoForTags.ImaggaTagsResponseDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

public class ImaggaClient {
    /**
     * Get basic authentication header.
     * <p>
     * Generated by Embold
     * 2022-05-21
     */
    private final String getBasicAuthenticationHeader(String username, String password) { // from Imagga
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
    /**
     * Return image response to image.
     * <p>
     * Generated by Embold
     * 2022-05-21
     */
    public ImaggaTagsResponseDto returnImage(String url) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https","api.imagga.com","/v2/tags/", "image_url=" + url, null);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getBasicAuthenticationHeader("acc_46a0171ff7e13d2","d9b3d055092d439d29e6dd5a9609e540"));
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers); // a helper object which encapsulates header and body of an HTTP request or response
        ResponseEntity<ImaggaTagsResponseDto> response = restTemplate.exchange(uri.toString(), HttpMethod.GET, requestEntity, ImaggaTagsResponseDto.class);
        //System.out.println(response.getStatusCode());
        ImaggaTagsResponseDto dto = response.getBody();
        return dto;
    }
}
