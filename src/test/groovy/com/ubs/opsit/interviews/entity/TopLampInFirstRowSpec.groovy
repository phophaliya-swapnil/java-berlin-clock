package com.ubs.opsit.interviews.entity

import org.joda.time.LocalTime
import spock.lang.Specification

class TopLampInFirstRowSpec extends Specification {

    def "updateOnOFF should return expected outcome"() {

        given:
        TopLamp topLamp = TopLamp.topLamp()

        when:
        topLamp.updateOnOff(input)

        then:
        topLamp.isOn() == expectedOutput
        topLamp.colour == Lamp.YELLOW

        where:
        input                       | expectedOutput
        LocalTime.MIDNIGHT          | true
        LocalTime.parse('00:00:01') | false
        LocalTime.parse('05:00:58') | true
    }

}


