package io.netty.util.concurrent;

import java.lang.Thread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ThreadProperties {
    long id();

    boolean isAlive();

    boolean isDaemon();

    boolean isInterrupted();

    String name();

    int priority();

    StackTraceElement[] stackTrace();

    Thread.State state();
}
