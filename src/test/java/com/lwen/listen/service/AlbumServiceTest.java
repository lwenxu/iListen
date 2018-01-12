package com.lwen.listen.service;

import org.junit.Test;


public class AlbumServiceTest {
    private AlbumService service = new AlbumService();

    @Test
    public void jsonToBean() {

    }

    @Test
    public void getMusicByAlbumId() {
        service.getMusicJsonByAlbumId(17918L);

    }

    @Test
    public void getMusicListByAlbumId() {
        System.out.println(service.getMusicListByAlbumId(17918L));
    }

    @Test
    public void getAlbumListByArtistId() {
        service.getAlbumListByArtistId(12L);
    }
}
