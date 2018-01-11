package com.lwen.listen.dao;


import com.lwen.listen.entity.Artist;
import com.lwen.listen.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistDao {
    @Autowired
    private ArtistRepository repository;

    public Artist saveArtist(Artist artist) {
        return repository.save(artist);
    }


    public List<Artist> findByName(String name) {
        return repository.findByNameLike("%"+name+"%");
    }


    public Artist findById(Long id) {
        return repository.findById(id);
    }

}
