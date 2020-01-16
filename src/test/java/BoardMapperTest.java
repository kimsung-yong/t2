import Mapper.BoardMapper;
import dto.BoardDTO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
