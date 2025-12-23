package com.google.firebase.encoders.config;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface EncoderConfig<T extends EncoderConfig<T>> {
    @NonNull
    <U> T registerEncoder(@NonNull Class<U> cls, @NonNull ObjectEncoder<? super U> objectEncoder);

    @NonNull
    <U> T registerEncoder(@NonNull Class<U> cls, @NonNull ValueEncoder<? super U> valueEncoder);
}
