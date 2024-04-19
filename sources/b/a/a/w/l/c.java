package b.a.a.w.l;

import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
/* compiled from: DateTypeAdapter.java */
/* loaded from: classes.dex */
public final class c extends t<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f98a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f99b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);

    /* compiled from: DateTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    private synchronized Date e(String str) {
        try {
            try {
                try {
                } catch (ParseException e) {
                    throw new r(str, e);
                }
            } catch (ParseException unused) {
                return b.a.a.w.l.o.a.c(str, new ParsePosition(0));
            }
        } catch (ParseException unused2) {
            return this.f99b.parse(str);
        }
        return this.c.parse(str);
    }

    @Override // b.a.a.t
    /* renamed from: f */
    public Date b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return e(jsonReader.nextString());
    }

    @Override // b.a.a.t
    /* renamed from: g */
    public synchronized void d(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(this.f99b.format(date));
        }
    }
}
