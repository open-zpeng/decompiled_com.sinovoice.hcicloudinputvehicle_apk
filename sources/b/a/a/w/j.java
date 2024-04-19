package b.a.a.w;

import b.a.a.l;
import b.a.a.r;
import b.a.a.w.l.n;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class j {
    public static b.a.a.j a(JsonReader jsonReader) {
        boolean z;
        try {
            try {
                jsonReader.peek();
                z = false;
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                return n.X.b(jsonReader);
            } catch (EOFException e2) {
                e = e2;
                if (z) {
                    return l.f37a;
                }
                throw new r(e);
            }
        } catch (MalformedJsonException e3) {
            throw new r(e3);
        } catch (IOException e4) {
            throw new b.a.a.k(e4);
        } catch (NumberFormatException e5) {
            throw new r(e5);
        }
    }

    public static void b(b.a.a.j jVar, JsonWriter jsonWriter) {
        n.X.d(jsonWriter, jVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* compiled from: Streams.java */
    /* loaded from: classes.dex */
    private static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f85a;

        /* renamed from: b  reason: collision with root package name */
        private final C0009a f86b = new C0009a();

        /* compiled from: Streams.java */
        /* renamed from: b.a.a.w.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0009a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f87a;

            C0009a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.f87a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f87a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.f87a, i, i2 - i);
            }
        }

        a(Appendable appendable) {
            this.f85a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            C0009a c0009a = this.f86b;
            c0009a.f87a = cArr;
            this.f85a.append(c0009a, i, i2 + i);
        }

        @Override // java.io.Writer
        public void write(int i) {
            this.f85a.append((char) i);
        }
    }
}
