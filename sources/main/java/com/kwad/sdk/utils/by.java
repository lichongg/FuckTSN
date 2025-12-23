package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class by {
    private View bbI;
    public Point bbH = new Point();
    public Rect bbF = new Rect();
    public Rect bbG = new Rect();

    public final boolean So() {
        boolean globalVisibleRect = this.bbI.getGlobalVisibleRect(this.bbF, this.bbH);
        Point point = this.bbH;
        if (point.x == 0 && point.y == 0 && this.bbF.height() == this.bbI.getHeight() && this.bbG.height() != 0 && Math.abs(this.bbF.top - this.bbG.top) > this.bbI.getHeight() / 2) {
            this.bbF.set(this.bbG);
        }
        this.bbG.set(this.bbF);
        return globalVisibleRect;
    }

    public by(View view) {
        this.bbI = view;
    }
}
