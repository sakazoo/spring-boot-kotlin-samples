package com.sakazoo.app2.repository.mapper

import com.sakazoo.app2.model.MatchVenue
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface MatchVenueMapper {
    @Select("""
        SELECT
          *
        FROM
          match_venue
    """)
    fun selectAll(): List<MatchVenue>
}