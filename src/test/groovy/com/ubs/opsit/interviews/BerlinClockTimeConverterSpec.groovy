package com.ubs.opsit.interviews

import spock.lang.Specification

class BerlinClockTimeConverterSpec extends Specification {

    def 'test 1'() {

        given:
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter()

        when:
        String berlinClockString = berlinClockTimeConverter.convertTime('13:17:01')

        then:
        berlinClockString == '''O
RROO
RRRO
YYROOOOOOOO
YYOO'''
    }

    def 'test 2'() {

        given:
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter()

        when:
        String berlinClockString = berlinClockTimeConverter.convertTime('00:00:00')

        then:
        berlinClockString == '''O
RRRR
RRRO
YYRYYRYYRYY
YYYY'''
    }
}
