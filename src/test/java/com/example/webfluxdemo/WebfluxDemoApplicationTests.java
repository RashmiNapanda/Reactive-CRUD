/*
package com.example.webfluxdemo;

import java.util.Collections;

import com.example.webfluxdemo.model.Subscription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.example.webfluxdemo.repository.SubscriptionRepository;
import org.assertj.core.api.Assertions;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebfluxDemoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Test
	public void testGetAllSubscription() {
		webTestClient.get().uri("/subscription")
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
			.expectBodyList(Subscription.class);
	}
	
	@Test
	public void testGetSingleSubscription() {
		Subscription subscription = subscriptionRepository.save(new Subscription("Rest Hook Test")).block();
		
		webTestClient.get()
			.uri("/subscription/{id}", Collections.singletonMap("id", subscription.getId()))
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.consumeWith(response -> Assertions.assertThat(response.getResponseBody()).isNotNull());
	}

	@Test
	public void testCreateSubscription() {
		Subscription subscription = new Subscription("Rest Hook Test");

		webTestClient.post().uri("/subscription")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(subscription), Subscription.class)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody()
				.jsonPath("$.id").isNotEmpty()
				.jsonPath("$.restHook").isEqualTo("Rest Hook Test");
	}

	@Test
	public void testUpdateSubscription() {
		Subscription subscription = subscriptionRepository.save(new Subscription("Rest Hook Test")).block();
		Subscription newSubscriptionData = new Subscription("Updated Subscription");

		webTestClient.put()
				.uri("/subscription/{id}", Collections.singletonMap("id", subscription.getId()))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(newSubscriptionData), Subscription.class)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
				.expectBody()
				.jsonPath("$.restHook").isEqualTo("Updated Subscription");
	}

	@Test
	public void testDeleteSubscription() {
		Subscription subscription = subscriptionRepository.save(new Subscription("Jack Wallen 2")).block();

		webTestClient.delete()
				.uri("/subscription/{id}", Collections.singletonMap("id", subscription.getId()))
				.exchange()
				.expectStatus().isOk();
	}
}
*/
