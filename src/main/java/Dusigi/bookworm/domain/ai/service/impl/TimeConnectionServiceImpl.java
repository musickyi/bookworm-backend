package Dusigi.bookworm.domain.ai.service.impl;

import Dusigi.bookworm.domain.ai.service.ConnectionService;
import Dusigi.bookworm.domain.ai.service.TimeConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeConnectionServiceImpl implements TimeConnectionService {

    private final ConnectionService connectionService;

    @Override
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void execute() {
        connectionService.execute();
    }
}
