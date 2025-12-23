package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f15836a = new ArrayList();

    public synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f15836a.add(imageHeaderParser);
    }

    @NonNull
    public synchronized List<ImageHeaderParser> b() {
        return this.f15836a;
    }
}
