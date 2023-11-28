package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedIDto {
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;
}
