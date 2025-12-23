package com.hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class j {

    /* renamed from: c, reason: collision with root package name */
    private static final Integer f32817c = new Integer(1);

    /* renamed from: d, reason: collision with root package name */
    private static final Integer f32818d = new Integer(2);

    /* renamed from: e, reason: collision with root package name */
    private static final Integer f32819e = new Integer(3);

    /* renamed from: f, reason: collision with root package name */
    private static final Integer f32820f = new Integer(4);

    /* renamed from: g, reason: collision with root package name */
    private static final Integer f32821g = new Integer(5);

    /* renamed from: h, reason: collision with root package name */
    private static final Integer f32822h = new Integer(6);

    /* renamed from: i, reason: collision with root package name */
    private static final Integer f32823i = new Integer(7);

    /* renamed from: j, reason: collision with root package name */
    private static final Integer f32824j = new Integer(8);

    /* renamed from: k, reason: collision with root package name */
    private static final Integer f32825k = new Integer(9);

    /* renamed from: l, reason: collision with root package name */
    private static final Integer f32826l = new Integer(10);

    /* renamed from: a, reason: collision with root package name */
    private final Vector f32827a = new Vector();

    /* renamed from: b, reason: collision with root package name */
    private Hashtable f32828b = new Hashtable();

    private static Integer c(i iVar) {
        return new Integer(System.identityHashCode(iVar));
    }

    void a(i iVar, int i6) {
        Integer num;
        this.f32827a.addElement(iVar);
        switch (i6) {
            case 1:
                num = f32817c;
                break;
            case 2:
                num = f32818d;
                break;
            case 3:
                num = f32819e;
                break;
            case 4:
                num = f32820f;
                break;
            case 5:
                num = f32821g;
                break;
            case 6:
                num = f32822h;
                break;
            case 7:
                num = f32823i;
                break;
            case 8:
                num = f32824j;
                break;
            case 9:
                num = f32825k;
                break;
            case 10:
                num = f32826l;
                break;
            default:
                num = new Integer(i6);
                break;
        }
        this.f32828b.put(c(iVar), num);
    }

    void b(String str) {
        this.f32827a.addElement(str);
    }

    Enumeration d() {
        return this.f32827a.elements();
    }

    int e(i iVar) {
        return ((Integer) this.f32828b.get(c(iVar))).intValue();
    }

    void f() {
        this.f32827a.removeAllElements();
        this.f32828b.clear();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration elements = this.f32827a.elements();
            while (elements.hasMoreElements()) {
                Object nextElement = elements.nextElement();
                if (nextElement instanceof String) {
                    stringBuffer.append("String(" + nextElement + ") ");
                } else {
                    i iVar = (i) nextElement;
                    stringBuffer.append("Node(" + iVar.q() + ")[" + this.f32828b.get(c(iVar)) + "] ");
                }
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        } catch (IOException e6) {
            return e6.toString();
        }
    }

    j() {
    }
}
