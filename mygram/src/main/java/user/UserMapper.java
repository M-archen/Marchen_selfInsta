package user;

import org.apache.ibatis.annotations.Mapper;
import user.model.UserSignUpDto;

@Mapper
public interface UserMapper {
    int userSignUp(UserSignUpDto dto); //영향받은 행의 갯수를 반환하므로  int 타입으로 만듦.
}
