package com.third.api.Service;

import java.util.List;
import java.util.Map;

public interface PostService {
	List<Map<String,Object>>getAllPosts();
	Map<String,Object>getPostById(int id);
	Map<String,Object>addPosts(Map<String,Object>payloads);
	Map<String,Object>updatePosts(Map<String,Object>payloads,int id);
	Map<String,Object>deletePosts(int id);
}
