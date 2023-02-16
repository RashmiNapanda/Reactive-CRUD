package com.example.webfluxdemo.model;

import java.util.Date;

//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
//@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document(collection = "subscription")
public class Subscription {

	@Id
	private Integer id;
	
	//@NotBlank
	//@Size(max = 140)
	@NonNull
	private String restHook;

	private Boolean status;
	
	private Date createdAt = new Date();

/*
	public Subscription(String restHook) {
		this.id = id;
		this.restHook = restHook;
	}*/


	/*public Subscription() {

	}

	public Subscription(String restHook) {
		this.id = id;
		this.restHook = restHook;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRestHook() {
		return restHook;
	}

	public void setRestHook(String restHook) {
		this.restHook = restHook;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}*/
}
