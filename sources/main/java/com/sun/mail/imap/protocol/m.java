package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m {

    /* renamed from: g, reason: collision with root package name */
    public static final int f39469g = 1;

    /* renamed from: h, reason: collision with root package name */
    public static final int f39470h = 2;

    /* renamed from: i, reason: collision with root package name */
    public static final int f39471i = 3;

    /* renamed from: a, reason: collision with root package name */
    public String f39472a;

    /* renamed from: b, reason: collision with root package name */
    public char f39473b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39474c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39475d;

    /* renamed from: e, reason: collision with root package name */
    public int f39476e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f39477f;

    public m(i iVar) throws ParsingException {
        this.f39472a = null;
        this.f39473b = '/';
        this.f39474c = true;
        this.f39475d = true;
        this.f39476e = 3;
        String[] H = iVar.H();
        Vector vector = new Vector();
        if (H != null) {
            for (int i6 = 0; i6 < H.length; i6++) {
                if (H[i6].equalsIgnoreCase("\\Marked")) {
                    this.f39476e = 1;
                } else if (H[i6].equalsIgnoreCase("\\Unmarked")) {
                    this.f39476e = 2;
                } else if (H[i6].equalsIgnoreCase("\\Noselect")) {
                    this.f39475d = false;
                } else if (H[i6].equalsIgnoreCase("\\Noinferiors")) {
                    this.f39474c = false;
                }
                vector.addElement(H[i6]);
            }
        }
        String[] strArr = new String[vector.size()];
        this.f39477f = strArr;
        vector.copyInto(strArr);
        iVar.B();
        if (iVar.r() == 34) {
            char r5 = (char) iVar.r();
            this.f39473b = r5;
            if (r5 == '\\') {
                this.f39473b = (char) iVar.r();
            }
            iVar.A(1);
        } else {
            iVar.A(2);
        }
        iVar.B();
        String q5 = iVar.q();
        this.f39472a = q5;
        this.f39472a = a.b(q5);
    }
}
