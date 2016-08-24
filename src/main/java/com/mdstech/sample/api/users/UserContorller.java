package com.mdstech.sample.api.users;

import com.mdstech.sample.domain.User;
import com.mdstech.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Srini on 8/23/16.
 */
@RestController
@RequestMapping("/api/users")
public class UserContorller {
    private static final Logger log = LoggerFactory
            .getLogger(UserContorller.class);

    @Inject
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> getAllUsers() {
        log.debug("Received request to get all users");
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        log.debug("Received request to get all users");
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> saveUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.toString());
        }
        User savedUser = userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/users/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri()
        );
        return new ResponseEntity<>("Success", headers, HttpStatus.CREATED);
    }
}
