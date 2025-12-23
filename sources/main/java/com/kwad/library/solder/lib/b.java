package com.kwad.library.solder.lib;

import com.kwad.library.solder.lib.a.a;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b<P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> implements com.kwad.library.solder.lib.ext.b<P, R> {
    com.kwad.library.solder.lib.ext.b<P, R> aql;
    com.kwad.library.solder.lib.ext.b<P, R> aqm;

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r5, P p5) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.a((com.kwad.library.solder.lib.ext.b<P, R>) r5, (R) p5);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void b(R r5) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.b(r5);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void c(R r5) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.c(r5);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void d(R r5) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.d(r5);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void e(R r5) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.e(r5);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void f(R r5) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.f(r5);
        }
    }

    public b(com.kwad.library.solder.lib.ext.b<P, R> bVar, com.kwad.library.solder.lib.ext.b<P, R> bVar2) {
        this.aql = bVar;
        this.aqm = bVar2;
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public void a(R r5, PluginError pluginError) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.a((com.kwad.library.solder.lib.ext.b<P, R>) r5, pluginError);
        }
        com.kwad.library.solder.lib.ext.b<P, R> bVar2 = this.aqm;
        if (bVar2 != null) {
            bVar2.a((com.kwad.library.solder.lib.ext.b<P, R>) r5, pluginError);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r5) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.a(r5);
        }
    }
}
