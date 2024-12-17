package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.UserDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.User;
import tech.reliab.course.ChuvilkoIR.bank.model.request.UserRequest;

public interface UserService {
    UserDTO createUser(UserRequest userRequest);
    User getUserById(long id);
    UserDTO getUserDTOById(long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(long id, String name);
    void deleteUser(long id);
}