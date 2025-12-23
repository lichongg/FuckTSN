package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAPoint {

    @Nullable
    private AAPointEvents events;

    @NotNull
    public final AAPoint events(@NotNull AAPointEvents prop) {
        g0.p(prop, "prop");
        this.events = prop;
        return this;
    }

    @Nullable
    public final AAPointEvents getEvents() {
        return this.events;
    }

    public final void setEvents(@Nullable AAPointEvents aAPointEvents) {
        this.events = aAPointEvents;
    }
}
