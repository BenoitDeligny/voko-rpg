package event

import kotlin.reflect.KClass

interface Subscriber<in E>: (E) -> Unit

interface EventBus<in E> {
    fun publish(event: E)
}

class SimpleEventBus<E : Any> : EventBus<E> {
    private val subscribers = mutableMapOf<KClass<*>, List<Subscriber<*>>>()

    override fun publish(event: E) {
        subscribers.filter { it.key.isInstance(event) }
            .flatMap { it.value }
            .forEach {
                @Suppress("UNCHECKED_CAST")
                (it as Subscriber<E>)(event)
            }
    }

    inline fun <reified T : E> register(subscriber: Subscriber<T>) {
        register(T::class, subscriber)
    }

    fun <T : E> register(type: KClass<T>, subscriber: Subscriber<T>) {
        val existing = subscribers.getOrDefault(type, emptyList())
        subscribers[type] = existing + subscriber
    }
}