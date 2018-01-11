package com.lwen.listen.dao;


import com.lwen.listen.entity.Album;
import com.lwen.listen.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlbumDao {
    @Autowired
    private AlbumRepository repository;

    public Album saveAlbum(Album album) {
        return repository.save(album);
    }

    public List<Album> findByName(String name) {
        return repository.findByNameLike("%"+name+"%");
    }

    // public List<Album> findMusicByName(String name) {
    //     return repository.findByName(name);
    // }
    //
    // public Album findMusicById(Long id) {
    //     return repository.findById(id);
    // }

}
