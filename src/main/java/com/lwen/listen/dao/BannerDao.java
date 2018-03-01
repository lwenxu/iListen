package com.lwen.listen.dao;


import com.lwen.listen.entity.Album;
import com.lwen.listen.entity.Banner;
import com.lwen.listen.repository.AlbumRepository;
import com.lwen.listen.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BannerDao {
    @Autowired
    private BannerRepository repository;

    public List<Banner> findAllBanner(){
        return repository.findAllBy();
    }
}
