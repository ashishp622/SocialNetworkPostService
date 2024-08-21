package com.social.socialnetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.socialnetwork.entity.SocialNetworkPost;
import com.social.socialnetwork.services.SocialNetworkService;

@RestController
@RequestMapping("/socialnetworkposts")
public class SocialNetworkPostController {

	@Autowired
	private SocialNetworkService service;

	@GetMapping("/gettopten")
	public List<SocialNetworkPost> getTopTenPostsByCategory(@RequestParam String postCategory) {
		List<SocialNetworkPost> topTenPostsByCategory = service.getTopTenPostsByCategory(postCategory);
		return topTenPostsByCategory;
	}

	@GetMapping("/search")
	public List<SocialNetworkPost> searchPostsByAuthor(@RequestParam String author) {
		return service.searchPostsByAuthor(author);
	}
}
