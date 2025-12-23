package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j<R> implements f<R> {

    /* renamed from: a, reason: collision with root package name */
    private final a f16296a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(View view);
    }

    public j(a aVar) {
        this.f16296a = aVar;
    }

    @Override // com.bumptech.glide.request.transition.f
    public boolean a(R r5, f.a aVar) {
        if (aVar.getView() != null) {
            this.f16296a.a(aVar.getView());
            return false;
        }
        return false;
    }
}
