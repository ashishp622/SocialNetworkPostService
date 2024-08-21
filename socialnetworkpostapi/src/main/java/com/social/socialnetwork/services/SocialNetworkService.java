package com.social.socialnetwork.services;

import java.util.List;

import com.social.socialnetwork.entity.SocialNetworkPost;

public interface SocialNetworkService {
	public List<SocialNetworkPost> getTopTenPostsByCategory(String postCategory);

	public List<SocialNetworkPost> searchPostsByAuthor(String author);

}
