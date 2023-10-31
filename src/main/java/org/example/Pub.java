package org.example;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.driver.MediaDriver;
import org.agrona.BufferUtil;
import org.agrona.CloseHelper;
import org.agrona.concurrent.UnsafeBuffer;
import java.util.concurrent.TimeUnit;
import io.aeron.samples.SampleConfiguration;
public class Pub {
    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;

}
