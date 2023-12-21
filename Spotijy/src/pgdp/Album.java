package pgdp;

import java.util.Random;

public class Album {
    private String title;
    private int releaseYear;
    private Song[] songs;
    private int numOfSongs;

    public Album(String title, int releaseYear){
        this.title = title;
        this.releaseYear = releaseYear;
        this.songs = new Song[numOfSongs];
        this.numOfSongs =0;
    }

    public String getTitle() {
        return this.title;
    }
    public int getReleaseYear() {
        return this.releaseYear;
    }
    public Song[] getSongs() {
        return this.songs;
    }

    public int addSongs(Song[] songs) {
        int newSongs = 0;
        for(Song song : songs){
            if(!containsSong(song)) {
                newSongs++;
                Song[] newAlbum = new Song[songs.length+1];
                System.arraycopy(songs, 0, newAlbum, 0, songs.length);
                newAlbum[newAlbum.length-1] = song;
            }
        }
        return newSongs;
    }

    private boolean containsSong (Song song){
        for(Song el : songs){
            if(el.isEqual(song)) return true;
        }
        return false;
    }

    public static Song[] reverse(Song[] songs){
        int start = 0;
        int end = songs.length - 1;
        while (start < end) {
            Song temp = songs[start];
            songs[start] = songs[end];
            songs[end] = temp;
            start++;
            end--;
        }
        return songs;
    }

    public Song[] shuffle() {
        Random random = new Random();
        Song[] shuffled = songs.clone();
        for(int i = getSongs().length-1; i > 0; i--){
            int j = random.nextInt(i+1);

            Song temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }
        return shuffled;
    }




    private Song[] sMergeSort(Song[] songs){
        if(songs.length < 2) return songs;

        int middle = songs.length / 2;
        Song[] left = new Song[middle];
        Song[] right = new Song[songs.length - middle];
        System.arraycopy(songs, 0, left, 0, middle);
        System.arraycopy(songs, middle, right, 0, songs.length - middle);

        sMergeSort(left);
        sMergeSort(right);

        return sMerge(left, right, songs);
    }
    private Song[] sMerge(Song[] left, Song[] right, Song[] songs){
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length){
            if((left[i].getTitle().compareTo(right[j].getTitle()) < 0)){
                songs[k] = left[i];
                i++;
                k++;

            }else {
                songs[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length){
            songs[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            songs[k] = right[j];
            j++;
            k++;
        }
        return songs;
    }

    public Song[] sortByTitle(boolean isAscending){
        if(isAscending) return sMergeSort(songs);
        else return reverse(sMergeSort(songs));
    }




    private Song[] mergeSort(Song[] arr){
        if(arr.length < 2) return arr;

        int middle = arr.length / 2;
        Song[] left = new Song[middle];
        Song[] right = new Song[arr.length - middle];

        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0,  arr.length-middle);

        mergeSort(left);
        mergeSort(right);

        return merge(left, right, arr);
    }

    private Song[] merge (Song[] l, Song[] r, Song[] arr){
        int i = 0, j = 0, k = 0;

        while(i < l.length && j < r.length){
            if(l[i].getDuration() < r[j].getDuration()){
                arr[k] = l[i];
                i++;

            }else{
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < l.length){
            arr[k] = l[i];
            i++;
            k++;
        }
        while (j < r.length) {
            arr[k] = r[j];
            j++;
            k++;
        }
        return arr;
    }

    public Song[] sortByDuration(boolean isAscending){
        if(isAscending) return mergeSort(songs);
        else return reverse(mergeSort(songs));
    }





    private Song[] yMergeSort(Song[] arr){
        if(arr.length < 2) return arr;

        int middle = arr.length / 2;
        Song[] left = new Song[middle];
        Song[] right = new Song[arr.length - middle];

        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0,  arr.length-middle);

        yMergeSort(left);
        yMergeSort(right);

        return yMerge(left, right, arr);
    }

    private Song[] yMerge (Song[] l, Song[] r, Song[] arr){
        int i = 0, j = 0, k = 0;

        while(i < l.length && j < r.length){
            if(l[i].getReleaseYear() < r[j].getReleaseYear()){
                arr[k] = l[i];
                i++;

            }else{
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < l.length){
            arr[k] = l[i];
            i++;
            k++;
        }
        while (j < r.length) {
            arr[k] = r[j];
            j++;
            k++;
        }
        return arr;
    }

    public Song[] sortByReleaseYear(boolean isAscending){
        if(isAscending) return yMergeSort(songs);
        else return reverse(yMergeSort(songs));
    }



    private Song[] lMergeSort(Song[] arr){
        if(arr.length < 2) return arr;

        int middle = arr.length / 2;
        Song[] left = new Song[middle];
        Song[] right = new Song[arr.length - middle];

        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0,  arr.length-middle);

        lMergeSort(left);
        lMergeSort(right);

        return lMerge(left, right, arr);
    }

    private Song[] lMerge (Song[] l, Song[] r, Song[] arr){
        int i = 0, j = 0, k = 0;

        while(i < l.length && j < r.length){
            if(l[i].getLikes() < r[j].getLikes()){
                arr[k] = l[i];
                i++;

            }else{
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < l.length){
            arr[k] = l[i];
            i++;
            k++;
        }
        while (j < r.length) {
            arr[k] = r[j];
            j++;
            k++;
        }
        return arr;
    }
    public Song[] sortByPopularity(boolean isAscending){
        if(isAscending) return lMergeSort(songs);
        else return reverse(lMergeSort(songs));
    }



    public String toString(){
//        'Title:{title},Release year:{release year},songs:{{song1}|{song2}|{song3}…}
        StringBuilder songss = new StringBuilder();
        songss.append("{");
        for(int i = 0; i < songs.length; i++){
            if(i != songs.length-1){
                songss.append("{").append(songs[i].toString()).append("}|");
            } else {
                songss.append("{").append(songs[i].toString()).append("}}");
            }
        }

        return "'Title:" + getTitle()+ ",Release year:" + getReleaseYear() + ",songs:" + songss;

    }
}