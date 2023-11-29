package feed;

import feed.model.FeedCommentDelDto;
import feed.model.FeedCommentUserDto;
import feed.model.FeedIDelDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import feed.model.FeedIDto;
import org.springframework.web.bind.annotation.*;
import user.ResVo;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/feed")
public class FeedController { // Feed에 들어가야 될것 : 글 쓰기, 댓글달기
                                //답글달기, 좋아요, 글 삭제, 댓글삭제, 프로필 보기,
    public final FeedService service;
    // 글 쓰기(사진)//
    @PostMapping
    public ResVo FeedPost(@RequestBody FeedIDto dto){
        log.info("FeedIDto : {}",dto);
        return service.FeedPost(dto);
    }
    // 답글 쓰기 //
    @PostMapping
    public ResVo FeedCommentPost(@RequestBody FeedCommentUserDto dto){
        log.info("FeedCommentUserDto : {}",dto);
        return service.FeedCommentPost(dto);
    }
    //  답글 삭제 //
    @DeleteMapping
    public ResVo FeedCommentDel(@RequestBody FeedCommentDelDto dto){
        log.info("FeedCommentDelDto : {}",dto);
        return service.FeedCommentDel(dto);
    }
    // 글 삭제 //
    @DeleteMapping
    public ResVo FeedDel(@RequestBody FeedIDelDto dto){
        log.info("FeedIDelDto : {}",dto);
        return service.FeedDel(dto);
    }
    //좋아요!//

}
