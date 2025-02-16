import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID

data class TestEventFlow(val message: String) : EventWithFlow
data class FooEventFlow(val id: UUID = randomUUID(), val details: String = "foo") : EventWithFlow
data class BarEventFlow(val id: UUID = randomUUID(), val count: Int = 100) : EventWithFlow

class EventWithFlowBusTest {

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

        receivedEvents.size shouldBe 1
        receivedEvents[0].message shouldBe "Hello, World!"

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

        receivedEvents.size shouldBe 1
        receivedEvents[0].message shouldBe "Correct Event"

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

        testEvents.size shouldBe 1
        testEvents[0].message shouldBe "Correct Event"

        fooEvents.size shouldBe 1
        fooEvents[0].details shouldBe "foo"

        barEvents.size shouldBe 1
        barEvents[0].count shouldBe 100

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

        receivedEvents.size shouldBe 1
        receivedEvents[0].message shouldBe "Received Event"

        job.cancel()
    }
}
