//package com.example.task.repository;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import com.example.task.entity.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserRepository repo;
//
//    // test methods go below
//
//    @Test
//    public void testCreateUser() {
//        User user = new User();
//        user.setUsername("zhamalbekkyzyn@gmail.com");
//        user.setPassword("Test0803");
//        user.setFirstName("Nurzat");
//
//        User savedUser = repo.save(user);
//
//        User existUser = entityManager.find(User.class, savedUser.getId());
//
//        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
//
//    }
//}
