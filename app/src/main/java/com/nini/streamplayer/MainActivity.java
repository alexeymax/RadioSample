package com.nini.streamplayer;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.nio.ByteBuffer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StreamingPlayer";

    private PlayThread playThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (playThread != null) {
                            playThread.stopPlaying();
                        }

                        playThread = new PlayThread("https://streams.calmradio.com/api/31/128/stream");
                        playThread.start();
                    }
                }).start();

            }
        });

        findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        playThread.pausePlaying();
                    }
                }).start();

            }
        });

        findViewById(R.id.resume).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        playThread.resumePlaying();
                    }
                }).start();

            }
        });

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        playThread.stopPlaying();
                    }
                }).start();

            }
        });
    }


}
