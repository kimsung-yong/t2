package Controller;

import Service.BoardService;
import domain.BoardDTO;
import domain.Criteria;
import domain.PageDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
    @Autowired
    private BoardService service;

//    @GetMapping("/list")
//    public void list(Model model){
//
//        log.info("list");
//        model.addAttribute("list",service.getList();
//    }
    @GetMapping("/list")
    public void list(Criteria cri,Model model){

        log.info("list");
        model.addAttribute("list",service.getList(cri));
//        model.addAttribute("pageMaker",new PageDTO(cri,132));
        model.addAttribute("pageMaker",new PageDTO(cri,service.getCount(cri)));
    }

    @GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno") Long bno, Model model, @ModelAttribute("cri") Criteria cri){
        log.info("/get");
        model.addAttribute("board",service.get(bno));

    }
    @PostMapping("/modify")
    public String modify(BoardDTO board, RedirectAttributes rttr,@ModelAttribute("cri") Criteria cri){
        log.info("modify :" + board);

        if(service.modify(board)){
            rttr.addFlashAttribute("result","success");
        }
        rttr.addAttribute("pageNum",cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        rttr.addAttribute("type",cri.getType());
        rttr.addAttribute("keyword",cri.getKeyword());
        return "redirect:/board/list";
    }
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr,@ModelAttribute("cri") Criteria cri){
        log.info("remove .............." + bno);
        if(service.remove(bno)){
            rttr.addFlashAttribute("result","success");
        }
        rttr.addAttribute("pageNum",cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        rttr.addAttribute("type",cri.getType());
        rttr.addAttribute("keyword",cri.getKeyword());
        return "redirect:/board/list";
    }
    @PostMapping("/register")
    public String insert(BoardDTO board, RedirectAttributes rttr,@ModelAttribute("cri") Criteria cri){
        log.info("insert...." + board);
        service.register(board);
        rttr.addFlashAttribute("result",board.getBno());
        rttr.addAttribute("pageNum",cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        rttr.addAttribute("type",cri.getType());
        rttr.addAttribute("keyword",cri.getKeyword());
        return "redirect:/board/list";
    }
}
