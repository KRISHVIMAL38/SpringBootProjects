package com.third.api.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.val;

@Service
public class PostServiceImpl implements PostService{

	String baseUrl="https://jsonplaceholder.typicode.com/";
	String builder=new String(baseUrl);
	String POST="/posts";
	String POSTBYID="/posts/";
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<Map<String, Object>> getAllPosts() {
		HttpEntity<Void>httpEntity=new HttpEntity<>(getHttpHeaders());
		String url=builder.concat(POST).toString();
		ResponseEntity<List> response= restTemplate.exchange(url,HttpMethod.GET,httpEntity,List.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> getPostById(int id) {
		HttpEntity<Void>httpEntity=new HttpEntity<>(getHttpHeaders());
		String url=builder.concat(POSTBYID).concat(String.valueOf(id)).toString();
		ResponseEntity<Map> response=restTemplate.exchange(url, HttpMethod.GET,httpEntity,Map.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> addPosts(Map<String, Object> payloads) {
		HttpEntity<Map>httpEntity=new HttpEntity<Map>(payloads,getHttpHeaders());
		String url=builder.concat(POST).toString();
		ResponseEntity<Map> response=restTemplate.exchange(url, HttpMethod.POST,httpEntity,Map.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> updatePosts(Map<String, Object> payloads,int id) {
		HttpEntity<Map>httpEntity=new HttpEntity<Map>(payloads,getHttpHeaders());
		String url=builder.concat(POSTBYID).concat(String.valueOf(id)).toString();
		ResponseEntity<Map> response=restTemplate.exchange(url, HttpMethod.PUT,httpEntity,Map.class);
		return response.getBody();
	}

	@Override
	public Map<String, Object> deletePosts(int id) {
		HttpEntity<Map>httpEntity=new HttpEntity<Map>(getHttpHeaders());
		String url=builder.concat(POSTBYID).concat(String.valueOf(id)).toString();
		ResponseEntity<Map> response=restTemplate.exchange(url, HttpMethod.DELETE,httpEntity,Map.class);
		return response.getBody();
	}
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
