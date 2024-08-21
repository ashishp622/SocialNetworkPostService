package com.social.socialnetwork;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.social.socialnetwork.entity.SocialNetworkPost;
import com.social.socialnetwork.repositories.SocialNetworkPostRepository;
import com.social.socialnetwork.services.SocialNetworkServiceImpl;

public class SocialNetworkServiceImplTest {

	@Mock
	private SocialNetworkPostRepository repository;

	@InjectMocks
	private SocialNetworkServiceImpl service;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetTop10PostsByCategory() {
		SocialNetworkPost post1 = new SocialNetworkPost(1L, new Date(), "Instagram,", "Ashish", "good to see you",
				100L);
		SocialNetworkPost post2 = new SocialNetworkPost(2L, new Date(), "Facebook", "Jayesh", "lovely app", 90L);
		List<SocialNetworkPost> mockPosts = Arrays.asList(post1, post2);

		when(repository.findTopTenByPostCategoryOrderByViewCountDesc(anyString(), any(Pageable.class)))
				.thenReturn(mockPosts);

		Pageable topTen = PageRequest.of(0, 10);
		List<SocialNetworkPost> result = service.getTopTenPostsByCategory("Instagram");

		assertEquals(2, result.size());
		assertEquals("Ashish", result.get(0).getAuthor());

		verify(repository).findTopTenByPostCategoryOrderByViewCountDesc("Instagram", topTen);
	}

	@Test
	public void testSearchPostsByAuthor() {
		SocialNetworkPost post = new SocialNetworkPost(1L, new Date(), "Instagram", "Ashish", "good to see you", 100L);
		when(repository.findByAuthor(anyString())).thenReturn(Arrays.asList(post));

		List<SocialNetworkPost> result = service.searchPostsByAuthor("Ashish");

		assertEquals(1, result.size());
		assertEquals("Ashish", result.get(0).getAuthor());
	}
}
