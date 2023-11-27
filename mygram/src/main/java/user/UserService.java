package user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import user.model.ResVo;
import user.model.UserSignUpDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    // 회원가입 //
    public ResVo UserSignUp(UserSignUpDto dto) {
        String saltPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        int result = mapper.userSignUp(dto);
        dto.setUpw(saltPw);

        if (result == 1) {
            return new ResVo(result);// 성공
        } else {
            return new ResVo(dto.getIuser());//아이디중복
        }
    }
    // 로그인 //
}