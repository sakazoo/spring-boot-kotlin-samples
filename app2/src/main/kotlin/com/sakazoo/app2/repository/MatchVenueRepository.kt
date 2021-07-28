package com.sakazoo.app2.repository

import com.sakazoo.app2.repository.mapper.MatchVenueMapper
import org.springframework.stereotype.Repository

@Repository
class MatchVenueRepository(private val matchVenueMapper: MatchVenueMapper) {
    fun selectAll() = matchVenueMapper.selectAll()
}