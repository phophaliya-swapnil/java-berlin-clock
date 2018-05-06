package com.ubs.opsit.interviews.entity

import org.joda.time.LocalTime
import spock.lang.Specification

class HourLampInSecondRowSpec extends Specification {

    def "updateOnOFF should return expected outcome"() {

        given:
        HourLampInSecondRow hourLampInSecondRow = HourLampInSecondRow.HourLampInSecondRow(index)

        when:
        hourLampInSecondRow.updateOnOff(input)

        then:
        hourLampInSecondRow.isOn() == expectedOutput
        hourLampInSecondRow.colour == Lamp.RED

        where:
        index | input                       | expectedOutput
        0     | LocalTime.MIDNIGHT          | false
        0     | LocalTime.parse('21:00:00') | true
        1     | LocalTime.parse('21:00:00') | false
    }

}


