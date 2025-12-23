package io.netty.handler.timeout;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IdleStateEvent {
    public static final IdleStateEvent ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_WRITER_IDLE_STATE_EVENT;
    public static final IdleStateEvent READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent WRITER_IDLE_STATE_EVENT;
    private final boolean first;
    private final IdleState state;

    static {
        IdleState idleState = IdleState.READER_IDLE;
        FIRST_READER_IDLE_STATE_EVENT = new IdleStateEvent(idleState, true);
        READER_IDLE_STATE_EVENT = new IdleStateEvent(idleState, false);
        IdleState idleState2 = IdleState.WRITER_IDLE;
        FIRST_WRITER_IDLE_STATE_EVENT = new IdleStateEvent(idleState2, true);
        WRITER_IDLE_STATE_EVENT = new IdleStateEvent(idleState2, false);
        IdleState idleState3 = IdleState.ALL_IDLE;
        FIRST_ALL_IDLE_STATE_EVENT = new IdleStateEvent(idleState3, true);
        ALL_IDLE_STATE_EVENT = new IdleStateEvent(idleState3, false);
    }

    public boolean isFirst() {
        return this.first;
    }

    public IdleState state() {
        return this.state;
    }

    protected IdleStateEvent(IdleState idleState, boolean z5) {
        this.state = (IdleState) ObjectUtil.checkNotNull(idleState, "state");
        this.first = z5;
    }
}
