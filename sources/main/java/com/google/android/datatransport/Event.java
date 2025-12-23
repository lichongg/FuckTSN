package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i6, T t5) {
        return new AutoValue_Event(Integer.valueOf(i6), t5, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(int i6, T t5) {
        return new AutoValue_Event(Integer.valueOf(i6), t5, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(int i6, T t5) {
        return new AutoValue_Event(Integer.valueOf(i6), t5, Priority.HIGHEST);
    }

    @Nullable
    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public static <T> Event<T> ofData(T t5) {
        return new AutoValue_Event(null, t5, Priority.DEFAULT);
    }

    public static <T> Event<T> ofTelemetry(T t5) {
        return new AutoValue_Event(null, t5, Priority.VERY_LOW);
    }

    public static <T> Event<T> ofUrgent(T t5) {
        return new AutoValue_Event(null, t5, Priority.HIGHEST);
    }
}
