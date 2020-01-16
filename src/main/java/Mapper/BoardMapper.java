package Mapper;


import dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
//    @Select("select * from tbl_board where bno > 0")
    public List<BoardDTO> getList();

    public void insert(BoardDTO boardDTO);

    public void insertSelectkey(BoardDTO dto);

    public BoardDTO read(Long bno);

    public int delete(Long bno);

    public int update(BoardDTO dto);
}
