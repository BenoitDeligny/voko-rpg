package event

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filterIsInstance

// Use this for scalable and high throughput event bus

interface EventWithFlow

object EventBusWithFlow {
    val eventWithFlow = MutableSharedFlow<EventWithFlow>()

    suspend fun publish(eventWithFlow: EventWithFlow) {
        EventBusWithFlow.eventWithFlow.emit(eventWithFlow)
    }
    inline fun <reified T : EventWithFlow> subscribe(): Flow<T> {
        return eventWithFlow.filterIsInstance<T>()
    }
}