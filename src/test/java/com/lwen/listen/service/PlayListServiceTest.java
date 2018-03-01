package com.lwen.listen.service;


import org.junit.Test;

public class PlayListServiceTest {

    private PlayListService playListService = new PlayListService();

    @Test
    public void getPlayListDetailByPlayListId() {
        System.out.println(playListService.getPlayListDetailByPlayListId("3778678"));;
    }

    @Test
    public void getTopLists() {
        System.out.println(playListService.getTopPlayLists());;
    }
}
