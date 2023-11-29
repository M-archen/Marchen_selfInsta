package user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInVo {//로그인 데이터 넘길려고 만든거
    private int iuser;
    private String nm;
    private String pic;
    private int result;
}
