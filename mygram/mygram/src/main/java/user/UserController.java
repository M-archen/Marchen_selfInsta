package user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import user.model.*;

@Slf4j// system.out 말고 log.info()으로 로그를 직접 찍을 수 있다.
@RestController//@RequestBody 로 인해 JSON 형태로 데이터를 반환할 수 있다.
@RequiredArgsConstructor//필수 생성자를 만들어준다.
@RequestMapping("/api/user")//들어온 요청을 컨트롤러의 특정 메소드와 매핑할 수 있다.
public class UserController {
    private final UserService userService;//Service 단자에 값을 전해줄 수 있다.

    // 회원가입 //
    @PostMapping("/signin")//RequestMapping 의 하위그룹, Get 으로 들어온걸 매핑해준다.
    public ResVo SignUp(@RequestBody UserSignUpDto dto){//객체로 데이터를 받을 수 있게 해준다.
        return userService.UserSignUp(dto);
    }

    // 로그인 //
    @GetMapping("/signin")
    public UserSignInVo signIn(@RequestBody UserSignInDto dto){
        log.info("UserSignInDto Result : {}",dto);
        return userService.UserSignIn(dto);
    }
    // 유저 정보 확인 //
    @GetMapping
    public UserInfoVo getUserInfo(@RequestParam(value="target_iuser")int targetIuser){
        log.info("targetIuser : {}",targetIuser);
        return userService.UserInfo(targetIuser);
    }
    // 유저 사진 바꾸기 or 추가 //
    @GetMapping("/pic")
    public ResVo patchUserPic(@RequestBody UserPicPatchDto dto){
        log.info("UserPicPatch : {}",dto);
        return userService.patchUserPic(dto);
    }
}
