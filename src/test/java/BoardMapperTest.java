import Mapper.BoardMapper;
import domain.BoardDTO;
import domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/applicationContext.xml")
@Log4j
public class BoardMapperTest {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;
    @Test
    public void testGetList(){
        mapper.getList().forEach(boardDTO -> log.info(boardDTO));

    }
    @Test
    public void testCount(){
        Criteria cri = new Criteria();
        mapper.getCount(cri);
    }

    @Test
    public void testInsert(){

        BoardDTO board = new BoardDTO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        mapper.insert(board);
        log.info(board);
    }
    @Test
    public void testInsertSelectKey(){

        BoardDTO board = new BoardDTO();
        board.setTitle("새로 작성하는글 select key");
        board.setContent("새로 작성하는 내용 select key");
        board.setWriter("newbie");

        mapper.insertSelectkey(board);
        log.info(board);
    }
    @Test
    public void testRead(){
        //존재하는 게시물 번호로 테스트
        BoardDTO board = mapper.read(5L);

        log.info(board);
    }
    @Test
    public void testDelete(){
        log.info("Delete count:" + mapper.delete(3L)) ;
    }
    @Test
    public void testUpdate(){
        BoardDTO dto = new BoardDTO();
        dto.setBno(5L);
        dto.setTitle("수정된 제목");
        dto.setContent("수정된 내용");
        dto.setWriter("user11");

        int count = mapper.update(dto);
        log.info(count);
    }
    @Test
    public void testPaging(){
        Criteria cri = new Criteria(1,10);

        List<BoardDTO> list = mapper.getListWithPaging(cri);

        list.forEach(boardDTO -> log.info(boardDTO));
    }
    @Test
    public void testSearch(){

        Criteria cri = new Criteria();
        cri.setKeyword("처음");
        cri.setType("TC");

        List<BoardDTO> list = mapper.getListWithPaging(cri);

        list.forEach(boardDTO -> log.info(boardDTO));
    }

}
