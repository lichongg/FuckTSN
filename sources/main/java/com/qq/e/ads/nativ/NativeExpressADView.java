package com.qq.e.ads.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.LADI;
import com.qq.e.comm.pi.NFBI;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class NativeExpressADView extends FrameLayout implements DownloadConfirmListener, LADI, NFBI {

    /* renamed from: a, reason: collision with root package name */
    private int f36653a;

    /* renamed from: b, reason: collision with root package name */
    private double f36654b;

    /* renamed from: c, reason: collision with root package name */
    private double f36655c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract void negativeFeedback();

    public abstract void preloadVideo();

    public abstract void render();

    @Deprecated
    public abstract void setAdSize(ADSize aDSize);

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);

    public abstract void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener);

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        int min;
        int min2;
        if (this.f36653a <= 0 || this.f36654b <= 0.0d || this.f36655c <= 0.0d) {
            super.onMeasure(i6, i7);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        if (mode == 1073741824 && mode2 == 1073741824) {
            if (size2 < this.f36653a || size < this.f36654b * size2) {
                double d6 = this.f36655c;
                double d7 = size2 * d6;
                double d8 = size;
                if (d7 < d8) {
                    min2 = (int) (d7 + 0.5d);
                    i6 = View.MeasureSpec.makeMeasureSpec(min2, 1073741824);
                } else {
                    min = (int) ((d8 / d6) + 0.5d);
                    i7 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                }
            }
        } else if (mode2 == 1073741824) {
            min2 = Math.min((int) ((size2 * this.f36655c) + 0.5d), size);
            i6 = View.MeasureSpec.makeMeasureSpec(min2, 1073741824);
        } else {
            min = Math.min((int) ((size / this.f36655c) + 0.5d), size2);
            i7 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        }
        View.MeasureSpec.getSize(i6);
        View.MeasureSpec.getSize(i7);
        super.onMeasure(i6, i7);
        if (mode != Integer.MIN_VALUE || size == getMeasuredWidth()) {
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((getMeasuredWidth() / this.f36655c) + 0.5d), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Integer.MIN_VALUE);
        View.MeasureSpec.getSize(makeMeasureSpec2);
        View.MeasureSpec.getSize(makeMeasureSpec);
        super.onMeasure(makeMeasureSpec2, makeMeasureSpec);
    }

    public void setSizeRules(int i6, double d6, double d7) {
        this.f36653a = i6;
        this.f36654b = d6;
        this.f36655c = d7;
    }

    public NativeExpressADView(Context context) {
        super(context);
        this.f36653a = -1;
        this.f36654b = -1.0d;
        this.f36655c = -1.0d;
    }
}
