package com.social.socialnetwork.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.social.socialnetwork.entity.SocialNetworkPost;
import com.social.socialnetwork.repositories.SocialNetworkPostRepository;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService {

	@Autowired
	private SocialNetworkPostRepository repository;

	@Override
	public List<SocialNetworkPost> getTopTenPostsByCategory(String postCategory) {
		Pageable topTen = PageRequest.of(0, 10);
		List<SocialNetworkPost> posts = repository.findTopTenByPostCategoryOrderByViewCountDesc(postCategory, topTen);
		return posts;
	}

	@Override
	public List<SocialNetworkPost> searchPostsByAuthor(String author) {
		return repository.findByAuthor(author);
	}

}
