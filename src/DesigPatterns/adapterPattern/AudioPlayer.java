package DesigPatterns.adapterPattern;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3"))
            System.out.println("播放mp3：" + fileName);
        else if (audioType.equalsIgnoreCase("VLC")
                || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }else{
            System.out.println("不支持"+audioType+"格式");

        }
    }
}
