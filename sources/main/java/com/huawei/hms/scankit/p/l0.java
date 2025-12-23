package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.hardware.Camera;
import com.huawei.hms.scankit.p.k0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    private Camera f34503a;

    public synchronized void a(Camera camera) {
        this.f34503a = camera;
    }

    public synchronized k0 a() {
        RuntimeException e6;
        int i6;
        Rect rect;
        try {
            i6 = this.f34503a.getParameters().getMaxNumMeteringAreas();
        } catch (RuntimeException e7) {
            e6 = e7;
            i6 = 0;
        }
        try {
            rect = this.f34503a.getParameters().getMeteringAreas().get(0).rect;
        } catch (RuntimeException e8) {
            e6 = e8;
            e6.getMessage();
            rect = null;
            return new k0(i6, rect);
        }
        return new k0(i6, rect);
    }

    public synchronized void a(List<k0.a> list) {
        try {
            Camera camera = this.f34503a;
            if (camera == null) {
                return;
            }
            Camera.Parameters parameters = camera.getParameters();
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < list.size(); i6++) {
                arrayList.add(new Camera.Area(list.get(i6).f34480a, list.get(i6).f34481b));
            }
            parameters.setMeteringAreas(arrayList);
            try {
                this.f34503a.setParameters(parameters);
            } catch (RuntimeException e6) {
                e6.getMessage();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
