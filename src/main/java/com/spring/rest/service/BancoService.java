package com.spring.rest.service;

import com.spring.dao.CatBancosDAO;
import com.spring.persistence.CatBancos;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class BancoService {

    @Resource
    private CatBancosDAO bancosDAO;

    public List<CatBancos> list(CatBancos banco) {
        try {
            return bancosDAO.list(banco);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
        return null;
    }

    public CatBancos get(int id) {
        try {
            CatBancos banco = new CatBancos();
            banco.setIdBanco(id);
            return bancosDAO.get(banco);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
        return null;
    }

    public void add(CatBancos cat) {
        try {
            bancosDAO.save(cat);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public void update(CatBancos cat) {
        try {
            bancosDAO.update(cat);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            CatBancos banco = get(id);
            bancosDAO.delete(banco);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}
