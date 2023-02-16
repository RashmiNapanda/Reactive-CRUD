package com.example.webfluxdemo.controller;


import com.example.webfluxdemo.model.Subscription;
import com.example.webfluxdemo.repository.SubscriptionRepository;
import com.example.webfluxdemo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping(value = "/get", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public String get() {
        return "test";
    }

    /**
     * API to get all Subscription list
     */
    @GetMapping("/subscription")
    public Flux<Subscription> getAllSubscription() {
        return subscriptionRepository.findAll();
    }

	/**
	 * API to get the Subscription by ID
	 */

    @GetMapping("/subscription/{id}")
    public Mono<ResponseEntity<Subscription>> getSubscriptionById(@PathVariable(value = "id") String subscriptionId) {
        return subscriptionRepository.findById(Integer.valueOf(subscriptionId))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

	/**
	 * API to List all active Subscription
	 */

    @GetMapping("/listActiveSubscription")
    public Mono<ResponseEntity<Subscription>> listActiveSubscription() {
        return subscriptionRepository.findByStatus(true)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

	/**
	 * API to Save new Subscription
	 */
	@PostMapping("/subscription")
	public Mono<Subscription> createSubscription(@RequestBody Subscription subscription) {
		return subscriptionRepository.save(subscription);
	}

	/**
	 * API to update existing Subscription
	 */
	@PutMapping("/subscription/{id}")
	public Mono<ResponseEntity<Subscription>> updateSubscription(@PathVariable(value = "id") String subscriptionId,
												   @RequestBody Subscription subscription) {
		return subscriptionRepository.findById(Integer.valueOf(subscriptionId))
				.flatMap(existingSubscription -> {
					existingSubscription.setRestHook(subscription.getRestHook());
					return subscriptionRepository.save(existingSubscription);
				})
				.map(updatedSubscription -> new ResponseEntity<Subscription>(updatedSubscription, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<Subscription>(HttpStatus.NOT_FOUND));
	}

	/**
	 * API to delete the Subscription by ID
	 */

	@DeleteMapping("/subscription/{id}")
	public Mono<ResponseEntity<Void>> deleteSubscription(@PathVariable(value = "id") String subscriptionId) {
		return subscriptionRepository.findById(Integer.valueOf(subscriptionId))
				.flatMap(existingSubscription ->
						subscriptionRepository.delete(existingSubscription)
								.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
				)
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * API to get the Subscription Stream
	 */

	@GetMapping(value = "/subscription/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Subscription> streamAllSubscription() {
		return subscriptionRepository.findAll();
	}
}
