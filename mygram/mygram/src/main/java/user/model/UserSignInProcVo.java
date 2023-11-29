package user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInProcVo{// Vo에 담으면 비교할 때에 실수로 기존 정보가 없어질 위험이 있기에 애초부터 다른 객체에 저장.
    private int iuser;
    private String nm;
    private String pic;
    private String upw;
}
