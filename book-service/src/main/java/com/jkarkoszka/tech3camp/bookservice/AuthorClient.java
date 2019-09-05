package com.jkarkoszka.tech3camp.bookservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "author-service", fallback = AuthorClient.AuthorClientFallback.class)
public interface AuthorClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{authorId}")
    Author getAuthor(@PathVariable("authorId") Integer authorId);

    @Component
    class AuthorClientFallback implements AuthorClient {
        @Override
        public Author getAuthor(Integer authorId) {
            return new Author("Unknown", "Author");
        }
    }
}

