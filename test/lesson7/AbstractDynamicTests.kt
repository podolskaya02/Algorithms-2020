package lesson7

import kotlin.test.assertEquals
import kotlin.test.assertFails

abstract class AbstractDynamicTests {
    fun longestCommonSubSequence(longestCommonSubSequence: (String, String) -> String) {
        assertEquals("здс", longestCommonSubSequence("здравствуй мир", "мы здесь"))
        assertEquals("", longestCommonSubSequence("мой мир", "я"))
        assertEquals("1", longestCommonSubSequence("1", "1"))
        assertEquals("13", longestCommonSubSequence("123", "13"))
        assertEquals("здс", longestCommonSubSequence("здравствуй мир", "мы здесь"))
        assertEquals("emt ole", longestCommonSubSequence("nematode knowledge", "empty bottle"))
        val expectedLength = "e kerwelkkd r".length
        assertEquals(
            expectedLength, longestCommonSubSequence(
                "oiweijgw kejrhwejelkrw kjhdkfjs hrk",
                "perhkhk lerkerorwetp lkjklvvd durltr"
            ).length, "Answer must have length of $expectedLength, e.g. 'e kerwelkkd r' or 'erhlkrw kjk r'"
        )
        val expectedLength2 = """ дд саы чтых,
евшнео ваа се сви дн.
        """.trimIndent().length
        assertEquals(
            expectedLength2, longestCommonSubSequence(
                """
Мой дядя самых честных правил,
Когда не в шутку занемог,
Он уважать себя заставил
И лучше выдумать не мог.
                """.trimIndent(),
                """
Так думал молодой повеса,
Летя в пыли на почтовых,
Всевышней волею Зевеса
Наследник всех своих родных.
                """.trimIndent()
            ).length, "Answer must have length of $expectedLength2"
        )
        assertEquals("", longestCommonSubSequence("So cool", "соотношение"))
        assertEquals("L EO", longestCommonSubSequence("heLlo evEryOne", "HELLO EVERYONE"))
        assertEquals(
            " so hap aseto I nd  friendhere in y hed o gl thts oa caue so ae yore or mrrsnda mg s eeda o ll  aeAn m not scard",
            longestCommonSubSequence(
                "We passed upon the stair We spoke of was and when" +
                        "Although I wasn't there" + "He said I was his friend" + "Which came as a surprise" +
                        "I spoke into his eyes" + "I thought you died alone" + "A long long time ago" +
                        "Oh no, not me" + "We never lost control" + "You're face to face" +
                        "With the man who sold the world" + "I laughed and shook hand" + "And made my way back home" +
                        "I searched for form and land" + "For years and years I roamed" +
                        "I gazed a gazeless stare" + "We walked a million hills" +
                        "I must have died alone" + "A long, long time ago" +
                        "Who knows?" + "Not me" + "I never lost control" +
                        "You're face to face" + "With the man who sold the world",

                "I'm so happy 'cause today I found my friends" + "They're in my head" +
                        "I'm so ugly, that's okay, 'cause so are you" + "Broke our mirrors" +
                        "Sunday morning is everyday, for all I care" + "And I'm not scared"
            )
        )
    }

    fun longestIncreasingSubSequence(longestIncreasingSubSequence: (List<Int>) -> List<Int>) {
        assertEquals(listOf(), longestIncreasingSubSequence(listOf()))
        assertEquals(listOf(1), longestIncreasingSubSequence(listOf(1)))
        assertEquals(listOf(1, 2), longestIncreasingSubSequence(listOf(1, 2)))
        assertEquals(listOf(2), longestIncreasingSubSequence(listOf(2, 1)))
        assertEquals(
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            longestIncreasingSubSequence(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        )
        assertEquals(listOf(2, 8, 9, 12), longestIncreasingSubSequence(listOf(2, 8, 5, 9, 12, 6)))
        assertEquals(
            listOf(23, 34, 56, 87, 91, 98, 140, 349), longestIncreasingSubSequence(
                listOf(
                    23, 76, 34, 93, 123, 21, 56, 87, 91, 12, 45, 98, 140, 12, 5, 38, 349, 65, 94,
                    45, 76, 15, 99, 100, 88, 84, 35, 88
                )
            )
        )
        assertEquals(
            listOf(2, 24, 101, 908, 1234, 1235, 1236, 1879, 1880, 1900, 2134, 7888, 8900), longestIncreasingSubSequence(
                listOf(
                    1543, 2345, 555, 2, 1254, 24, 1000, 101, 2678, 2346, 0, 3000, 1500, 2345, 1637,
                    77, 1878, 908, 305, 1234, 1235, 1236, 1879, 1237, 1880, 8000, 1238, 12, 1900,
                    10000, 23450, 15, 2134, 7888, 8900
                ),
            )
        )
        assertEquals(listOf(0), longestIncreasingSubSequence(listOf(0, 0, 0, 0, 0, 0, 0, 0)))
    }

    fun shortestPathOnField(shortestPathOnField: (String) -> Int) {
        assertEquals(1, shortestPathOnField("input/field_in2.txt"))
        assertEquals(12, shortestPathOnField("input/field_in1.txt"))
        assertEquals(43, shortestPathOnField("input/field_in3.txt"))
        assertEquals(28, shortestPathOnField("input/field_in4.txt"))
        assertEquals(222, shortestPathOnField("input/field_in5.txt"))
        assertEquals(15, shortestPathOnField("input/field_in6.txt"))
    }

}