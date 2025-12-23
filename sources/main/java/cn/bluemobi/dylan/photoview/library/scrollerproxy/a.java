package cn.bluemobi.dylan.photoview.library.scrollerproxy;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.OverScroller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(9)
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends d {

    /* renamed from: a, reason: collision with root package name */
    protected final OverScroller f1361a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1362b = false;

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean a() {
        if (this.f1362b) {
            this.f1361a.computeScrollOffset();
            this.f1362b = false;
        }
        return this.f1361a.computeScrollOffset();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void b(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f1361a.fling(i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public void c(boolean z5) {
        this.f1361a.forceFinished(z5);
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int d() {
        return this.f1361a.getCurrX();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public int e() {
        return this.f1361a.getCurrY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.scrollerproxy.d
    public boolean g() {
        return this.f1361a.isFinished();
    }

    public a(Context context) {
        this.f1361a = new OverScroller(context);
    }
}
