package org.apache.commons.net.smtp;

import java.util.Enumeration;
import java.util.Vector;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    Vector<String> f51018a = new Vector<>();

    /* renamed from: b, reason: collision with root package name */
    String f51019b;

    public void a(String str) {
        this.f51018a.addElement(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(v0.f47961e);
        Enumeration<String> elements = this.f51018a.elements();
        if (elements.hasMoreElements()) {
            sb.append('@');
            sb.append(elements.nextElement());
            while (elements.hasMoreElements()) {
                sb.append(",@");
                sb.append(elements.nextElement());
            }
            sb.append(':');
        }
        sb.append(this.f51019b);
        sb.append(v0.f47962f);
        return sb.toString();
    }

    public a(String str) {
        this.f51019b = str;
    }
}
