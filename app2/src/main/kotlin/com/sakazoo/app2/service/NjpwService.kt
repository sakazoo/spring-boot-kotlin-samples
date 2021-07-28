package com.sakazoo.app2.service

import com.sakazoo.app2.model.MatchVenue
import com.sakazoo.app2.repository.MatchVenueRepository
import com.sakazoo.app2.repository.NjpwRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NjpwService(
    private val njpwRepository: NjpwRepository,
    private val matchVenueRepository: MatchVenueRepository
) {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }
    fun getCustomers() = njpwRepository.getCustomers()

    fun getMatchVenues(): List<MatchVenue> {
        val matchVenues = matchVenueRepository.selectAll()
        log.info("get matchVenues = $matchVenues")
        return matchVenues
    }
}