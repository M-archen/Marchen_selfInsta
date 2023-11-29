package feed;

import feed.model.FeedCommentDelDto;
import feed.model.FeedCommentUserDto;
import feed.model.FeedIDelDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedCommentMapper {
    int feedCommentI(FeedCommentUserDto dto);
    int feedCommentDel(FeedCommentDelDto dto);
    int feedCommentDelAsFeedDel(FeedIDelDto dto);
}
