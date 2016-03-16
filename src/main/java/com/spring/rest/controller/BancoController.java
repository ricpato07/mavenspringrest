package com.spring.rest.controller;

import com.spring.persistence.CatBancos;
import com.spring.rest.service.BancoService;
import java.util.List;
import javax.annotation.Resource;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author USUARIO
 */
@Controller
public class BancoController {

    @Resource
    private BancoService bancoService;

    @RequestMapping(value = "/bancos", method = RequestMethod.POST,
            headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String add(@RequestBody CatBancos banco) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("POST method");
        try {
            System.out.println("banco method:" + banco.getSbanco());
            bancoService.add(banco);
            return mapper.writeValueAsString(banco);
        } catch (Exception e) {
            System.out.println("error method:" + e.getMessage());
        }
        return mapper.writeValueAsString(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }
    
    @RequestMapping(value = "/bancos", method = RequestMethod.GET)
    @ResponseBody
    private String list(@RequestParam(value = "nombre", required = false) String nombre) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("GET method");
        try {
            CatBancos banco = new CatBancos();
            banco.setSbanco(nombre);
            List<CatBancos> result = bancoService.list(banco);
            if (result != null) {
                return mapper.writeValueAsString(result);
            } else {
                return mapper.writeValueAsString(new ResponseEntity(HttpStatus.NOT_FOUND));
            }
        } catch (Exception e) {
            System.out.println("error method:" + e.getMessage());
        }
        return mapper.writeValueAsString(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }

    @RequestMapping(value = "/bancos/{id}", method = RequestMethod.GET)
            //headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String get(@PathVariable("id") int id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("GET method id:"+id);
        try {
            CatBancos result = bancoService.get(id);
            if (result != null) {
                return mapper.writeValueAsString(result);
            } else {
                return mapper.writeValueAsString(new ResponseEntity(HttpStatus.NOT_FOUND));
            }
        } catch (Exception e) {
            System.out.println("error method:" + e.getMessage());
        }
        return mapper.writeValueAsString(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }
    
    @RequestMapping(value = "/bancos/{id}", method = RequestMethod.PUT,
            headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String update(@PathVariable("id") Long id, @RequestBody CatBancos banco) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("PUT method");
        try {
            bancoService.update(banco);
            return mapper.writeValueAsString(new ResponseEntity(HttpStatus.OK));
        } catch (Exception e) {
            System.out.println("error method:" + e.getMessage());
        }
        return mapper.writeValueAsString(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }

    @RequestMapping(value = "/bancos/{id}", method = RequestMethod.DELETE,
            headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String delete(@PathVariable("id") int id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("DELETE method");
        try {
            bancoService.delete(id);
            return mapper.writeValueAsString(new ResponseEntity(HttpStatus.OK));
        } catch (Exception e) {
            System.out.println("error method:" + e.getMessage());
        }
        return mapper.writeValueAsString(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }

}
