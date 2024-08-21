package com.social.socialnetwork.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.social.socialnetwork.entity.SocialNetworkPost;

@Repository
public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost, Long> {

	@Query("Select p From SocialNetworkPost p Where p.postCategory = :postCategory ORDER BY p.viewCount Desc")
	List<SocialNetworkPost> findTopTenByPostCategoryOrderByViewCountDesc(String postCategory, Pageable pageable);

	List<SocialNetworkPost> findByAuthor(String author);
}
