package feed;

import model.FeedIProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedPicsMapper {
    int feedPics(FeedIProcDto dto);
}
