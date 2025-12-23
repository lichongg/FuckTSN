package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d6) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f6) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i6) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j6) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z5) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, double d6) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, int i6) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, long j6) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, boolean z5) throws IOException;

    @NonNull
    ObjectEncoderContext inline(@Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException;

    @NonNull
    ObjectEncoderContext nested(@NonNull String str) throws IOException;
}
