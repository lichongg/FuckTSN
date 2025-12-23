package com.devlin_n.videoplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ResizeTextureView extends TextureView {

    /* renamed from: a, reason: collision with root package name */
    private int f32419a;

    /* renamed from: b, reason: collision with root package name */
    private int f32420b;

    /* renamed from: c, reason: collision with root package name */
    private int f32421c;

    public ResizeTextureView(Context context) {
        super(context);
    }

    public ResizeTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i6, int i7) {
        this.f32419a = i6;
        this.f32420b = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        if (r1 > r7) goto L53;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            int r0 = r6.f32419a
            int r0 = android.view.View.getDefaultSize(r0, r7)
            int r1 = r6.f32420b
            int r1 = android.view.View.getDefaultSize(r1, r8)
            int r2 = r6.f32421c
            r3 = 1
            if (r2 == r3) goto La2
            r3 = 2
            r4 = 4
            r5 = 3
            if (r2 == r3) goto L95
            if (r2 == r5) goto Lae
            if (r2 == r4) goto L90
            int r2 = r6.f32419a
            if (r2 <= 0) goto L8d
            int r2 = r6.f32420b
            if (r2 <= 0) goto L8d
            int r0 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            int r8 = android.view.View.MeasureSpec.getSize(r8)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L54
            if (r1 != r2) goto L54
            int r0 = r6.f32419a
            int r1 = r0 * r8
            int r2 = r6.f32420b
            int r3 = r7 * r2
            if (r1 >= r3) goto L48
            int r0 = r0 * r8
            int r7 = r0 / r2
            goto Lae
        L48:
            int r1 = r0 * r8
            int r3 = r7 * r2
            if (r1 <= r3) goto Lae
            int r2 = r2 * r7
            int r8 = r2 / r0
            goto Lae
        L54:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L66
            int r0 = r6.f32420b
            int r0 = r0 * r7
            int r2 = r6.f32419a
            int r0 = r0 / r2
            if (r1 != r3) goto L64
            if (r0 <= r8) goto L64
            goto Lae
        L64:
            r8 = r0
            goto Lae
        L66:
            if (r1 != r2) goto L76
            int r1 = r6.f32419a
            int r1 = r1 * r8
            int r2 = r6.f32420b
            int r1 = r1 / r2
            if (r0 != r3) goto L74
            if (r1 <= r7) goto L74
            goto Lae
        L74:
            r7 = r1
            goto Lae
        L76:
            int r2 = r6.f32419a
            int r4 = r6.f32420b
            if (r1 != r3) goto L82
            if (r4 <= r8) goto L82
            int r1 = r8 * r2
            int r1 = r1 / r4
            goto L84
        L82:
            r1 = r2
            r8 = r4
        L84:
            if (r0 != r3) goto L74
            if (r1 <= r7) goto L74
            int r4 = r4 * r7
            int r8 = r4 / r2
            goto Lae
        L8d:
            r7 = r0
        L8e:
            r8 = r1
            goto Lae
        L90:
            int r7 = r6.f32419a
            int r8 = r6.f32420b
            goto Lae
        L95:
            int r7 = r0 / 4
            int r8 = r7 * 3
            if (r1 <= r8) goto L9d
        L9b:
            r7 = r0
            goto Lae
        L9d:
            int r7 = r1 / 3
            int r7 = r7 * 4
            goto L8e
        La2:
            int r7 = r0 / 16
            int r8 = r7 * 9
            if (r1 <= r8) goto La9
            goto L9b
        La9:
            int r7 = r1 / 9
            int r7 = r7 * 16
            goto L8e
        Lae:
            r6.setMeasuredDimension(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.devlin_n.videoplayer.widget.ResizeTextureView.onMeasure(int, int):void");
    }

    public void setScreenScale(int i6) {
        this.f32421c = i6;
        requestLayout();
    }
}
