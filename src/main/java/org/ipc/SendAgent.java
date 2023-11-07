package org.ipc;

import io.aeron.Publication;
import io.aeron.driver.MediaDriver;
import org.agrona.concurrent.UnsafeBuffer;
import org.example.Pub;

import java.nio.ByteBuffer;
import java.util.logging.Logger;

public class SendAgent {
    private final Publication publication;
    private final int sendCount;
    private final UnsafeBuffer unsafeBuffer;
    private int currentCountItem = 1;
//    private final Logger logger = LoggerFactory.getLogger(SendAgent.class)
    public SendAgent(final Publication publication, int sendCount){
        this.publication = publication;
        this.sendCount = sendCount;
        this.unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocate(64));
        unsafeBuffer.putInt(0, currentCountItem);
    }
//    @Override
}
