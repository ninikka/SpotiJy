package pgdp;

public class Artist {
    private String firstName;
    private String lastName;
    private int birthYear;
    private Album[] albums;
    private int albumCount;
    private Song[] singles;
    private int singleCount;

    public Artist(String firstName, String lastName, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.singles = new Song[singleCount];
        this.singleCount = 0;
        this.albums = new Album[albumCount];
        this.albumCount = 0;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public Album[] getAlbums() {
        return this.albums;
    }

    public Song[] getSingles() {
        return this.singles;
    }

    public Song mostLikedSong() {
        int max = Integer.MIN_VALUE;
        Song mostPopular = new Song("asd", 1990);
        for(Album album : getAlbums()){
            int c = album.sortByPopularity(false)[0].getLikes();
            if(c > max){
                max = c;
                mostPopular = album.sortByPopularity(false)[0];
            }
        }
        for (Song song : getSingles()){
            if(song.getLikes() > max){
                max = song.getLikes();
                mostPopular = song;
            }
        }
        return mostPopular;
    }
    public Song leastLikedSong(){
        int min = Integer.MAX_VALUE;
        Song leastPopular = new Song("asd", 1990);
        for(Album album : getAlbums()){
            int c = album.sortByPopularity(true)[0].getLikes();
            if(c < min){
                min = c;
                leastPopular = album.sortByPopularity(true)[0];
            }
        }
        for(Song song : getSingles()){
            if(song.getLikes() < min){
                min = song.getLikes();
                leastPopular = song;
            }
        }
        return leastPopular;
    }
    public int totalLikes(){
        int likes = 0;
        for (Album album : getAlbums()){
            for (Song song : album.getSongs()){
                likes += song.getLikes();
            }
        }
        for (Song song : getSingles()){
            likes += song.getLikes();
        }
        return likes;
    }
    public boolean isEqual(Artist other){
        return (this.firstName.equals(other.firstName) && this.lastName.equals(other.lastName) && this.birthYear == other.birthYear);
    }
}