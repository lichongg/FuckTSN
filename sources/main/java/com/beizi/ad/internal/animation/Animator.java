package com.beizi.ad.internal.animation;

import android.content.Context;
import android.widget.ViewAnimator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Animator extends ViewAnimator {

    /* renamed from: a, reason: collision with root package name */
    private f f11641a;

    /* renamed from: b, reason: collision with root package name */
    private h f11642b;

    /* renamed from: c, reason: collision with root package name */
    private g f11643c;

    /* renamed from: d, reason: collision with root package name */
    private long f11644d;

    @Override // android.view.View
    public void clearAnimation() {
        setInAnimation(null);
        setOutAnimation(null);
    }

    public g getTransitionDirection() {
        return this.f11643c;
    }

    public long getTransitionDuration() {
        return this.f11644d;
    }

    public h getTransitionType() {
        return this.f11642b;
    }

    public void setAnimation() {
        f fVar = this.f11641a;
        if (fVar != null) {
            setInAnimation(fVar.a());
            setOutAnimation(this.f11641a.b());
        }
    }

    public void setTransitionDirection(g gVar) {
        if (this.f11643c != gVar) {
            this.f11643c = gVar;
            this.f11641a = a.a(this.f11642b, this.f11644d, gVar);
            setAnimation();
        }
    }

    public void setTransitionDuration(long j6) {
        if (this.f11644d != j6) {
            this.f11644d = j6;
            this.f11641a = a.a(this.f11642b, j6, this.f11643c);
            setAnimation();
        }
    }

    public void setTransitionType(h hVar) {
        if (this.f11642b != hVar) {
            this.f11642b = hVar;
            this.f11641a = a.a(hVar, this.f11644d, this.f11643c);
            setAnimation();
        }
    }

    public Animator(Context context, h hVar, g gVar, long j6) {
        super(context);
        this.f11641a = null;
        this.f11642b = hVar;
        this.f11643c = gVar;
        this.f11644d = j6;
        this.f11641a = a.a(hVar, j6, gVar);
        setAnimation();
    }
}
