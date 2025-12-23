package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements com.bumptech.glide.load.a<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15408a = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        try {
            com.bumptech.glide.util.a.e(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(f15408a, 3);
            return false;
        }
    }
}
