package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q4 extends b4<InputtipsQuery, ArrayList<Tip>> {
    private static ArrayList<Tip> U(String str) throws AMapException {
        try {
            return r4.u0(new JSONObject(str));
        } catch (JSONException e6) {
            j4.i(e6, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String i6 = b4.i(((InputtipsQuery) this.f7863n).getKeyword());
        if (!TextUtils.isEmpty(i6)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(i6);
        }
        String city = ((InputtipsQuery) this.f7863n).getCity();
        if (!r4.s0(city)) {
            String i7 = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(i7);
        }
        String type = ((InputtipsQuery) this.f7863n).getType();
        if (!r4.s0(type)) {
            String i8 = b4.i(type);
            stringBuffer.append("&type=");
            stringBuffer.append(i8);
        }
        if (((InputtipsQuery) this.f7863n).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.f7863n).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(x0.i(this.f7866q));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/assistant/inputtips?";
    }

    public q4(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }
}
