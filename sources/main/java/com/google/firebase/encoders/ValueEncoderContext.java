package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(double d6) throws IOException;

    @NonNull
    ValueEncoderContext add(float f6) throws IOException;

    @NonNull
    ValueEncoderContext add(int i6) throws IOException;

    @NonNull
    ValueEncoderContext add(long j6) throws IOException;

    @NonNull
    ValueEncoderContext add(@Nullable String str) throws IOException;

    @NonNull
    ValueEncoderContext add(boolean z5) throws IOException;

    @NonNull
    ValueEncoderContext add(@NonNull byte[] bArr) throws IOException;
}
