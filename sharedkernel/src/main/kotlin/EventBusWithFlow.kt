import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filterIsInstance

// Use this for scalable and high throughput event bus

interface Event

object EventBusWithFlow {
    val eventFlow = MutableSharedFlow<Event>()

    suspend fun publish(event: Event) {
        eventFlow.emit(event)
    }
    inline fun <reified T : Event> subscribe(): Flow<T> {
        return eventFlow.filterIsInstance<T>()
    }
}