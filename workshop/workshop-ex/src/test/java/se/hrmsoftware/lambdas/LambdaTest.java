package se.hrmsoftware.lambdas;

import se.hrmsoftware.model.PersonRepository;
import se.hrmsoftware.model.Worker;

import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LambdaTest {

    @Test
    public void testLambda1() {
        PrintStream original = System.out;
        try {
            PrintStreamer p = new PrintStreamer(original);
            System.setOut(p);
            Lambda l = new Lambda();
            l.test1();

            String data = p.getAndClearBuffer();
            String correct = "89;35;";
            assertEquals("Not equal", correct, data);

        } finally {
            System.setOut(original);
        }
    }


    @Test
    public void testWorker() {
        PrintStream original = System.out;
        try {
            PrintStreamer stream = new PrintStreamer(original);
            System.setOut(stream);
            Lambda l = new Lambda();

            Worker w = l.workOnPersons();
            PersonRepository repo = new PersonRepository();

            repo.getPersons().forEach((p) -> {
                w.onEvent(p);
                String out = stream.getAndClearBuffer();
                String cmp = p.getName() + "(" + p.getAge() + ")";
                assertTrue(">" + cmp + "< is not contained within >" + out + "<", out.contains(cmp));
                assertTrue(">" + p.getEmail() + "< is not contained within >" + out + "<",
                        out.contains(p.getEmail()));
            });

        } finally {
            System.setOut(original);
        }
    }


    /**
     * A little capturer for prints to the output stream.
     */
    private static class PrintStreamer extends PrintStream {

        private StringBuilder buffer = new StringBuilder();

        public PrintStreamer(final OutputStream out) {
            super(out);
        }

        @Override
        public void println(final String x) {
            super.println(x);
        }

        @Override
        public void print(final boolean b) {
            super.print(b);
            buffer.append(b);
        }

        @Override
        public void print(final char c) {
            super.print(c);
            buffer.append(c);
        }

        @Override
        public void print(final int i) {
            super.print(i);
            buffer.append(i);
        }

        @Override
        public void print(final long l) {
            super.print(l);
            buffer.append(l);
        }

        @Override
        public void print(final float f) {
            super.print(f);
            buffer.append(f);
        }

        @Override
        public void print(final double d) {
            super.print(d);
            buffer.append(d);
        }

        @Override
        public void print(final char[] s) {
            super.print(s);
            buffer.append(s);
        }

        @Override
        public void print(final String s) {
            super.print(s);
            buffer.append(s);
        }

        @Override
        public void print(final Object obj) {
            super.print(obj);
            buffer.append(obj);
        }

        @Override
        public void println() {
            super.println();
            buffer.append("\n");
        }

        @Override
        public void println(final boolean x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        @Override
        public void println(final char x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        @Override
        public void println(final int x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        @Override
        public void println(final long x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        @Override
        public void println(final float x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        @Override
        public void println(final double x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        @Override
        public void println(final char[] x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        @Override
        public void println(final Object x) {
            super.println(x);
            buffer.append(x).append("\n");
        }

        protected String getAndClearBuffer() {
            String b = buffer.toString();
            buffer = new StringBuilder();
            return b;
        }
    }
}