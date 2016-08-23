package com.mdstech.sample.service;

import com.mdstech.sample.config.AppConfig;
import com.mdstech.sample.config.DataSourceConfig;
import com.mdstech.sample.config.JpaConfig;
import com.mdstech.sample.config.SpringDataJpaConfig;
import com.mdstech.sample.domain.User;
import com.mdstech.sample.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Srini on 8/23/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DataSourceConfig.class, SpringDataJpaConfig.class, JpaConfig.class})
public class UserServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceTest.class);

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserService userService;

    @Test
    public void testFindAll() {
        assertEquals("Expected zero user records", 0, userService.findAll().size());
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setFirstName("test");
        user.setLastName("sample");
        User savedUser = userService.saveUser(user);
        assertNotNull("ID should be generated", savedUser.getId());
        userService.deleteUser(savedUser.getId());
    }
}
