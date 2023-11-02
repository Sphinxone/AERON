package org.ipc;

import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import org.agrona.concurrent.BusySpinIdleStrategy;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.ShutdownSignalBarrier;

import javax.print.attribute.standard.Media;

public class StartHere {
    final String channel = "aeron:ipc";
    final int stream = 10;
    final int sendCount = 1_000_000;
    final IdleStrategy idleStrategySend = new BusySpinIdleStrategy();
    final IdleStrategy idleStrategyReceive = new BusySpinIdleStrategy();
    final ShutdownSignalBarrier barrier = new ShutdownSignalBarrier();

    final MediaDriver.Context mediaDriverCtx = new MediaDriver.Context()
            .dirDeleteOnStart(true)
            .threadingMode(ThreadingMode.SHARED)
            .sharedIdleStrategy(new BusySpinIdleStrategy())
            .dirDeleteOnShutdown(true);
    final MediaDriver mediaDriver = MediaDriver.launchEmbedded(mediaDriverCtx);

    final Aeron.Context aeronCtx = new Aeron.Context()
            .aeronDirectoryName(mediaDriver.aeronDirectoryName());
    final Aeron aeron = Aeron.connect(aeronCtx);

    final Subscription subscription = aeron.addSubscription(channel, stream);
    final Publication publication = aeron.addPublication(channel, stream);

//    final SendAgent sendAgent
}
