package com.spring.dao;

import com.spring.persistence.CatBancos;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CatBancosDAO {

    public void save(CatBancos cat)throws Exception;

    public void update(CatBancos cat)throws Exception;

    public void delete(CatBancos cat)throws Exception;

    public CatBancos get(CatBancos cat)throws Exception;

    public List<CatBancos> list(CatBancos cat)throws Exception;
}
