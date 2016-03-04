package com.spring.rest.controller;

import com.spring.rest.domain.Person;
import com.spring.rest.domain.PersonList;
import com.spring.rest.service.PersonService;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author USUARIO
 */
@Controller
public class PersonController {

    protected static Logger logger = Logger.getLogger("controller");

    @Resource(name = "personService")
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET,
            headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String getall() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("getall method");
            PersonList result = new PersonList();
            result.setData(personService.getAll());
            return mapper.writeValueAsString(result);
        } catch (Exception e) {
            System.out.println("error method:" + e.getMessage());
//            e.printStackTrace();
        }
        return mapper.writeValueAsString(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET,
            headers = "Accept=application/xml,application/json")
    @ResponseBody
    private Person getPerson(@PathVariable("id") Long id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("id:" + id);
            logger.debug("method GET");
            return personService.get(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST,
            headers = "Accept=application/xml,application/json")
    private @ResponseBody
    String addPerson(@RequestBody Person person) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("WebService: add person");
            personService.add(person);
//Object to JSON in file
            return mapper.writeValueAsString(new ResponseEntity(HttpStatus.CREATED));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.PUT,
            headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Método update");
//            return String.valueOf(new ResponseEntity(HttpStatus.OK));
            return mapper.writeValueAsString(new ResponseEntity(HttpStatus.OK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE,
            headers = "Accept=application/xml,application/json")
    @ResponseBody
    private String deletePerson(@PathVariable("id") Long id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("delete new person: " + id);
            System.out.println("Delete method");
            return mapper.writeValueAsString(new ResponseEntity(HttpStatus.OK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(new ResponseEntity(HttpStatus.METHOD_FAILURE));
    }

}
