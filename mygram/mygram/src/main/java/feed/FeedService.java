package feed;

import feed.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import user.ResVo;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    public final FeedMapper feedMapper;
    public final FeedPicsMapper feedPicsMapper;
    public final FeedCommentMapper feedCommentMapper;

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
        if(resultPic!=dto.getPics().size()){ //dto 의 사진의 크기와 procDto의 크기가 같지않을경우
            return new ResVo(3); // 뭔가 오류남.
        }
        return new ResVo(procDto.getIfeed());//정상적으로 됨. ifeed를 반환.
    }
    // 답글 쓰기 //
    public ResVo FeedCommentPost(FeedCommentUserDto dto){
        int result= feedCommentMapper.feedCommentI(dto);
        if(result==0){
            return new ResVo(0);//뭔가 에러
        }
        return new ResVo(result);
    }
    // 답글 삭제 //
    public ResVo FeedCommentDel(FeedCommentDelDto dto){
        int result=feedCommentMapper.feedCommentDel(dto);
        if(result==0){
            return new ResVo(0);//뭔가 에러, 답글 안지워짐.
        }
        return new ResVo(result);
    }
    // 내가 쓴 글 삭제 //

    //만약 쓴 글이 아니다 ResVo 0 리턴, 쓴 글이다 해당하는
    //Feed 에 달린, 댓글과 사진들을 먼저 삭제한다,
    //feed 삭제처리, ResVo1 리턴,
    // t_feed의 iuser 이 같으면 t_feed_comment 의 ifeed와
    // t_feed 의 ifeed 가 같은것 삭제.
    // t_feed_pics의 ifeed 가 같은것 삭제.
    // 그다음 t_feed 의 ifeed 와 iuser이 같은것 삭제.
    public ResVo FeedDel(FeedIDelDto dto){
        FeedSelAsFeedDelDto feedIDelDto=feedMapper.selFeedAsFeedDel(dto);
        if(feedIDelDto==null){
            return new ResVo(0);//내가 쓴 글이 아님.
        }
        feedCommentMapper.feedCommentDelAsFeedDel(dto);
        feedPicsMapper.feedPicsDelAsFeedDel(dto);
        feedMapper.feedDel(dto);
        return new ResVo(1);
    }




}
