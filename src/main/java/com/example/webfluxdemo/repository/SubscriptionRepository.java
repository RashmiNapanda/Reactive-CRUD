package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.model.Subscription;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
@Component
public interface SubscriptionRepository extends ReactiveMongoRepository<Subscription, Integer> {
    Mono<Subscription> findByStatus(Boolean status);

}
