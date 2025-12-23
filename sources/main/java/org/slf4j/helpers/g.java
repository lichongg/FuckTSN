package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class g implements org.slf4j.c, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    @Override // org.slf4j.c
    public String getName() {
        return this.name;
    }

    g() {
    }

    protected Object readResolve() throws ObjectStreamException {
        return org.slf4j.d.j(getName());
    }
}
