package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final f f36459a;

    public a() {
        this.f36459a = l.k().a();
    }

    @Override // com.orhanobut.logger.g
    public boolean b(int i6, @Nullable String str) {
        return true;
    }

    @Override // com.orhanobut.logger.g
    public void a(int i6, @Nullable String str, @NonNull String str2) {
        this.f36459a.a(i6, str, str2);
    }

    public a(@NonNull f fVar) {
        this.f36459a = (f) n.a(fVar);
    }
}
