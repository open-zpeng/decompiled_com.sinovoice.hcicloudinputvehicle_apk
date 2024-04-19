package b.a.a.w.l;

import b.a.a.o;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class f extends JsonWriter {

    /* renamed from: a  reason: collision with root package name */
    private static final Writer f103a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final o f104b = new o("closed");
    private final List<b.a.a.j> c;
    private String d;
    private b.a.a.j e;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes.dex */
    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public f() {
        super(f103a);
        this.c = new ArrayList();
        this.e = b.a.a.l.f37a;
    }

    private b.a.a.j b() {
        List<b.a.a.j> list = this.c;
        return list.get(list.size() - 1);
    }

    private void c(b.a.a.j jVar) {
        if (this.d != null) {
            if (!jVar.e() || getSerializeNulls()) {
                ((b.a.a.m) b()).h(this.d, jVar);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = jVar;
        } else {
            b.a.a.j b2 = b();
            if (b2 instanceof b.a.a.g) {
                ((b.a.a.g) b2).h(jVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public b.a.a.j a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginArray() {
        b.a.a.g gVar = new b.a.a.g();
        c(gVar);
        this.c.add(gVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter beginObject() {
        b.a.a.m mVar = new b.a.a.m();
        c(mVar);
        this.c.add(mVar);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c.isEmpty()) {
            this.c.add(f104b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endArray() {
        if (!this.c.isEmpty() && this.d == null) {
            if (b() instanceof b.a.a.g) {
                List<b.a.a.j> list = this.c;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter endObject() {
        if (!this.c.isEmpty() && this.d == null) {
            if (b() instanceof b.a.a.m) {
                List<b.a.a.j> list = this.c;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter, java.io.Flushable
    public void flush() {
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter name(String str) {
        if (!this.c.isEmpty() && this.d == null) {
            if (b() instanceof b.a.a.m) {
                this.d = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter nullValue() {
        c(b.a.a.l.f37a);
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(String str) {
        if (str == null) {
            return nullValue();
        }
        c(new o(str));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(boolean z) {
        c(new o(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Boolean bool) {
        if (bool == null) {
            return nullValue();
        }
        c(new o(bool));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(double d) {
        if (!isLenient() && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
        }
        c(new o(Double.valueOf(d)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(long j) {
        c(new o(Long.valueOf(j)));
        return this;
    }

    @Override // com.google.gson.stream.JsonWriter
    public JsonWriter value(Number number) {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        c(new o(number));
        return this;
    }
}
