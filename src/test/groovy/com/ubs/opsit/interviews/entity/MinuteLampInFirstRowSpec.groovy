package com.ubs.opsit.interviews.entity

import org.joda.time.LocalTime
import spock.lang.Specification

class MinuteLampInFirstRowSpec extends Specification {

    def "updateOnOFF should return expected outcome"() {

        given:
        MinuteLampInFirstRow minuteLampInFirstRow = MinuteLampInFirstRow.minuteLampInFirstRow(index)

        when:
        minuteLampInFirstRow.updateOnOff(input)

        then:
        minuteLampInFirstRow.isOn() == expectedOutput
        minuteLampInFirstRow.getColour() == expectedColor

        where:
        index | input                       | expectedOutput | expectedColor
        0     | LocalTime.MIDNIGHT          | false          | Lamp.YELLOW
        0     | LocalTime.parse('00:05:00') | true           | Lamp.YELLOW
        1     | LocalTime.parse('00:05:00') | false          | Lamp.YELLOW
        2     | LocalTime.parse('00:15:00') | true           | Lamp.RED
        5     | LocalTime.parse('00:30:00') | true           | Lamp.RED
        8     | LocalTime.parse('00:45:00') | true           | Lamp.RED

    }

}


