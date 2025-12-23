package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends org.apache.commons.net.ftp.g {

    /* renamed from: c, reason: collision with root package name */
    private final org.apache.commons.net.ftp.f[] f50729c;

    /* renamed from: d, reason: collision with root package name */
    private org.apache.commons.net.ftp.f f50730d = null;

    @Override // org.apache.commons.net.ftp.f
    public FTPFile a(String str) {
        org.apache.commons.net.ftp.f fVar = this.f50730d;
        if (fVar != null) {
            FTPFile a6 = fVar.a(str);
            if (a6 != null) {
                return a6;
            }
            return null;
        }
        for (org.apache.commons.net.ftp.f fVar2 : this.f50729c) {
            FTPFile a7 = fVar2.a(str);
            if (a7 != null) {
                this.f50730d = fVar2;
                return a7;
            }
        }
        return null;
    }

    public a(org.apache.commons.net.ftp.f[] fVarArr) {
        this.f50729c = fVarArr;
    }
}
