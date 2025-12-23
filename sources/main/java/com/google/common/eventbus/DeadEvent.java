package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.tencent.open.SocialConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public class DeadEvent {
    private final Object event;
    private final Object source;

    public Object getEvent() {
        return this.event;
    }

    public Object getSource() {
        return this.source;
    }

    public DeadEvent(Object obj, Object obj2) {
        this.source = Preconditions.checkNotNull(obj);
        this.event = Preconditions.checkNotNull(obj2);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add(SocialConstants.PARAM_SOURCE, this.source).add("event", this.event).toString();
    }
}
