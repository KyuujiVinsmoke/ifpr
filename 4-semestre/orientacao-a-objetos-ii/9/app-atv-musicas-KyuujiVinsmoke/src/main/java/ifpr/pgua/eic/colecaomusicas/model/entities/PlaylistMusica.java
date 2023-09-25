package ifpr.pgua.eic.colecaomusicas.model.entities;

public class PlaylistMusica {
    private int id;
    private Musica musica;
    private Playlist playlist;
    
    public PlaylistMusica(int id, Musica musica, Playlist playlist) {
        this.id = id;
        this.musica = musica;
        this.playlist = playlist;
    }

    public PlaylistMusica(Musica musica, Playlist playlist) {
        this.musica = musica;
        this.playlist = playlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public  Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}