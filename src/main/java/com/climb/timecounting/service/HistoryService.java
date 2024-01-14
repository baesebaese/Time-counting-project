package com.climb.timecounting.service;
import com.climb.timecounting.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class HistoryService {

    private final HistoryRepository historyRepository;

    /*
    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    // 임시
    @Transactional(readOnly = true)
    public List<history> getHistoryList() {
        List<history> result = historyRepository.findAll();
        System.out.println("리스트 출력 " + result.toString());
        return result;
    }*/
}
