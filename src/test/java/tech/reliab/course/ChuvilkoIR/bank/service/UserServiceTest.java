package tech.reliab.course.ChuvilkoIR.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.User;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.UserServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.UserDTO;
import tech.reliab.course.ChuvilkoIR.bank.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    static User createUser() {
        var user = new User();
        user.setId(0L);
        user.setFullName("test test");
        user.setCreditRating(5);
        user.setMonthlyIncome(5.0);
        user.setBanks(List.of());
        user.setJob("test job");
        user.setBirthDate(LocalDate.now());
        user.setCreditAccounts(List.of());
        user.setPaymentAccounts(List.of());
        return user;
    }

    static List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(createUser());
        return users;
    }

    @Test
    @DisplayName("Test success get users")
    void getUsersSuccess() {
        when(userRepository.findAll()).thenReturn(createUsers());

        List<UserDTO> users = userService.getAllUsers();

        assertThat(users).hasSize(1);
        assertThat(users.get(0).getFullName()).isEqualTo("test test");
    }
}
