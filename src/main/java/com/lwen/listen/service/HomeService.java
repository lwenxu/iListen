package com.lwen.listen.service;

import com.lwen.listen.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeService {
    @Autowired
    protected MusicDao musicDao;
    @Autowired
    protected AlbumDao albumDao;
    @Autowired
    protected ArtistDao artistDao;
    @Autowired
    protected PlayListDao playListDao;
    @Autowired
    protected UserDao userDao;
}
