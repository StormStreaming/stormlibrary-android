package com.stormstreaming.librarysample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.stormstreaming.stormlibrary.StormGateway;
import com.stormstreaming.stormlibrary.StormLibrary;
import com.stormstreaming.stormlibrary.model.StormGatewayServer;
import com.stormstreaming.stormlibrary.model.StormMediaItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        BASIC EMBED EXAMPLE:
         */

        StormLibrary stormLibrary = new StormLibrary();

        stormLibrary.initExoPlayer(this, findViewById(R.id.exoPlayerView));

        StormMediaItem stormMediaItem = new StormMediaItem("stormdev.web-anatomy.com",443, true, "test_hd","320p");
        stormLibrary.addMediaItem(stormMediaItem, true);

        stormMediaItem = new StormMediaItem("sub1.mydomain.com",443,true,"my_stream_720","720p");
        stormLibrary.addMediaItem(stormMediaItem, false);

        try {
            stormLibrary.prepare(false);
        } catch(Exception e){
            e.printStackTrace();
        }

        Button add = findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //StormMediaItem m = new StormMediaItem("stormdev.web-anatomy.com", 443, true, "test_hd", "4K");
                //stormLibrary.addMediaItem(m, true);

                //List<StormMediaItem> m = stormLibrary.getStormMediaItems();
                //stormLibrary.removeMediaItem(m.get(0));
                stormLibrary.clearStormMediaItems();
                StormGateway stormGateway = stormLibrary.initStormGateway("test");

                StormGatewayServer server = new StormGatewayServer("stormdev.web-anatomy.com","live", 443, true);
                stormGateway.addStormGatewayServer(server);

                try{

                    stormLibrary.prepare(false);

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        try {
            stormLibrary.prepare(false);
        } catch(Exception e){
            e.printStackTrace();
        }

        Button play = findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("Play");
                stormLibrary.play();

            }
        });

        Button pause = findViewById(R.id.pauseButton);
        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("Pause");
                stormLibrary.pause();

            }
        });


        /*
        GATEWAY EXAMPLE:
         */

        /*
        StormLibrary stormLibrary = new StormLibrary();
        stormLibrary.initExoPlayer(this, findViewById(R.id.exoPlayerView));

        StormGateway stormGateway = stormLibrary.initStormGateway("test");

        StormGatewayServer server = new StormGatewayServer("sub1.domain.com","live", 443, true);
        stormGateway.addStormGatewayServer(server);

        StormGatewayServer server2 = new StormGatewayServer("sub2.domain.com","live", 443, true);
        stormGateway.addStormGatewayServer(server2);

        try {
            stormLibrary.prepare(true);
        } catch(Exception e){
            e.printStackTrace();
        }
        */

    }
}