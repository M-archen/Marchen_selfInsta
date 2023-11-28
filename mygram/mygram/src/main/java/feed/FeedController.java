package feed;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.FeedIDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
