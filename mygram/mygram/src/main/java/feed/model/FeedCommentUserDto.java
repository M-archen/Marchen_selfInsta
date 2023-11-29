package feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedCommentUserDto {
    private int ifeed;
    private int iuser;
    private String comment;
    private String createdAt;
    private String updatedAt;
}

