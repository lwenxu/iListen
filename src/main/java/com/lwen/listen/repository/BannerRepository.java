package com.lwen.listen.repository;


import com.lwen.listen.entity.Album;
import com.lwen.listen.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BannerRepository extends JpaRepository<Album, Long> {

    List<Banner> findAllBy();
}
