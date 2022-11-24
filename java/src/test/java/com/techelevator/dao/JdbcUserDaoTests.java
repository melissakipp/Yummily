package com.techelevator.dao;

import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

// NOTE:
//  - Focus only a single requirement in each test.
//  - Naming convention
//  - methodName_condition_expectedBehavior

public class JdbcUserDaoTests extends FinalCapstoneDaoTests {

    private JdbcUserDao sut;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

//    @BeforeEach
//    public void cleanup() {
//        userRepository.deleteAll();
//        testRestTemplate.getRestTemplate().getInterceptors().clear();
//    }

    @Test
    public void createNewUser() {
        boolean userCreated = sut.create(
                "TEST_USER",
                "test_user@testing.com",
                "test_password",
                "user");
        Assert.assertTrue(userCreated);
        User user = sut.findByUsername("TEST_USER");
        Assert.assertEquals("TEST_USER", user.getUsername());
    }

    @Test
    public void postUser_whenUserIsValid_passwordIsHashedInDatabase() {
        boolean userCreated = sut.create(
                "TEST_USER",
                "test_user@testing.com",
                "test_password",
                "user");
        Assert.assertTrue(userCreated);
        List<User> users = sut.findAll();
        User inDB = users.get(2);
        // working on test still...
//        Assert.assertThat(inDB.getPassword()).isNotEqualTo(userCreated.getPassword());
    }

//    public <T> ResponseEntity<T> postSignup(Object request, Class<T> response){
//        return testRestTemplate.postForEntity(API_1_0_USERS, request, response);
//    }


}
