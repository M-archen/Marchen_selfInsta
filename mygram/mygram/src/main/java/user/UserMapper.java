package user;

import org.apache.ibatis.annotations.Mapper;
import user.model.*;

@Mapper
public interface UserMapper {
    int userSignUp(UserSignUpDto dto); //영향받은 행의 갯수를 반환하므로  int 타입으로 만듦.
    UserSignInProcVo selectUid(UserSignInDto dto);//UserSignInProcVo 타입으로 반환.
    UserInfoVo UserInfo(int targetIuser); //유저 정보 확인.
    int patchUserPic(UserPicPatchDto dto);
}
