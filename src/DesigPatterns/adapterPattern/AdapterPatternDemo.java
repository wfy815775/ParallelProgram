package DesigPatterns.adapterPattern;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","花海");
        audioPlayer.play("MP4","头号玩家");
        audioPlayer.play("vlc","这是什么格式？");
        audioPlayer.play("flv","变形金刚5");
    }
}
