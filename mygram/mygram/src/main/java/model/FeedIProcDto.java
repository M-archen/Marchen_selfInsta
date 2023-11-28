package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FeedIProcDto {
    private int iuser;
    private int ifeed;
    private String location;
    private String contents;
    private List<String> pics;
}
