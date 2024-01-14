package com.climb.timecounting.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/history")
@RestController
public class HistoryController {
 /*
    private HistoryService historyService;
    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public String goals(ModelMap map) {
        map.addAttribute("history", List.of());
        return "history";
    }
*/
    /*
    // 임시
    @GetMapping({"/list"})
    public ResponseEntity<List<history>> getHistoryList() {
        System.out.println("리스트조회");
        var historyList = historyService.getHistoryList();
        return ResponseEntity.ok(historyList);
    }

     */
}
