package com.kwad.sdk.core.imageloader.core.assist.deque;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean offer(T t5) {
        return super.offerFirst(t5);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public T remove() {
        return (T) super.removeFirst();
    }
}
