package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e0 extends f0<WeatherSearchQuery, LocalWeatherLive> {

    /* renamed from: t, reason: collision with root package name */
    private LocalWeatherLive f8042t;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.f7863n).getCity();
        if (!r4.s0(city)) {
            String i6 = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(i6);
        }
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + x0.i(this.f7866q));
        return stringBuffer.toString();
    }

    public e0(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
        this.f8042t = new LocalWeatherLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public LocalWeatherLive I(String str) throws AMapException {
        LocalWeatherLive l02 = r4.l0(str);
        this.f8042t = l02;
        return l02;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.amap.api.services.weather.WeatherSearchQuery, java.lang.Object] */
    @Override // com.amap.api.col.s.f0
    public final /* bridge */ /* synthetic */ WeatherSearchQuery U() {
        return super.U();
    }

    @Override // com.amap.api.col.s.f0, com.amap.api.col.s.dz
    public final /* bridge */ /* synthetic */ String h() {
        return super.h();
    }
}
