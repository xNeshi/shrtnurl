package com.xneshi.shrtnurl.respository;

import com.xneshi.shrtnurl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;

public interface UrlRepository extends JpaRepository<Url, UID> {
}
