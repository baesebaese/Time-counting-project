package com.climb.timecounting.controller;
import com.climb.timecounting.domain.History;
import com.climb.timecounting.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/history")
@RequiredArgsConstructor
@RestController
public class HistoryController {

    private final HistoryService historyService;

    // 임시
    @GetMapping({"/list"})
    public ResponseEntity<List<History>> getHistoryList() {
        System.out.println("리스트조회");
        var historyList = historyService.getHistoryList();
        return ResponseEntity.ok(historyList);
    }

    @PostMapping("/one")
    public ResponseEntity<List<History>> historiesByGoal(@RequestBody Map request){
        var historyList = historyService.historiesByGoal((String) request.get("UserId"));
        return ResponseEntity.ok(historyList);
    }
}
