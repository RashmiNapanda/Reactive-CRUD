package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Subscription;
import com.example.webfluxdemo.repository.SubscriptionRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@Component
@Service
public class SubscriptionService {


    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Mono<Subscription> findByStatus(Boolean status) {
        return (Mono<Subscription>) subscriptionRepository.findByStatus(status);
    }
}
