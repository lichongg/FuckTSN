package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.JavaBackTraceElement;
import com.kwad.sdk.crash.message.NativeBackTraceElement;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class eq {
    @InvokeBy(invokerClass = go.class, methodId = "registerHolder")
    public static void Hk() {
        go.Hl().put(JavaBackTraceElement.class, new gm());
        go.Hl().put(AnrReason.class, new bh());
        go.Hl().put(com.kwad.sdk.crash.online.monitor.a.c.class, new hi());
        go.Hl().put(com.kwad.sdk.crash.model.b.class, new ed());
        go.Hl().put(NativeBackTraceElement.class, new hp());
        go.Hl().put(BlockEvent.class, new ca());
        go.Hl().put(BackTraceElement.class, new bu());
        go.Hl().put(BlockEvent.a.class, new lk());
        go.Hl().put(com.kwad.sdk.crash.a.class, new df());
        go.Hl().put(com.kwad.sdk.crash.online.monitor.block.d.class, new cb());
        go.Hl().put(Backtrace.class, new bv());
        go.Hl().put(com.kwad.sdk.crash.online.monitor.a.b.class, new eh());
        go.Hl().put(com.kwad.sdk.crash.online.monitor.a.a.class, new bz());
    }
}
