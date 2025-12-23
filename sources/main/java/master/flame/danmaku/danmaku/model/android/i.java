package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class i extends b {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Float, Float> f50043b = new HashMap();

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z5) {
        float f6 = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (dVar.f50057d == null) {
            CharSequence charSequence = dVar.f50056c;
            if (charSequence != null) {
                f6 = textPaint.measureText(charSequence.toString());
                valueOf = l(dVar, textPaint);
            }
            dVar.f50069p = f6;
            dVar.f50070q = valueOf.floatValue();
            return;
        }
        Float l6 = l(dVar, textPaint);
        for (String str : dVar.f50057d) {
            if (str.length() > 0) {
                f6 = Math.max(textPaint.measureText(str), f6);
            }
        }
        dVar.f50069p = f6;
        dVar.f50070q = dVar.f50057d.length * l6.floatValue();
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void b() {
        f50043b.clear();
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void d(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f6, float f7, boolean z5, a.C0971a c0971a) {
        float f8;
        float f9;
        float f10;
        int i6 = dVar.f50067n;
        float f11 = f6 + i6;
        float f12 = f7 + i6;
        if (dVar.f50066m != 0) {
            f11 += 4.0f;
            f12 += 4.0f;
        }
        float f13 = f12;
        float f14 = f11;
        c0971a.j(z5);
        TextPaint l6 = c0971a.l(dVar, z5);
        i(dVar, canvas, f6, f7);
        String[] strArr = dVar.f50057d;
        if (strArr == null) {
            if (c0971a.o(dVar)) {
                c0971a.g(dVar, l6, true);
                float ascent = f13 - l6.ascent();
                if (c0971a.f49974s) {
                    float f15 = c0971a.f49966k + f14;
                    ascent += c0971a.f49967l;
                    f8 = f15;
                } else {
                    f8 = f14;
                }
                j(dVar, null, canvas, f8, ascent, l6);
            }
            c0971a.g(dVar, l6, false);
            k(dVar, null, canvas, f14, f13 - l6.ascent(), l6, z5);
        } else if (strArr.length == 1) {
            if (c0971a.o(dVar)) {
                c0971a.g(dVar, l6, true);
                float ascent2 = f13 - l6.ascent();
                if (c0971a.f49974s) {
                    float f16 = c0971a.f49966k + f14;
                    ascent2 += c0971a.f49967l;
                    f10 = f16;
                } else {
                    f10 = f14;
                }
                j(dVar, strArr[0], canvas, f10, ascent2, l6);
            }
            c0971a.g(dVar, l6, false);
            k(dVar, strArr[0], canvas, f14, f13 - l6.ascent(), l6, z5);
        } else {
            float length = (dVar.f50070q - (dVar.f50067n * 2)) / strArr.length;
            for (int i7 = 0; i7 < strArr.length; i7++) {
                String str = strArr[i7];
                if (str != null && str.length() != 0) {
                    if (c0971a.o(dVar)) {
                        c0971a.g(dVar, l6, true);
                        float ascent3 = ((i7 * length) + f13) - l6.ascent();
                        if (c0971a.f49974s) {
                            float f17 = c0971a.f49966k + f14;
                            ascent3 += c0971a.f49967l;
                            f9 = f17;
                        } else {
                            f9 = f14;
                        }
                        j(dVar, strArr[i7], canvas, f9, ascent3, l6);
                    }
                    c0971a.g(dVar, l6, false);
                    k(dVar, strArr[i7], canvas, f14, ((i7 * length) + f13) - l6.ascent(), l6, z5);
                }
            }
        }
        if (dVar.f50064k != 0) {
            Paint n6 = c0971a.n(dVar);
            float f18 = (f7 + dVar.f50070q) - c0971a.f49963h;
            canvas.drawLine(f6, f18, f6 + dVar.f50069p, f18, n6);
        }
        if (dVar.f50066m != 0) {
            canvas.drawRect(f6, f7, f6 + dVar.f50069p, f7 + dVar.f50070q, c0971a.k(dVar));
        }
    }

    protected void j(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f6, float f7, Paint paint) {
        if (str != null) {
            canvas.drawText(str, f6, f7, paint);
        } else {
            canvas.drawText(dVar.f50056c.toString(), f6, f7, paint);
        }
    }

    protected void k(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f6, float f7, TextPaint textPaint, boolean z5) {
        if (str != null) {
            canvas.drawText(str, f6, f7, textPaint);
        } else {
            canvas.drawText(dVar.f50056c.toString(), f6, f7, textPaint);
        }
    }

    protected Float l(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
        Float valueOf = Float.valueOf(paint.getTextSize());
        Map<Float, Float> map = f50043b;
        Float f6 = map.get(valueOf);
        if (f6 == null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Float valueOf2 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
            map.put(valueOf, valueOf2);
            return valueOf2;
        }
        return f6;
    }

    protected void i(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f6, float f7) {
    }
}
