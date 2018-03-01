package com.lwen.listen.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class MusicServiceTest {
    MusicService musicService = new MusicService();

    @Test
    public void getMusicDetailById() throws Exception {
        System.out.println(musicService.getMusicDetailById("479938834"));
    }


}
