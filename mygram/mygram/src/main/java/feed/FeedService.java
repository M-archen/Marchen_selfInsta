package feed;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.FeedIDto;
import model.FeedIProcDto;
import org.springframework.stereotype.Service;
import user.ResVo;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    public final FeedMapper feedMapper;
    public final FeedPicsMapper feedPicsMapper;
    // 글 작성(사진) //
    public ResVo FeedPost(FeedIDto dto){
        if (dto.getPics().size() == 0) {
            return new ResVo(2); //사진이 하나도 없음
        }
        FeedIProcDto procDto=FeedIProcDto.builder()
                .iuser(dto.getIuser())
                .pics(dto.getPics())
                .location(dto.getLocation())
                .contents(dto.getContents())
                .build();
        int result= feedMapper.feedIns(procDto);
        if(result==0||procDto.getIfeed()==0){//영향받은 행이 없거나 procDto의 ifeed가 없을때
            return new ResVo(result);
        }
        int resultPic=feedPicsMapper.feedPics(procDto);
        if(resultPic==)


        return new ResVo();
    }
}
