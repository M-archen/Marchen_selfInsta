package feed;

import feed.model.FeedIDelDto;
import feed.model.FeedIProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedPicsMapper {
    int feedPics(FeedIProcDto dto);
    int feedPicsDelAsFeedDel(FeedIDelDto dto);
}
