package de.rieckpil.learning.k8s.k8ssample;

import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private int random;

    @PostConstruct
    public void init() {
        this.random = ThreadLocalRandom.current().nextInt(0, 100);
    }

    @GetMapping
    public int getRandom() {
        return this.random;
    }

}