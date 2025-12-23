package org.junit.runners.model;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TestTimedOutException extends Exception {
    private static final long serialVersionUID = 31935685163547539L;
    private final TimeUnit timeUnit;
    private final long timeout;

    public TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public TestTimedOutException(long j6, TimeUnit timeUnit) {
        super(String.format("test timed out after %d %s", Long.valueOf(j6), timeUnit.name().toLowerCase()));
        this.timeUnit = timeUnit;
        this.timeout = j6;
    }
}
