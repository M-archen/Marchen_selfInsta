package feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedCommentDelDto {
    private int iuser;  //덧글 작성한사람
    private int ifeed;  //덧글을 작성한 feed 의 pk
}
