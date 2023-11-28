package user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import user.model.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    // 회원가입 // <성공,아이디중복 구현.>
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
    // 로그인 // <로그인 성공 ,아이디 없음, 비밀번호 틀림 구현.>
    public UserSignInVo UserSignIn(UserSignInDto dto){
        UserSignInProcVo procVo= mapper.selectUid(dto);
        UserSignInVo signInVo=new UserSignInVo();
        if(procVo==null){
            signInVo.setResult(0); // 결과값 0 : 아이디없음. SignInVo 에 아무것도 안담아서 돌려보냄.
            return signInVo;
        }else if(!BCrypt.checkpw(dto.getUpw(), procVo.getUpw())){ // dto 의 upw값과 쿼리문을 실행해서 나온 upw 값을 비교
            signInVo.setResult(2); // 결과값 2 : 비밀번호 틀림, 마찬가지로 SignInVo 에 아무것도 안담아서 돌려보냄.
            return signInVo;
        }else{//로그인 성공
            signInVo.setResult(1);
            signInVo.setNm(procVo.getNm());
            signInVo.setPic(procVo.getPic());
            signInVo.setIuser(procVo.getIuser());
            return signInVo;
        }
    }
    // 회원정보 확인//
    public UserInfoVo UserInfo(int targetiuser){
        UserInfoVo vo=mapper.UserInfo(targetiuser);
        return vo;
    }
    // 사진 추가 //
    public ResVo patchUserPic(UserPicPatchDto dto){
        int result=mapper.patchUserPic(dto);
        return new ResVo(result);
    }

}