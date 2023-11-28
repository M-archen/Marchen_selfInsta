package feed;

import model.FeedIDto;
import model.FeedIProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int feedIns(FeedIProcDto dto);
}