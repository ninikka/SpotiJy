package pgdp;

public class Song {
    private String title;
    private int releaseYear;
    private int duration;
    private int likes;

    public Song(String title, int releaseYear, int duration, int likes){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public Song(String title, int releaseYear){
        this(title, releaseYear, 60, 0);
    }

    public Song(String title, int releaseYear, int duration){
        this(title, releaseYear, duration, 0);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public int getLikes() {
        return likes;
    }

    public boolean changeDuration(int duration){
        if(duration < 0 || duration > 720 || this.duration == duration) return false;
        else {
            this.duration = duration;
            return true;
        }
    }

    public void like() {
        this.likes += 1;
    }

    public void unlike() {
        if(this.likes > 0) this.likes -= 1;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + ", Duration: " + (double)this.duration / 60.0 + ", Release year: " +
                this.releaseYear + " Likes: " + this.likes;
    }

    public boolean isEqual(Song other){
        return (this.title.equals(other.title) && this.releaseYear == other.releaseYear
                && this.duration == other.duration);
    }

    public static void main(String[] args) {
        Song snakeJazz = new Song("Snake Jazz", 1989, 30);
        snakeJazz.like();
        snakeJazz.unlike();
        System.out.println(snakeJazz.toString());
    }
}
