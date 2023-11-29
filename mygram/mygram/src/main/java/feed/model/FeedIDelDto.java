package feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedIDelDto {
    private int ifeed;//글 번호의 데이터베이스 pk
    private int iuser;//글 작성자의 데이터베이스 pk
}
