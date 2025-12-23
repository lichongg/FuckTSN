package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.c;
import com.baidu.mobads.sdk.internal.f;
import com.baidu.mobads.sdk.internal.u;
import dalvik.system.DexClassLoader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Route(path = c.a.f10833a)
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdservRemoteLoaderImpl implements u {
    @Override // com.baidu.mobads.sdk.internal.u
    public DexClassLoader getClassLoaderFromJar(String str, String str2, String str3, ClassLoader classLoader) {
        return f.a().a(str, str2, str3, classLoader);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void startLoadRemotePhp(double d6, an.b bVar) {
        f.a().a(d6, bVar);
    }
}
