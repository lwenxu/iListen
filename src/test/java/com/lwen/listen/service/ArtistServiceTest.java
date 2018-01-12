package com.lwen.listen.service;

import org.junit.Test;

public class ArtistServiceTest {
    private ArtistService artistService = new ArtistService();

    @Test
    public void jsonToBeanList() {
    }

    @Test
    public void jsonToBean() {
    }

    @Test
    public void getArtistJsonId() {
        System.out.println(artistService.getArtistJsonId(9606L));
    }

    @Test
    public void getArtistById() {
        System.out.println(artistService.getArtistById(9606L));
    }
}
