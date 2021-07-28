package com.sakazoo.batch1.task

import com.sakazoo.batch1.task.service.SleepService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Task(private val sleepService: SleepService) {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 5000, zone = "Asia/Tokyo")
    fun task1() {
        log.info("task1 start")
        sleepService.sleep()
        log.info("task1 end")
    }
}