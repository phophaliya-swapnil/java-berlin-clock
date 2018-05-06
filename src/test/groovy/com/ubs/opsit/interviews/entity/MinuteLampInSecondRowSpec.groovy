package com.ubs.opsit.interviews.entity

import org.joda.time.LocalTime
import spock.lang.Specification

class MinuteLampInSecondRowSpec extends Specification {

    def "updateOnOFF should return expected outcome"() {

        given:
        MinuteLampInSecondRow minuteLampInSecondRow = MinuteLampInSecondRow.minuteLampInSecondRow(index)

        when:
        minuteLampInSecondRow.updateOnOff(input)

        then:
        minuteLampInSecondRow.isOn() == expectedOutput
        minuteLampInSecondRow.colour == Lamp.YELLOW

        where:
        index | input                       | expectedOutput
        0     | LocalTime.MIDNIGHT          | false
        0     | LocalTime.parse('00:56:00') | true
        1     | LocalTime.parse('00:56:00') | false
    }

}


