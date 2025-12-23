package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.u;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c implements com.bumptech.glide.load.h<GifDrawable> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15724a = "GifEncoder";

    @Override // com.bumptech.glide.load.h
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.f fVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull u<GifDrawable> uVar, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        try {
            com.bumptech.glide.util.a.e(uVar.get().c(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(f15724a, 5);
            return false;
        }
    }
}
