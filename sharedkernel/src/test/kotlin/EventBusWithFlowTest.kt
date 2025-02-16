import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID

data class TestEventFlow(val message: String) : Event
data class FooEventFlow(val id: UUID = randomUUID(), val details: String = "foo") : Event
data class BarEventFlow(val id: UUID = randomUUID(), val count: Int = 100) : Event

class EventBusTest {

    @Test
    fun `event is received by subscriber`() = runTest {
        val receivedEvents = mutableListOf<TestEventFlow>()

        val job = launch {
            EventBusWithFlow.subscribe<TestEventFlow>().collect { event ->
                receivedEvents.add(event)
            }
        }

        // Wait for the subscriber to start
        delay(10)

        EventBusWithFlow.publish(TestEventFlow("Hello, World!"))

        assertEquals(1, receivedEvents.size)
        assertEquals("Hello, World!", receivedEvents[0].message)

        job.cancel()
    }

    @Test
    fun `only matching event types are received`() = runTest {
        val receivedEvents = mutableListOf<TestEventFlow>()

        val job = launch {
            EventBusWithFlow.subscribe<TestEventFlow>().collect { event ->
                receivedEvents.add(event)
            }
        }

        // Wait for the subscriber to start
        delay(10)

        EventBusWithFlow.publish(FooEventFlow())
        EventBusWithFlow.publish(BarEventFlow())
        EventBusWithFlow.publish(TestEventFlow("Correct Event"))

        assertEquals(1, receivedEvents.size)
        assertEquals("Correct Event", receivedEvents[0].message)

        job.cancel()
    }

    @Test
    fun `multiple event types are received`() = runTest {
        val testEvents = mutableListOf<TestEventFlow>()
        val fooEvents = mutableListOf<FooEventFlow>()
        val barEvents = mutableListOf<BarEventFlow>()

        val testEventJob = launch {
            EventBusWithFlow.subscribe<TestEventFlow>().collect { event ->
                testEvents.add(event)
            }
        }

        val fooEventJob = launch {
            EventBusWithFlow.subscribe<FooEventFlow>().collect { event ->
                fooEvents.add(event)
            }
        }

        val barEventJob = launch {
            EventBusWithFlow.subscribe<BarEventFlow>().collect { event ->
                barEvents.add(event)
            }
        }

        // Wait for the subscribers to start
        delay(10)

        EventBusWithFlow.publish(TestEventFlow("Correct Event"))
        EventBusWithFlow.publish(FooEventFlow())
        EventBusWithFlow.publish(BarEventFlow())

        assertEquals(1, testEvents.size)
        assertEquals("Correct Event", testEvents[0].message)

        assertEquals(1, fooEvents.size)
        assertEquals("foo", fooEvents[0].details)

        assertEquals(1, barEvents.size)
        assertEquals(100, barEvents[0].count)

        testEventJob.cancel()
        fooEventJob.cancel()
        barEventJob.cancel()
    }

    @Test
    fun `subscriber does not receive past events`() = runTest {
        EventBusWithFlow.publish(TestEventFlow("Missed Event"))

        val receivedEvents = mutableListOf<TestEventFlow>()

        val job = launch {
            EventBusWithFlow.subscribe<TestEventFlow>().collect { event ->
                receivedEvents.add(event)
            }
        }

        // Wait for the subscriber to start
        delay(10)

        EventBusWithFlow.publish(TestEventFlow("Received Event"))

        assertEquals(1, receivedEvents.size)
        assertEquals("Received Event", receivedEvents[0].message)

        job.cancel()
    }
}
