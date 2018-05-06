package com.ubs.opsit.interviews.entity

import org.joda.time.LocalTime
import spock.lang.Specification

class HourLampInFirstRowSpec extends Specification {

    def "updateOnOFF should return expected outcome"() {

        given:
        HourLampInFirstRow hourLampInFirstRow = HourLampInFirstRow.hourLampInFirstRow(index)

        when:
        hourLampInFirstRow.updateOnOff(input)

        then:
        hourLampInFirstRow.isOn() == expectedOutput
        hourLampInFirstRow.colour == Lamp.RED

        where:
        index | input                       | expectedOutput
        0     | LocalTime.MIDNIGHT          | false
        0     | LocalTime.parse('05:00:00') | true
        1     | LocalTime.parse('05:00:00') | false
    }

}


