package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface IMarker {
    void draw(Canvas canvas, float f6, float f7);

    MPPointF getOffset();

    MPPointF getOffsetForDrawingAtPoint(float f6, float f7);

    void refreshContent(Entry entry, Highlight highlight);
}
