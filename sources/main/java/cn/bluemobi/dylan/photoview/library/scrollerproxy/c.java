package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.content.Context;
import android.widget.Scroller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends d {

    /* renamed from: a, reason: collision with root package name */
    private final Scroller f1363a;

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void b(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f1363a.fling(i6, i7, i8, i9, i10, i11, i12, i13);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean a() {
        return this.f1363a.computeScrollOffset();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void c(boolean z5) {
        this.f1363a.forceFinished(z5);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int d() {
        return this.f1363a.getCurrX();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int e() {
        return this.f1363a.getCurrY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean g() {
        return this.f1363a.isFinished();
    }

    public c(Context context) {
        this.f1363a = new Scroller(context);
    }
}
