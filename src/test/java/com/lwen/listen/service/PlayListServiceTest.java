package com.lwen.listen.service;


import org.junit.Test;

public class PlayListServiceTest {

    private PlayListService playListService = new PlayListService(430509126L);

    @Test
    public void getPlayListDetailByPlayListId() {
        playListService.getPlayListDetailByPlayListId();
    }
}
