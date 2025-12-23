package com.baidu.liantian.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Pair;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface FI {
    byte[] ad(byte[] bArr, byte[] bArr2);

    byte[] ae(byte[] bArr, byte[] bArr2);

    boolean chh(Context context, String str);

    void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr);

    Pair<Integer, Object> cmsi(int i6, String str, Class<?>[] clsArr, Object... objArr);

    Map<Integer, String> gpd();

    String gs(String str);

    String p(String str);

    void r(String str, IntentFilter intentFilter, String str2, String str3);

    byte[] rd(byte[] bArr, byte[] bArr2);

    byte[] re(byte[] bArr, byte[] bArr2);

    void rf(Context context);

    void s(int i6, boolean z5);

    void sp(String str, boolean z5);

    void u(String str);

    void ur(String str, IntentFilter intentFilter, String str2, String str3);
}
