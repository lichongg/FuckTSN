package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public interface IScatterDataSet extends ILineScatterCandleRadarDataSet<Entry> {
    int getScatterShapeHoleColor();

    float getScatterShapeHoleRadius();

    float getScatterShapeSize();

    IShapeRenderer getShapeRenderer();
}
