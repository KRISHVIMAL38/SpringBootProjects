package com.third.api.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.third.api.Service.PostServiceImpl;

@RestController
@RequestMapping("api")
public class PostController {
	
	@Autowired
	private PostServiceImpl postService;
	
	@GetMapping("/posts")
	public List<Map<String,Object>>getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/posts/{id}")
	public Map<String,Object>getPostsById(@PathVariable int id){
		return postService.getPostById(id);
	}
	
	@PostMapping("/posts")
	public Map<String,Object>addPosts(@RequestBody Map<String,Object>payload){
		return postService.addPosts(payload);
	}
	
	@PutMapping("/posts/{id}")
	public Map<String,Object>updatePost(@RequestBody Map<String,Object>payload,@PathVariable int id){
		return postService.updatePosts(payload, id);
	}
	
	@DeleteMapping("/posts/{id}")
	public Map<String,Object>deletePostById(@PathVariable int id){
		return postService.deletePosts(id);
	}
}
