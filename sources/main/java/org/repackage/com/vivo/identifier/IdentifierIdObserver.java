package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class IdentifierIdObserver extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51669a = "VMS_SDK_Observer";

    /* renamed from: b, reason: collision with root package name */
    private String f51670b;

    /* renamed from: c, reason: collision with root package name */
    private int f51671c;

    /* renamed from: d, reason: collision with root package name */
    private IdentifierIdClient f51672d;

    IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i6, String str) {
        super(null);
        this.f51672d = identifierIdClient;
        this.f51671c = i6;
        this.f51670b = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z5) {
        IdentifierIdClient identifierIdClient = this.f51672d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.f51671c, this.f51670b);
        }
    }
}
