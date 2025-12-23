package com.github.barteksc.pdfviewer.util;

import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class PageSizeCalculator {
    private boolean fitEachPage;
    private FitPolicy fitPolicy;
    private float heightRatio;
    private SizeF optimalMaxHeightPageSize;
    private SizeF optimalMaxWidthPageSize;
    private final Size originalMaxHeightPageSize;
    private final Size originalMaxWidthPageSize;
    private final Size viewSize;
    private float widthRatio;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.github.barteksc.pdfviewer.util.PageSizeCalculator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy;

        static {
            int[] iArr = new int[FitPolicy.values().length];
            $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy = iArr;
            try {
                iArr[FitPolicy.HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[FitPolicy.BOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void calculateMaxPages() {
        int i6 = AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[this.fitPolicy.ordinal()];
        if (i6 == 1) {
            SizeF fitHeight = fitHeight(this.originalMaxHeightPageSize, this.viewSize.a());
            this.optimalMaxHeightPageSize = fitHeight;
            this.heightRatio = fitHeight.a() / this.originalMaxHeightPageSize.a();
            this.optimalMaxWidthPageSize = fitHeight(this.originalMaxWidthPageSize, r0.a() * this.heightRatio);
            return;
        }
        if (i6 != 2) {
            SizeF fitWidth = fitWidth(this.originalMaxWidthPageSize, this.viewSize.b());
            this.optimalMaxWidthPageSize = fitWidth;
            this.widthRatio = fitWidth.b() / this.originalMaxWidthPageSize.b();
            this.optimalMaxHeightPageSize = fitWidth(this.originalMaxHeightPageSize, r0.b() * this.widthRatio);
            return;
        }
        float b6 = fitBoth(this.originalMaxWidthPageSize, this.viewSize.b(), this.viewSize.a()).b() / this.originalMaxWidthPageSize.b();
        SizeF fitBoth = fitBoth(this.originalMaxHeightPageSize, r1.b() * b6, this.viewSize.a());
        this.optimalMaxHeightPageSize = fitBoth;
        this.heightRatio = fitBoth.a() / this.originalMaxHeightPageSize.a();
        SizeF fitBoth2 = fitBoth(this.originalMaxWidthPageSize, this.viewSize.b(), this.originalMaxWidthPageSize.a() * this.heightRatio);
        this.optimalMaxWidthPageSize = fitBoth2;
        this.widthRatio = fitBoth2.b() / this.originalMaxWidthPageSize.b();
    }

    public SizeF getOptimalMaxHeightPageSize() {
        return this.optimalMaxHeightPageSize;
    }

    public SizeF getOptimalMaxWidthPageSize() {
        return this.optimalMaxWidthPageSize;
    }

    public PageSizeCalculator(FitPolicy fitPolicy, Size size, Size size2, Size size3, boolean z5) {
        this.fitPolicy = fitPolicy;
        this.originalMaxWidthPageSize = size;
        this.originalMaxHeightPageSize = size2;
        this.viewSize = size3;
        this.fitEachPage = z5;
        calculateMaxPages();
    }

    private SizeF fitBoth(Size size, float f6, float f7) {
        float b6 = size.b() / size.a();
        float floor = (float) Math.floor(f6 / b6);
        if (floor > f7) {
            f6 = (float) Math.floor(b6 * f7);
        } else {
            f7 = floor;
        }
        return new SizeF(f6, f7);
    }

    private SizeF fitHeight(Size size, float f6) {
        return new SizeF((float) Math.floor(f6 / (size.a() / size.b())), f6);
    }

    private SizeF fitWidth(Size size, float f6) {
        return new SizeF(f6, (float) Math.floor(f6 / (size.b() / size.a())));
    }

    public SizeF calculate(Size size) {
        float b6;
        float a6;
        if (size.b() > 0 && size.a() > 0) {
            if (this.fitEachPage) {
                b6 = this.viewSize.b();
            } else {
                b6 = size.b() * this.widthRatio;
            }
            if (this.fitEachPage) {
                a6 = this.viewSize.a();
            } else {
                a6 = size.a() * this.heightRatio;
            }
            int i6 = AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[this.fitPolicy.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    return fitWidth(size, b6);
                }
                return fitBoth(size, b6, a6);
            }
            return fitHeight(size, a6);
        }
        return new SizeF(0.0f, 0.0f);
    }
}
