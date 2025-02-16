import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*
import java.util.UUID.randomUUID
import kotlin.collections.HashMap

class SimpleEventBusTests {

    interface TestEvent
    data class FooEvent(val id: UUID = randomUUID(), val details: String = "foo") : TestEvent
    data class BarEvent(val id: UUID = randomUUID(), val count: Int = 100) : TestEvent

    class TestEventSubscriber(private val listener: EventListener) : Subscriber<TestEvent> {
        override fun invoke(event: TestEvent) {
            listener.register("test", event)
        }
    }

    class FooEventSubscriber(private val listener: EventListener) : Subscriber<FooEvent> {
        override fun invoke(event: FooEvent) {
            listener.register("foo", event)
        }
    }

    class BarEventSubscriber(private val listener: EventListener) : Subscriber<BarEvent> {
        override fun invoke(event: BarEvent) {
            listener.register("bar", event)
        }
    }

    class EventListener : HashMap<String, List<TestEvent>>() {
        fun register(name: String, event: TestEvent) {
            val existing = getOrDefault(name, emptyList())
            put(name, existing + event)
        }
    }

    @Test
    fun `it calls the registered subscribers according to the event type`() {
        val listener = EventListener()
        val eventBus = SimpleEventBus<TestEvent>()
        eventBus.register(TestEventSubscriber(listener))
        eventBus.register(FooEventSubscriber(listener))
        eventBus.register(BarEventSubscriber(listener))

        val foo = FooEvent()
        val bar = BarEvent()

        eventBus.publish(foo)
        eventBus.publish(bar)

        assertEquals(listOf(foo, bar), listener["test"])
        assertEquals(listOf(foo), listener["foo"])
        assertEquals(listOf(bar), listener["bar"])
    }

    @Test
    fun `it register multiple subscribers of the same type`() {
        val listener = EventListener()
        val eventBus = SimpleEventBus<TestEvent>()
        eventBus.register(FooEventSubscriber(listener))
        eventBus.register(FooEventSubscriber(listener))
        eventBus.register(FooEventSubscriber(listener))

        val foo = FooEvent()

        eventBus.publish(foo)

        assertEquals(listOf(foo, foo, foo), listener["foo"])
    }
}