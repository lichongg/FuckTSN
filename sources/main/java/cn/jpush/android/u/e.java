package cn.jpush.android.u;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.ad.g;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.b;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class e extends b {

    /* renamed from: f, reason: collision with root package name */
    protected View f3874f;

    private void d(int i6) {
        a(i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? i6 != 5 ? -1L : 4013L : 4014L : 4012L : 4011L : master.flame.danmaku.danmaku.model.android.d.f50003r);
    }

    private int e(int i6) {
        if (i6 != 2) {
            return i6 != 3 ? 17 : 5;
        }
        return 3;
    }

    public View a(String str) {
        int identifier = this.f3845d.getResources().getIdentifier(str, ResIdentify.RES_TYPE_LAYOUT, this.f3845d.getPackageName());
        if (identifier <= 0) {
            throw new IllegalArgumentException("\"" + str + ".xml\" not found,please check res-layout file!!");
        }
        View inflate = LayoutInflater.from(this.f3845d).inflate(identifier, (ViewGroup) null);
        if (inflate != null) {
            return inflate;
        }
        throw new IllegalArgumentException("\"" + str + ".xml\" not found,please check res-layout file!!");
    }

    protected abstract void a();

    public final <T extends View> T b(String str) {
        int identifier = this.f3845d.getResources().getIdentifier(str, "id", this.f3845d.getPackageName());
        if (identifier <= 0) {
            throw new IllegalArgumentException("view id=\"" + str + "\" not found, check layout.xml or not confused keep it");
        }
        T t5 = (T) this.f3874f.findViewById(identifier);
        if (t5 != null) {
            return t5;
        }
        throw new IllegalArgumentException("view id=\"" + str + "\" not found, check layout.xml or not confused keep it");
    }

    protected abstract String b();

    protected void a(int i6, String str, int i7) {
        String str2;
        if (i6 == 1 || i6 == 2) {
            cn.jpush.android.k.a.a(this.f3845d, this.f3843b);
            str2 = str;
            a(i6, g.a().a(this.f3845d, -1, str2, (String) null, (String) null));
        } else {
            str2 = str;
        }
        cn.jpush.android.x.b.a(this.f3845d, JPushInterface.ACTION_IN_APP_MSG_CLICK, this.f3843b, (Intent) null, str2);
        b.a aVar = this.f3842a;
        if (aVar != null) {
            aVar.a(this.f3845d, e(), this.f3843b);
        }
        d(i7);
    }

    @Override // cn.jpush.android.u.b
    public View e() {
        return this.f3874f;
    }

    @Override // cn.jpush.android.u.b
    public boolean f() {
        long j6;
        try {
            this.f3874f = a(b());
            try {
                a();
                return true;
            } catch (Throwable th) {
                Logger.ke("BaseInAppWrapper", "findViewByName throwable =" + th.getMessage());
                j6 = 3014;
                a(j6);
                return false;
            }
        } catch (Throwable th2) {
            Logger.ke("BaseInAppWrapper", "inflateLayout throwable " + th2.getMessage());
            j6 = 3013;
        }
    }

    public e(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i6) {
        super(context, aVar, dVar, i6);
    }

    private void a(int i6, boolean z5) {
        a(i6 != 1 ? i6 != 2 ? -1L : z5 ? 4002L : 4001L : z5 ? 4004L : 4003L);
    }

    private void a(long j6) {
        Logger.d("BaseInAppWrapper", "report code=" + j6);
        if (j6 > 0) {
            cn.jpush.android.helper.c.a(this.f3845d, this.f3843b.f3588d, j6, 4);
        }
    }

    protected void a(ImageView imageView, String str, JSONObject jSONObject, final int i6, int i7, int i8) {
        try {
            if (!TextUtils.isEmpty(str)) {
                imageView.setImageBitmap(cn.jpush.android.ad.e.a(str, i7, i8));
            }
            if (jSONObject != null) {
                final int optInt = jSONObject.optInt("type");
                final String optString = jSONObject.optString(com.umeng.ccg.a.f41544t);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.a(optInt, optString, i6);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "native updateImage throwable=" + th);
        }
    }

    protected void a(TextView textView) {
        String charSequence = textView.getText().toString();
        int b6 = m.b(charSequence);
        if (b6 <= 1) {
            this.f3842a.a(this.f3845d, this.f3874f, this.f3843b);
            return;
        }
        textView.setText(charSequence.replace("" + b6, "" + (b6 - 1)));
    }

    protected void a(TextView textView, JSONObject jSONObject, final int i6) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            String optString = jSONObject.optString(com.baidu.mobads.sdk.internal.a.f10501b);
            if (jSONObject.has("duration")) {
                textView.setText((jSONObject.optInt("duration") / 1000) + "s" + optString);
            } else {
                textView.setText(optString);
            }
            if (jSONObject.has(ResIdentify.RES_TYPE_STYLE) && (optJSONArray = jSONObject.optJSONArray(ResIdentify.RES_TYPE_STYLE)) != null && optJSONArray.length() == 4) {
                if (optJSONArray.optInt(0) == 1) {
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                }
                int optInt = optJSONArray.optInt(1);
                if (optInt > 0) {
                    textView.setTextSize(optInt);
                }
                int optInt2 = optJSONArray.optInt(2);
                if (optInt2 > 0) {
                    textView.setGravity(e(optInt2));
                }
                String optString2 = optJSONArray.optString(3);
                if (!TextUtils.isEmpty(optString2) && optString2.startsWith("#")) {
                    textView.setTextColor(Color.parseColor(optString2));
                }
            }
            if (jSONObject.has(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK) && (optJSONObject = jSONObject.optJSONObject(AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK)) != null) {
                final int optInt3 = optJSONObject.optInt("type");
                final String optString3 = optJSONObject.optString(com.umeng.ccg.a.f41544t);
                textView.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.a(optInt3, optString3, i6);
                    }
                });
            }
            if (jSONObject.has("bg_color")) {
                String optString4 = jSONObject.optString("bg_color");
                if (TextUtils.isEmpty(optString4) || !optString4.startsWith("#")) {
                    return;
                }
                ((GradientDrawable) textView.getBackground()).setColor(Color.parseColor(optString4));
            }
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "native updateTextView throwable=" + th);
        }
    }

    @Override // cn.jpush.android.u.b
    public void g() {
    }
}
