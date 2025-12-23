package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Properties;
import java.util.Vector;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.sasl.RealmCallback;
import javax.security.sasl.RealmChoiceCallback;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j implements s {

    /* renamed from: a, reason: collision with root package name */
    private h f39454a;

    /* renamed from: b, reason: collision with root package name */
    private String f39455b;

    /* renamed from: c, reason: collision with root package name */
    private Properties f39456c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39457d;

    /* renamed from: e, reason: collision with root package name */
    private PrintStream f39458e;

    /* renamed from: f, reason: collision with root package name */
    private String f39459f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements CallbackHandler {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ String f39461b;

        /* renamed from: c, reason: collision with root package name */
        private final /* synthetic */ String f39462c;

        /* renamed from: d, reason: collision with root package name */
        private final /* synthetic */ String f39463d;

        a(String str, String str2, String str3) {
            this.f39461b = str;
            this.f39462c = str2;
            this.f39463d = str3;
        }

        @Override // javax.security.auth.callback.CallbackHandler
        public void handle(Callback[] callbackArr) {
            if (j.this.f39457d) {
                PrintStream printStream = j.this.f39458e;
                int length = callbackArr.length;
                printStream.getClass();
            }
            for (int i6 = 0; i6 < callbackArr.length; i6++) {
                if (j.this.f39457d) {
                    PrintStream printStream2 = j.this.f39458e;
                    Objects.toString(callbackArr[i6]);
                    printStream2.getClass();
                }
                Callback callback = callbackArr[i6];
                if (callback instanceof NameCallback) {
                    ((NameCallback) callback).setName(this.f39461b);
                } else if (callback instanceof PasswordCallback) {
                    ((PasswordCallback) callback).setPassword(this.f39462c.toCharArray());
                } else if (callback instanceof RealmCallback) {
                    RealmCallback realmCallback = (RealmCallback) callback;
                    String str = this.f39463d;
                    if (str == null) {
                        str = realmCallback.getDefaultText();
                    }
                    realmCallback.setText(str);
                } else if (callback instanceof RealmChoiceCallback) {
                    RealmChoiceCallback realmChoiceCallback = (RealmChoiceCallback) callback;
                    if (this.f39463d == null) {
                        realmChoiceCallback.setSelectedIndex(realmChoiceCallback.getDefaultChoice());
                    } else {
                        String[] choices = realmChoiceCallback.getChoices();
                        int i7 = 0;
                        while (true) {
                            if (i7 < choices.length) {
                                if (choices[i7].equals(this.f39463d)) {
                                    realmChoiceCallback.setSelectedIndex(i7);
                                    break;
                                }
                                i7++;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.sun.mail.imap.protocol.s
    public boolean a(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        String str5;
        byte[] bArr;
        synchronized (this.f39454a) {
            try {
                Vector vector = new Vector();
                if (this.f39457d) {
                    this.f39458e.getClass();
                    for (String str6 : strArr) {
                        this.f39458e.getClass();
                    }
                    this.f39458e.getClass();
                }
                try {
                    SaslClient createSaslClient = Sasl.createSaslClient(strArr, str2, this.f39455b, this.f39459f, this.f39456c, new a(str3, str4, str));
                    if (createSaslClient == null) {
                        if (this.f39457d) {
                            this.f39458e.getClass();
                        }
                        return false;
                    }
                    if (this.f39457d) {
                        PrintStream printStream = this.f39458e;
                        createSaslClient.getMechanismName();
                        printStream.getClass();
                    }
                    try {
                        String q5 = this.f39454a.q("AUTHENTICATE " + createSaslClient.getMechanismName(), null);
                        OutputStream b02 = this.f39454a.b0();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr2 = {13, 10};
                        boolean equals = createSaslClient.getMechanismName().equals("XGWTRUSTEDAPP");
                        com.sun.mail.iap.g gVar = null;
                        boolean z5 = false;
                        while (!z5) {
                            try {
                                gVar = this.f39454a.l();
                            } catch (Exception e6) {
                                if (this.f39457d) {
                                    e6.printStackTrace();
                                }
                                gVar = com.sun.mail.iap.g.a(e6);
                            }
                            if (gVar.f()) {
                                if (createSaslClient.isComplete()) {
                                    bArr = null;
                                } else {
                                    byte[] c6 = gVar.s().c();
                                    if (c6.length > 0) {
                                        c6 = BASE64DecoderStream.decode(c6);
                                    }
                                    if (this.f39457d) {
                                        PrintStream printStream2 = this.f39458e;
                                        ASCIIUtility.toString(c6, 0, c6.length);
                                        printStream2.getClass();
                                    }
                                    bArr = createSaslClient.evaluateChallenge(c6);
                                }
                                if (bArr == null) {
                                    if (this.f39457d) {
                                        this.f39458e.getClass();
                                    }
                                    b02.write(bArr2);
                                    b02.flush();
                                    byteArrayOutputStream.reset();
                                } else {
                                    if (this.f39457d) {
                                        PrintStream printStream3 = this.f39458e;
                                        ASCIIUtility.toString(bArr, 0, bArr.length);
                                        printStream3.getClass();
                                    }
                                    byte[] encode = BASE64EncoderStream.encode(bArr);
                                    if (equals) {
                                        byteArrayOutputStream.write("XGWTRUSTEDAPP ".getBytes());
                                    }
                                    byteArrayOutputStream.write(encode);
                                    byteArrayOutputStream.write(bArr2);
                                    b02.write(byteArrayOutputStream.toByteArray());
                                    b02.flush();
                                    byteArrayOutputStream.reset();
                                }
                            } else {
                                if ((!gVar.j() || !gVar.c().equals(q5)) && !gVar.e()) {
                                    vector.addElement(gVar);
                                }
                                z5 = true;
                            }
                        }
                        if (createSaslClient.isComplete() && (str5 = (String) createSaslClient.getNegotiatedProperty("javax.security.sasl.qop")) != null && (str5.equalsIgnoreCase("auth-int") || str5.equalsIgnoreCase("auth-conf"))) {
                            if (this.f39457d) {
                                this.f39458e.getClass();
                            }
                            return false;
                        }
                        com.sun.mail.iap.g[] gVarArr = new com.sun.mail.iap.g[vector.size()];
                        vector.copyInto(gVarArr);
                        this.f39454a.j(gVarArr);
                        this.f39454a.h(gVar);
                        this.f39454a.H0(gVar);
                        return true;
                    } catch (Exception e7) {
                        if (this.f39457d) {
                            PrintStream printStream4 = this.f39458e;
                            e7.toString();
                            printStream4.getClass();
                        }
                        return false;
                    }
                } catch (SaslException e8) {
                    if (this.f39457d) {
                        PrintStream printStream5 = this.f39458e;
                        e8.toString();
                        printStream5.getClass();
                    }
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j(h hVar, String str, Properties properties, boolean z5, PrintStream printStream, String str2) {
        this.f39454a = hVar;
        this.f39455b = str;
        this.f39456c = properties;
        this.f39457d = z5;
        this.f39458e = printStream;
        this.f39459f = str2;
    }
}
