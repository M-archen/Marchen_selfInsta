package feed;

import feed.model.FeedIDelDto;
import feed.model.FeedIProcDto;
import feed.model.FeedSelAsFeedDelDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int feedIns(FeedIProcDto dto);
    int feedDel(FeedIDelDto dto);
    FeedSelAsFeedDelDto selFeedAsFeedDel(FeedIDelDto dto);
}