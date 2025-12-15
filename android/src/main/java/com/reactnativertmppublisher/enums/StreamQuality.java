package com.reactnativertmppublisher.enums;

// 等级	分辨率	视频码率	音频码率	采样率	声道	适用场景
// LOW	640×480 (480P)	800kbps	64kbps	22.05kHz	单声道	极弱网络、节省流量
// MEDIUM	854×480 (480P)	1.5Mbps	96kbps	44.1kHz	立体声	一般网络、平衡画质
// HIGH	1280×720 (720P)	3Mbps	128kbps	44.1kHz	立体声	良好网络、高清画质
// VERY_HIGH	1920×1080 (1080P)	5Mbps	192kbps	48kHz	立体声	优质网络、超清画质

// 分辨率
public enum StreamQuality {
    LOW(640, 480, 800 * 1024, 64 * 1024, 22050, false),
    MEDIUM(854, 480, 1500 * 1024, 96 * 1024, 44100, true),
    HIGH(1280, 720, 3000 * 1024, 128 * 1024, 44100, true),
    VERY_HIGH(1920, 1080, 5000 * 1024, 192 * 1024, 48000, true);
    
    private final int width;
    private final int height;
    private final int videoBitrate;
    private final int audioBitrate;
    private final int audioSampleRate;
    private final boolean stereo;
    
    StreamQuality(int width, int height, int videoBitrate, int audioBitrate, 
                  int audioSampleRate, boolean stereo) {
        this.width = width;
        this.height = height;
        this.videoBitrate = videoBitrate;
        this.audioBitrate = audioBitrate;
        this.audioSampleRate = audioSampleRate;
        this.stereo = stereo;
    }
    
    // Getter 方法
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getVideoBitrate() { return videoBitrate; }
    public int getAudioBitrate() { return audioBitrate; }
    public int getAudioSampleRate() { return audioSampleRate; }
    public boolean isStereo() { return stereo; }
    
    // 根据字符串获取对应的枚举值
    public static StreamQuality fromString(String quality) {
        if (quality == null) return LOW;
        
        switch (quality.toLowerCase()) {
            case "medium":
                return MEDIUM;
            case "high":
                return HIGH;
            case "very_high":
            case "very high":
                return VERY_HIGH;
            default:
                return LOW;
        }
    }
}