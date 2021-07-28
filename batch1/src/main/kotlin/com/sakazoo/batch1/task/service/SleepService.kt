package com.sakazoo.batch1.task.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class SleepService {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }
    fun sleep() {
        log.info("sleep start.")
        TimeUnit.SECONDS.sleep(3)
        log.info("sleep end.")
    }
}