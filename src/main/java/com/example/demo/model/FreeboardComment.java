package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="freeboardComment")
public class FreeboardComment {
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Long commentId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="writeDate")
	private Date writeDate;
	
	@Column(name="writer")
	private String writer;
	
	private Long commentOriginId;
	
	private int commentLevel;
	
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Long getCommentOriginId() {
		return commentOriginId;
	}

	public void setCommentOriginId(Long commentOriginId) {
		this.commentOriginId = commentOriginId;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	public Long getFreeId() {
		return freeId;
	}

	public void setFreeId(Long freeId) {
		this.freeId = freeId;
	}

	@ManyToOne(targetEntity = Freeboard.class)
	@JoinColumn(foreignKey = @ForeignKey(name="freeId"))
	private Long freeId; 
}
