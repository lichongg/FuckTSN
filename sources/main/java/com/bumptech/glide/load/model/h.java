package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.j;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final h f15433a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final h f15434b = new j.a().c();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements h {
        @Override // com.bumptech.glide.load.model.h
        public Map<String, String> getHeaders() {
            return Collections.EMPTY_MAP;
        }

        a() {
        }
    }

    Map<String, String> getHeaders();
}
