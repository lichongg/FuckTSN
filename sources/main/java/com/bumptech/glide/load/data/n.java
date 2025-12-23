package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class n extends l<InputStream> {

    /* renamed from: e, reason: collision with root package name */
    private static final int f14977e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final int f14978f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static final int f14979g = 3;

    /* renamed from: h, reason: collision with root package name */
    private static final int f14980h = 4;

    /* renamed from: i, reason: collision with root package name */
    private static final int f14981i = 5;

    /* renamed from: j, reason: collision with root package name */
    private static final UriMatcher f14982j;

    private InputStream i(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f14982j = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    private InputStream h(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f14982j.match(uri);
        if (match != 1) {
            if (match == 3) {
                return i(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return i(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.l
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.l
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public InputStream e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream h6 = h(uri, contentResolver);
        if (h6 != null) {
            return h6;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }
}
