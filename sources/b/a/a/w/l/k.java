package b.a.a.w.l;

import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes.dex */
public final class k extends t<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f120a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f121b = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
            if (aVar.c() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    @Override // b.a.a.t
    /* renamed from: e */
    public synchronized Time b(JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Time(this.f121b.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e) {
            throw new r(e);
        }
    }

    @Override // b.a.a.t
    /* renamed from: f */
    public synchronized void d(JsonWriter jsonWriter, Time time) {
        jsonWriter.value(time == null ? null : this.f121b.format((Date) time));
    }
}
