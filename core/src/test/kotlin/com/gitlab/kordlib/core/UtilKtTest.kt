package com.gitlab.kordlib.core

import com.gitlab.kordlib.common.entity.Snowflake
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class UtilKtTest {

    @Test
    @ExperimentalStdlibApi
    fun `paginate forwards selects the right id`() = runBlockingTest {

        val flow = paginateForwards(start = Snowflake(0), batchSize = 100, idSelector = { it.toString() }) {
            var value = it.value.toLong()
            if (value >= 1000) return@paginateForwards emptyList<Snowflake>()
            value += 1 //don't include the position id

            buildList(100) {
                (value until (value + 100)).reversed().forEach { //biggest/youngest -> smallest/oldest
                    add(it)
                }
            }
        }

        Assertions.assertEquals(1000, flow.count())
    }

    @Test
    @ExperimentalStdlibApi
    fun `paginate backwards selects the right id`() = runBlockingTest {

        val flow = paginateBackwards(start = Snowflake(1000), batchSize = 100, idSelector = { it.toString() }) {
            var value = it.value.toLong()
            if (value <= 0) return@paginateBackwards emptyList<Snowflake>()
            value -= 1 //don't include the position id

            buildList(100) {
                ((value - 99 /*reverse until, don't count the lowest value*/)..value).reversed().forEach { //biggest/youngest -> smallest/oldest
                    add(it)
                }
            }
        }

        Assertions.assertEquals(1000, flow.count())
    }

}
