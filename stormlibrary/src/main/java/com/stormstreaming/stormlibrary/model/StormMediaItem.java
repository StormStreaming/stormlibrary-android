package com.stormstreaming.stormlibrary.model;

import android.net.Uri;

import com.google.android.exoplayer2.MediaItem;

public class StormMediaItem {

    private String host;
    private String rtmpHost;
    private String rtmpApplicationName;
    private int port;
    private boolean isSSL;
    private String streamName;
    private String label;
    private String applicationName;
    private boolean isSelected = false;

    public StormMediaItem(String host, int port, boolean isSSL, String applicationName, String streamName, String label){
        this(host, port, isSSL, applicationName, streamName, label, null, null);
    }

    public StormMediaItem(String host, int port, boolean isSSL, String applicationName, String streamName, String label, String rtmpHost, String rtmpApplicationName){
        this.host = host;
        this.rtmpHost = rtmpHost;
        this.rtmpApplicationName = rtmpApplicationName;
        this.port = port;
        this.isSSL = isSSL;
        this.streamName = streamName;
        this.label = label;
        this.applicationName = applicationName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getRtmpApplicationName() {
        return rtmpApplicationName;
    }

    public void setRtmpApplicationName(String rtmpApplicationName) {
        this.rtmpApplicationName = rtmpApplicationName;
    }

    public String getRtmpHost() {
        return rtmpHost;
    }

    public void setRtmpHost(String rtmpHost) {
        this.rtmpHost = rtmpHost;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isSSL() {
        return isSSL;
    }

    public void setSSL(boolean SSL) {
        isSSL = SSL;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public MediaItem getMediaItem(){
        return MediaItem.fromUri(getUri());
    }

    public Uri getUri(){
        if(getRtmpHost() != null)
            return Uri.parse((isSSL() ? "wss" : "ws") + "://" + getHost() + ":" + getPort() + "/"+getApplicationName()+"/"+getStreamName()+"/?url=rtmp%3A%2F%2F"+getRtmpHost()+"%3A1935%2F"+getRtmpApplicationName()+"%2F"+getStreamName()+"&");
        return Uri.parse((isSSL() ? "wss" : "ws") + "://" + getHost() + ":" + getPort() + "/"+getApplicationName()+"/"+getStreamName()+"/?");
    }
}
