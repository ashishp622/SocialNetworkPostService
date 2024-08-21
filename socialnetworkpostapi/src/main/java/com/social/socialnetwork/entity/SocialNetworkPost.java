package com.social.socialnetwork.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "socialnetworkpost")
public class SocialNetworkPost {

	@Id
	@Column(name = "identifier")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "postdate")
	private Date postDate;

	@Column(name = "postcategory")
	private String postCategory;

	@Column(name = "author")
	private String author;

	@Column(name = "content")
	private String content;

	@Column(name = "viewcount")
	private Long viewCount;

	public SocialNetworkPost() {
	}

	public SocialNetworkPost(Long id, Date postDate, String postCategory, String author, String content,
			Long viewCount) {
		super();
		this.id = id;
		this.postDate = postDate;
		this.postCategory = postCategory;
		this.author = author;
		this.content = content;
		this.viewCount = viewCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "SocialNetworkPost [id=" + id + ", postDate=" + postDate + ", postCategory=" + postCategory + ", author="
				+ author + ", content=" + content + ", viewCount=" + viewCount + "]";
	}

}
