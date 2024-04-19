package b.a.a.w.l;

import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class j extends t<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f118a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f119b = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            if (aVar.c() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // b.a.a.t
    /* renamed from: e */
    public synchronized Date b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Date(this.f119b.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e) {
            throw new r(e);
        }
    }

    @Override // b.a.a.t
    /* renamed from: f */
    public synchronized void d(JsonWriter jsonWriter, Date date) {
        jsonWriter.value(date == null ? null : this.f119b.format((java.util.Date) date));
    }
}
