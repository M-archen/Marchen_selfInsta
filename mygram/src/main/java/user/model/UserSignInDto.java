package user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInDto {//로그인 데이터 받을려고 만든거.
    private String uid;
    private String upw;
}
