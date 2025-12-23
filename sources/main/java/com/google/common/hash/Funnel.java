package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
/* loaded from: D:\Downloads\app\classes5.dex */
public interface Funnel<T> extends Serializable {
    void funnel(T t5, PrimitiveSink primitiveSink);
}
