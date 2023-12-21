package pgdp;

public class SpotiJy {
    private Artist[] artists;
    public SpotiJy() {
        this.artists = new Artist[0];
    }
    public Artist[] getArtists() {
        return this.artists;
    }
    public void addArtists(Artist[] artists){
        for(Artist artist : artists){
            for (Artist artist1 : getArtists()){
                if(!artist1.isEqual(artist)){
                    Artist[] nArtists = new Artist[getArtists().length+1];
                    System.arraycopy(getArtists(), 0, nArtists, 0, getArtists().length);
                    nArtists[nArtists.length-1] = artist;
                }
            }
        }
    }
}
