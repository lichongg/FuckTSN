package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cr;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class Response implements br<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, cd> metaDataMap;
    private static final Map<Class<? extends cy>, cz> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final cv STRUCT_DESC = new cv("Response");
    private static final cl RESP_CODE_FIELD_DESC = new cl("resp_code", (byte) 8, 1);
    private static final cl MSG_FIELD_DESC = new cl("msg", (byte) 11, 2);
    private static final cl IMPRINT_FIELD_DESC = new cl(bi.X, (byte) 12, 3);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends da<Response> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(cq cqVar, Response response) throws bx {
            cqVar.j();
            while (true) {
                cl l6 = cqVar.l();
                byte b6 = l6.f41141b;
                if (b6 == 0) {
                    break;
                }
                short s5 = l6.f41142c;
                if (s5 != 1) {
                    if (s5 != 2) {
                        if (s5 != 3) {
                            ct.a(cqVar, b6);
                        } else if (b6 == 12) {
                            com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint = dVar;
                            dVar.read(cqVar);
                            response.setImprintIsSet(true);
                        } else {
                            ct.a(cqVar, b6);
                        }
                    } else if (b6 == 11) {
                        response.msg = cqVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        ct.a(cqVar, b6);
                    }
                } else if (b6 == 8) {
                    response.resp_code = cqVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    ct.a(cqVar, b6);
                }
                cqVar.m();
            }
            cqVar.k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new cr("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(cq cqVar, Response response) throws bx {
            response.validate();
            cqVar.a(Response.STRUCT_DESC);
            cqVar.a(Response.RESP_CODE_FIELD_DESC);
            cqVar.a(response.resp_code);
            cqVar.c();
            if (response.msg != null && response.isSetMsg()) {
                cqVar.a(Response.MSG_FIELD_DESC);
                cqVar.a(response.msg);
                cqVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                cqVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(cqVar);
                cqVar.c();
            }
            cqVar.d();
            cqVar.b();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements cz {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends db<Response> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, Response response) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            cwVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                cwVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(cwVar);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, Response response) throws bx {
            cw cwVar = (cw) cqVar;
            response.resp_code = cwVar.w();
            response.setResp_codeIsSet(true);
            BitSet b6 = cwVar.b(2);
            if (b6.get(0)) {
                response.msg = cwVar.z();
                response.setMsgIsSet(true);
            }
            if (b6.get(1)) {
                com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint = dVar;
                dVar.read(cwVar);
                response.setImprintIsSet(true);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d implements cz {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c(null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum e implements by {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, bi.X);


        /* renamed from: d, reason: collision with root package name */
        private static final Map<String, e> f41985d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f41987e;

        /* renamed from: f, reason: collision with root package name */
        private final String f41988f;

        public static e a(int i6) {
            if (i6 == 1) {
                return RESP_CODE;
            }
            if (i6 == 2) {
                return MSG;
            }
            if (i6 != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static e b(int i6) {
            e a6 = a(i6);
            if (a6 != null) {
                return a6;
            }
            throw new IllegalArgumentException("Field " + i6 + " doesn't exist!");
        }

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f41985d.put(eVar.b(), eVar);
            }
        }

        e(short s5, String str) {
            this.f41987e = s5;
            this.f41988f = str;
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f41988f;
        }

        public static e a(String str) {
            return f41985d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f41987e;
        }
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        AnonymousClass1 anonymousClass1 = null;
        hashMap.put(da.class, new b(anonymousClass1));
        hashMap.put(db.class, new d(anonymousClass1));
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.RESP_CODE, (e) new cd("resp_code", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.MSG, (e) new cd("msg", (byte) 2, new ce((byte) 11)));
        enumMap.put((EnumMap) e.IMPRINT, (e) new cd(bi.X, (byte) 2, new ci((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        cd.a(Response.class, unmodifiableMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e6) {
            throw new IOException(e6.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.br
    public br<Response, e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.br
    public e fieldForId(int i6) {
        return e.a(i6);
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return bo.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        schemes.get(cqVar.D()).b().b(cqVar, this);
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z5) {
        if (z5) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z5) {
        if (z5) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i6) {
        this.resp_code = i6;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z5) {
        this.__isset_bitfield = bo.a(this.__isset_bitfield, 0, z5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetResp_code() {
        this.__isset_bitfield = bo.b(this.__isset_bitfield, 0);
    }

    public void validate() throws bx {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        schemes.get(cqVar.D()).b().a(cqVar, this);
    }

    public Response(int i6) {
        this();
        this.resp_code = i6;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }
}
