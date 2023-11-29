package user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpDto {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
}
