package com.bytedance.adsdk.ugeno.j.xt;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.j.up;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends j {
    private List<Keyframe> tl;

    /* renamed from: com.bytedance.adsdk.ugeno.j.xt.r$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23706j;

        static {
            int[] iArr = new int[up.values().length];
            f23706j = iArr;
            try {
                iArr[up.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23706j[up.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public TypeEvaluator m() {
        return new FloatEvaluator();
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public List<PropertyValuesHolder> up() {
        String xt = this.f23705r.xt();
        r();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(xt + "X", (Keyframe[]) this.up.toArray(new Keyframe[0]));
        this.f23704m.add(ofKeyframe);
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(xt + "Y", (Keyframe[]) this.tl.toArray(new Keyframe[0]));
        this.f23704m.add(ofKeyframe2);
        TypeEvaluator m6 = m();
        if (m6 != null) {
            ofKeyframe.setEvaluator(m6);
            ofKeyframe2.setEvaluator(m6);
        }
        return this.f23704m;
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public void xt() {
        Keyframe ofFloat;
        Keyframe ofFloat2;
        int i6 = AnonymousClass1.f23706j[this.f23705r.ordinal()];
        if (i6 == 1) {
            ofFloat = Keyframe.ofFloat(0.0f, this.ae.jy());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.ae.ws());
        } else if (i6 != 2) {
            ofFloat = null;
            ofFloat2 = null;
        } else {
            ofFloat = Keyframe.ofFloat(0.0f, this.ae.az());
            ofFloat2 = Keyframe.ofFloat(0.0f, this.ae.av());
        }
        if (ofFloat != null) {
            this.up.add(ofFloat);
        }
        if (ofFloat2 != null) {
            this.tl.add(ofFloat2);
        }
    }

    public r(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, Map<Float, String> map) {
        super(context, cwVar, str, map);
        this.tl = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.j.xt.j
    public void j(float f6, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != 2) {
                    return;
                }
                float optDouble = (float) jSONArray.optDouble(0);
                float optDouble2 = (float) jSONArray.optDouble(1);
                if (this.f23705r == up.TRANSLATE) {
                    optDouble = tl.j(this.f23703j, optDouble);
                    optDouble2 = tl.j(this.f23703j, optDouble2);
                }
                this.up.add(Keyframe.ofFloat(f6, optDouble));
                this.tl.add(Keyframe.ofFloat(f6, optDouble2));
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
    }
}
