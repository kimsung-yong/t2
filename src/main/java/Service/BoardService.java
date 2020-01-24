package Service;

import domain.BoardDTO;
import domain.Criteria;

import java.util.List;

public interface BoardService {

    public void register(BoardDTO board);

    public BoardDTO get(Long bno);

    public boolean modify(BoardDTO board);

    public boolean remove(Long bno);

//    public List<BoardDTO> getList();
    public List<BoardDTO> getList(Criteria cri);

    public int getCount();


}


