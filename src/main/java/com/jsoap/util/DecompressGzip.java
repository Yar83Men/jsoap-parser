package com.jsoap.util;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.util.zip.GZIPInputStream;

import static java.util.Objects.isNull;
import static org.apache.commons.io.Charsets.UTF_8;

public class DecompressGzip {
    public static String decompress(final byte[] compressed) {
        if (isNull(compressed) || compressed.length == 0) {
            return null;
        }
        try (final GZIPInputStream gzipInput = new GZIPInputStream(new ByteArrayInputStream(compressed));
             final StringWriter stringWriter = new StringWriter()) {
            IOUtils.copy(gzipInput, stringWriter, UTF_8);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new UncheckedIOException("Ошибка при распаковке сжатых данных!", e);
        }
    }
}
