package Service;

import Mapper.BoardMapper;
import domain.BoardDTO;
import domain.Criteria;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
@AllArgsConstructor
public class BoardServicelmpl implements BoardService{


    private BoardMapper mapper;

    @Override
    public void register(BoardDTO board) {
        log.info("register....." + board);
        mapper.insertSelectkey(board);
    }

    @Override
    public BoardDTO get(Long bno) {

        log.info("get......" +bno);

        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardDTO board) {
        log.info("modify........" +board);
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("delete........." + bno);
        return mapper.delete(bno) ==1;
    }

    @Override
    public List<BoardDTO> getList(Criteria cri) {
        log.info("getList.................................");
        return mapper.getListWithPaging(cri);
    }

    @Override
    public int getCount(Criteria cri) {
        return mapper.getCount(cri);
    }


}
