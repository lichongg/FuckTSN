package com.beizi.fusion.model;

import android.content.Context;
import android.os.Debug;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.p;
import com.beizi.fusion.tool.q;
import com.beizi.fusion.tool.x;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EnvInfo {
    private String developerMode;
    private String isDebugApk;
    private String isLockScreen;
    private String isSimulator;
    private String isUsb;
    private String isWifiProxy;
    private String isp;

    /* renamed from: net, reason: collision with root package name */
    private String f13502net;
    private String userAgent;
    private String isDebugConnected = String.valueOf(Debug.isDebuggerConnected());
    private String isVpn = String.valueOf(ap.b());

    public String getIsp() {
        return this.isp;
    }

    public String getNet() {
        return this.f13502net;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String isDeveloperMode() {
        return this.developerMode;
    }

    public String isIsDebugApk() {
        return this.isDebugApk;
    }

    public String isIsDebugConnected() {
        return this.isDebugConnected;
    }

    public String isIsLockScreen() {
        return this.isLockScreen;
    }

    public String isIsSimulator() {
        return this.isSimulator;
    }

    public String isIsUsb() {
        return this.isUsb;
    }

    public String isIsVpn() {
        return this.isVpn;
    }

    public String isIsWifiProxy() {
        return this.isWifiProxy;
    }

    public void setDeveloperMode(String str) {
        this.developerMode = str;
    }

    public void setIsDebugApk(String str) {
        this.isDebugApk = str;
    }

    public void setIsDebugConnected(String str) {
        this.isDebugConnected = str;
    }

    public void setIsLockScreen(String str) {
        this.isLockScreen = str;
    }

    public void setIsSimulator(String str) {
        this.isSimulator = str;
    }

    public void setIsUsb(String str) {
        this.isUsb = str;
    }

    public void setIsVpn(String str) {
        this.isVpn = str;
    }

    public void setIsWifiProxy(String str) {
        this.isWifiProxy = str;
    }

    public void setIsp(String str) {
        this.isp = str;
    }

    public void setNet(String str) {
        this.f13502net = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public EnvInfo(Context context) {
        this.userAgent = x.a().a(context);
        this.f13502net = String.valueOf(p.b(context));
        this.isp = String.valueOf(p.a(context));
        this.developerMode = String.valueOf(ap.g(context));
        this.isDebugApk = String.valueOf(ap.f(context));
        this.isWifiProxy = String.valueOf(ap.h(context));
        this.isSimulator = String.valueOf(q.a().a(context));
    }
}
