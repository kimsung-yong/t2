package dto;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {

    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private Date updateDate;
}
