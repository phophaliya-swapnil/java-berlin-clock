package com.ubs.opsit.interviews

import spock.lang.Specification

class BerlinClockTimeConverterSpec extends Specification {

    def 'Midnight'() {

        given:
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter()

        when:
        String berlinClockString = berlinClockTimeConverter.convertTime('00:00:00')

        then:
        berlinClockString == '''Y
OOOO
OOOO
OOOOOOOOOOO
OOOO'''
    }

    def 'Middle of the afternoon'() {

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

    def 'Just before midnight'() {

        given:
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter()

        when:
        String berlinClockString = berlinClockTimeConverter.convertTime('23:59:59')

        then:
        berlinClockString == '''O
RRRR
RRRO
YYRYYRYYRYY
YYYY'''
    }

    def 'Midnight 24'() {

        given:
        BerlinClockTimeConverter berlinClockTimeConverter = new BerlinClockTimeConverter()

        when:
        String berlinClockString = berlinClockTimeConverter.convertTime('24:00:00')

        then:
        berlinClockString == '''Y
RRRR
RRRR
OOOOOOOOOOO
OOOO'''
    }
}
