package com.beizi.fusion.sm.b.a;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements com.beizi.fusion.sm.b.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13508a;

    /* renamed from: b, reason: collision with root package name */
    private final KeyguardManager f13509b;

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f13508a == null || (keyguardManager = this.f13509b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.f13509b, null);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
            return false;
        }
    }

    public c(Context context) {
        this.f13508a = context;
        this.f13509b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f13508a == null || bVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f13509b;
        if (keyguardManager == null) {
            bVar.a(new com.beizi.fusion.sm.b.d("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.f13509b, null);
            if (invoke != null) {
                String obj = invoke.toString();
                com.beizi.fusion.sm.b.e.a("OAID obtain success: " + obj);
                bVar.a(obj);
                return;
            }
            throw new com.beizi.fusion.sm.b.d("OAID obtain failed");
        } catch (Exception e6) {
            com.beizi.fusion.sm.b.e.a(e6);
        }
    }
}
