import Service.BoardService;
import dto.BoardDTO;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/applicationContext.xml")
@Log4j
public class BoardServiceTests {
    @Autowired
    private BoardService service;

    @Test
    public void testExist(){
        log.info(service);
        assertNotNull(service);
    }
    @Test
    public void testRegister(){
        BoardDTO board = new BoardDTO();
        board.setTitle("새로 작성하는글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("user123");

        service.register(board);

        log.info("생성된 게싶물 번호" + board.getBno());

    }
    @Test
    public void tsetGetList(){
        service.getList().forEach(boardDTO -> log.info(boardDTO));
    }
    @Test
    public void testGet(){

        log.info(service.get(1L));
    }
    @Test
    public void testDelete(){

        // 게시물 번호의 존재 여부를 확인하고 테스트 할것
        log.info("remove result =" + service.remove(2L));
    }
    @Test
    public void testUpdate(){
        BoardDTO board = service.get(1L);

        if(board == null){
            return ;
        }
        board.setTitle("제목 수정합니다안해11");
        log.info("modify result"+service.modify(board));
    }
}
