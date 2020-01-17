package Controller;

import Service.BoardService;
import dto.BoardDTO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list")
    public void list(Model model){

        log.info("list");
        model.addAttribute("list",service.getList());
    }
    @GetMapping("/get")
    public void get(@RequestParam("bno") Long bno, Model model){
        log.info("/get");
        model.addAttribute("board",service.get(bno));
    }
    @PostMapping("/modify")
    public String modify(BoardDTO board, RedirectAttributes rttr){
        log.info("modify :" + board);

        if(service.modify(board)){
            rttr.addFlashAttribute("result","success");
        }
        return "redirect:/board/list";
    }
    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr){
        log.info("remove .............." + bno);
        if(service.remove(bno)){
            rttr.addFlashAttribute("result","success");
        }
        return "redirect:/board/list";
    }
}
